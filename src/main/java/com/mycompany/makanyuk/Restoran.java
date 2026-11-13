/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 *
 * @author JENY SARAH C SILABAN
 */
public class Restoran {
    private String namaRestoran;
    private DapurRestoran dapurUtama; 
    private ArrayList<Menu> daftarMenu; 
    private HashMap<String, Pelanggan> dataPelanggan; 

    public Restoran(String namaRestoran) {
        this.namaRestoran = namaRestoran;
        this.dapurUtama = new DapurRestoran("Dapur Utama Chef Jeny", 5);
        this.daftarMenu = new ArrayList<>();
        this.dataPelanggan = new HashMap<>();
    }

    public void bukaRestoran() {
        System.out.println("\n=== MENGINISIALISASI SISTEM " + namaRestoran.toUpperCase() + " ===");
        dapurUtama.infoDapur();
    }

    public void simpanDataKeFile() {
        try (FileOutputStream fileKeluar = new FileOutputStream("data_makanyuk.dat");
             ObjectOutputStream mesinPembeku = new ObjectOutputStream(fileKeluar)) {
            
            mesinPembeku.writeObject(this.daftarMenu);
            mesinPembeku.writeObject(this.dataPelanggan);
            
            System.out.println("-> [SYSTEM LOG] Seluruh data restoran berhasil disimpan (Serialization) ke Harddisk!");
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal menyimpan data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void muatDataDariFile() {
        try {
            File cekFile = new File("data_makanyuk.dat");
            if (!cekFile.exists()) return; 

            try (FileInputStream fileMasuk = new FileInputStream(cekFile);
                 ObjectInputStream mesinPembangkit = new ObjectInputStream(fileMasuk)) {
                
                this.daftarMenu = (ArrayList<Menu>) mesinPembangkit.readObject();
                this.dataPelanggan = (HashMap<String, Pelanggan>) mesinPembangkit.readObject();
                
                Menu.totalMenuDibuat = this.daftarMenu.size();
                System.out.println("-> [SYSTEM LOG] Data restoran berhasil dimuat ulang dari penyimpanan (Deserialization).");
            }
        } catch (Exception e) {
            System.out.println("-> [SYSTEM ERROR] Gagal memuat data: " + e.getMessage());
        }
    }

    public void bacaLogTransaksi() {
        System.out.println("\n--- Riwayat Log Transaksi Restoran ---");
        try {
            File fileLog = new File("log_transaksi.txt");
            if (!fileLog.exists()) {
                System.out.println("Belum ada file log transaksi yang tercatat.");
                return;
            }
            Scanner mesinBaca = new Scanner(fileLog);
            while (mesinBaca.hasNextLine()) {
                System.out.println(mesinBaca.nextLine());
            }
            mesinBaca.close();
        } catch (FileNotFoundException e) {
            System.out.println("Gagal membaca file log transaksi.");
        }
    }

    public void tambahMenu(Menu m) {
        daftarMenu.add(m);
        System.out.println("Sukses! Menu baru berhasil ditambahkan. (Total Menu: " + daftarMenu.size() + ")");
    }

    public void tambahPelanggan(Pelanggan p) {
        dataPelanggan.put(p.getIdPelanggan(), p);
        System.out.println("Berhasil mendaftarkan pelanggan baru!");
    }

    public void lihatSemuaMenu() {
        if (daftarMenu.isEmpty()) {
            System.out.println("Belum ada menu yang tersimpan.");
            return;
        }
        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarMenu.get(i).tampilkanInfo();
        }
    }

    public void cariMenu(String nama) throws MenuTidakDitemukanException {
        System.out.println("\nMencari Menu dengan Nama: " + nama);
        boolean ditemukan = false;
        for (Menu m : daftarMenu) {
            if (m.getNama().equalsIgnoreCase(nama)) {
                m.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new MenuTidakDitemukanException("Gagal: Menu dengan nama \"" + nama + "\" tidak terdaftar di sistem.");
        }
    }

    public void cariPelanggan(String id) {
        if (dataPelanggan.containsKey(id)) {
            System.out.println("Ditemukan! Nama Pelanggan: " + dataPelanggan.get(id).getNama());
        } else {
            System.out.println("Pelanggan dengan ID tersebut tidak terdaftar.");
        }
    }

    public void lihatSemuaPelanggan() {
        System.out.println("Total Pelanggan Terdaftar: " + dataPelanggan.size());
        for (Pelanggan p : dataPelanggan.values()) {
            System.out.println("- ID: " + p.getIdPelanggan() + " | Nama: " + p.getNama());
        }
    }

    public Pelanggan getPelanggan(String id) {
        return dataPelanggan.get(id);
    }

    public Menu getMenuInt(int index) {
        return daftarMenu.get(index);
    }

    public int getJumlahMenu() {
        return daftarMenu.size();
    }
}
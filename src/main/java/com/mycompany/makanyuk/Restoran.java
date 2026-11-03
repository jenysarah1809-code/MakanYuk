/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author JENY SARAH C SILABAN
 */
public class Restoran {
    private String namaRestoran;
    // Komposisi: Objek dapur tercipta di dalam restoran secara mutlak
    private DapurRestoran dapurUtama;
    
    // Agregasi: Menampung kumpulan menu dan pelanggan secara dinamis
    private ArrayList<Menu> daftarMenu;
    private HashMap<String, Pelanggan> dataPelanggan;

    public Restoran(String namaRestoran) {
        this.namaRestoran = namaRestoran;
        // Inisialisasi Composition (Mutlak milik restoran)
        this.dapurUtama = new DapurRestoran("Dapur Utama Chef Jeny", 5);
        // Inisialisasi Agregasi
        this.daftarMenu = new ArrayList<>();
        this.dataPelanggan = new HashMap<>();
    }

    public void bukaRestoran() {
        System.out.println("\n=== MENGINISIALISASI SISTEM " + namaRestoran.toUpperCase() + " ===");
        dapurUtama.infoDapur();
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

    // Getter untuk keperluan transaksi asosiasi
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

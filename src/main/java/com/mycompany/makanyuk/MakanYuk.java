/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */
import java.util.Scanner;

public class MakanYuk {

    public static void cariMenu(String nama, Menu[] daftarMenu, int jumlahMenu) {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Nama: \"" + nama + "\" ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getNama().equalsIgnoreCase(nama)) {
                System.out.print("> ");
                daftarMenu[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Menu dengan nama tersebut tidak ditemukan.");
        }
    }

    public static void cariMenu(double maxHarga, Menu[] daftarMenu, int jumlahMenu) {
        System.out.println("\n--- Hasil Pencarian Menu dengan Harga Maksimal: Rp " + maxHarga + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < jumlahMenu; i++) {
            if (daftarMenu[i].getHarga() <= maxHarga) {
                System.out.print("> ");
                daftarMenu[i].tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Tidak ada menu yang sesuai dengan budget tersebut.");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Menu[] daftarMenu = new Menu[10];
            int jumlahMenu = 0;
            boolean isRunning = true;

            System.out.println("==================================================");
            System.out.println("         SELAMAT DATANG DI MAKANYUK         ");
            System.out.println("==================================================");

            while (isRunning) {
                System.out.println("\n================ MENU UTAMA ================");
                System.out.println("1. Tambah Menu Baru");
                System.out.println("2. Lihat Seluruh Daftar Menu");
                System.out.println("3. Cari Menu");
                System.out.println("4. Keluar");
                System.out.print("Pilih Menu (1-4): ");

                int pilihan = scanner.nextInt();
                scanner.nextLine(); 

                switch (pilihan) {
                    case 1:
                        if (jumlahMenu < daftarMenu.length) {
                            System.out.println("\n--- Pilih Kategori Menu ---");
                            System.out.println("1. Makanan");
                            System.out.println("2. Minuman");
                            System.out.print("Pilih Kategori (1/2): ");
                            int jenis = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Masukkan Nama Menu       : ");
                            String namaBaru = scanner.nextLine();

                            System.out.print("Masukkan Harga (Rp)      : ");
                            double hargaBaru = scanner.nextDouble();
                            scanner.nextLine();

                            System.out.print("Masukkan Stok            : ");
                            int stokBaru = scanner.nextInt();
                            scanner.nextLine();

                            if (jenis == 1) {
                                System.out.print("Masukkan Level Pedas(1/2/3): ");
                                String pedas = scanner.nextLine();
                                daftarMenu[jumlahMenu] = new Makanan(namaBaru, hargaBaru, stokBaru, pedas);
                            } else if (jenis == 2) {
                                System.out.print("Masukkan Ukuran (Reg/Lrg)  : ");
                                String ukuran = scanner.nextLine();
                                daftarMenu[jumlahMenu] = new Minuman(namaBaru, hargaBaru, stokBaru, ukuran);
                            } else {
                                System.out.println("Kategori tidak valid! Menu batal disimpan.");
                                break;
                            }

                            jumlahMenu++;
                            System.out.println("\n[Sukses] Menu baru berhasil ditambahkan ke sistem!");
                        } else {
                            System.out.println("\n[Maaf] Kapasitas penyimpanan menu restoran penuh!");
                        }
                        break;

                    case 2:
                        System.out.println("\n================ DAFTAR MENU MAKANYUK ================");
                        if (jumlahMenu == 0) {
                            System.out.println("Belum ada menu yang tersimpan di sistem.");
                        } else {
                            for (int i = 0; i < jumlahMenu; i++) {
                                System.out.print((i + 1) + ". ");
                                daftarMenu[i].tampilkanInfo(); 
                            }
                            System.out.println("\n* Total Objek Menu Berhasil Dibuat: " + Menu.totalMenuDibuat);
                        }
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 3:
                        System.out.println("\n--- Menu Pencarian ---");
                        System.out.println("1. Cari Berdasarkan Nama Menu");
                        System.out.println("2. Cari Berdasarkan Budget Harga Maksimal");
                        System.out.print("Pilih Mode Pencarian (1/2): ");
                        int modeCari = scanner.nextInt();
                        scanner.nextLine();

                        if (modeCari == 1) {
                            System.out.print("Masukkan Nama Menu: ");
                            String kataKunci = scanner.nextLine();
                            cariMenu(kataKunci, daftarMenu, jumlahMenu); 
                        } else if (modeCari == 2) {
                            System.out.print("Masukkan Maksimal Harga (Rp): ");
                            double budget = scanner.nextDouble();
                            scanner.nextLine();
                            cariMenu(budget, daftarMenu, jumlahMenu); 
                        } else {
                            System.out.println("Pilihan mode pencarian tidak valid.");
                        }

                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 4:
                        System.out.println("\nTerima kasih telah menggunakan MakanYuk. Sampai jumpa!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("\nPilihan menu tidak valid, silakan masukkan angka 1 sampai 4.");
                        break;
                }
            }
        }
    }
}

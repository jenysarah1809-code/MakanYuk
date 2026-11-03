/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.makanyuk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author JENY SARAH C SILABAN
 */

public class MakanYuk {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Menginisialisasi objek utama Restoran (menerapkan Composition & Aggregation di dalamnya)
        Restoran restoKu = new Restoran("MakanYuk Resto Lampung");
        restoKu.bukaRestoran();

        boolean isRunning = true;

        try {
            // Inisialisasi data awal menu (ArrayList)
            restoKu.tambahMenu(new Makanan("Nasi Goreng", 25000, 10, "Level 2"));
            restoKu.tambahMenu(new Minuman("Es Teh Manis", 5000, 25, "Regular"));
            restoKu.tambahMenu(new Dessert("Pudding Coklat", 12000, 15, "Manis"));

            // Inisialisasi data awal pelanggan (HashMap)
            restoKu.tambahPelanggan(new Pelanggan("P001", "Jeny Sarah"));
            restoKu.tambahPelanggan(new Pelanggan("P002", "Budi Santoso"));
        } catch (Exception e) {
            System.out.println("Error Inisialisasi: " + e.getMessage());
        }

        System.out.println("==================================================");
        System.out.println("          SELAMAT DATANG DI MAKANYUK              ");
        System.out.println("==================================================");

        while (isRunning) {
            try {
                System.out.println("\n================ MENU UTAMA ================");
                System.out.println("1. Tambah Menu Baru");
                System.out.println("2. Lihat Daftar Menu");
                System.out.println("3. Cari Menu (Demo Custom Exception)");
                System.out.println("4. Kelola Pelanggan (Demo HashMap)");
                System.out.println("5. Transaksi Pesanan (Demo Association)");
                System.out.println("6. Keluar");
                System.out.print("Pilih Menu (1-6): ");

                int pilihan = scanner.nextInt();
                scanner.nextLine(); 

                switch (pilihan) {
                    case 1:
                        System.out.println("\n--- Pilih Kategori Menu ---");
                        System.out.println("1. Makanan");
                        System.out.println("2. Minuman");
                        System.out.println("3. Dessert");
                        System.out.print("Pilih Kategori (1/2/3): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Masukkan Nama Menu         : ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan Harga (Rp)        : ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Masukkan Stok              : ");
                        int stok = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Level Pedas       : ");
                            restoKu.tambahMenu(new Makanan(nama, harga, stok, scanner.nextLine()));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Ukuran (Reg/Lrg)  : ");
                            restoKu.tambahMenu(new Minuman(nama, harga, stok, scanner.nextLine()));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Karakter Rasa     : ");
                            restoKu.tambahMenu(new Dessert(nama, harga, stok, scanner.nextLine()));
                        } else {
                            System.out.println("Kategori tidak valid!");
                        }
                        break;

                    case 2:
                        System.out.println("\n================ DAFTAR MENU RESTORAN ================");
                        restoKu.lihatSemuaMenu();
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 3:
                        System.out.println("\n--- Fitur Cari Menu (Custom Exception) ---");
                        System.out.print("Masukkan Nama Menu yang dicari: ");
                        String kataKunci = scanner.nextLine();
                        try {
                            restoKu.cariMenu(kataKunci);
                        } catch (MenuTidakDitemukanException e) {
                            System.out.println("[PERINGATAN] " + e.getMessage());
                        }
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 4:
                        System.out.println("\n--- Kelola Pelanggan (HashMap) ---");
                        System.out.println("1. Tambah Pelanggan");
                        System.out.println("2. Cari Pelanggan via ID");
                        System.out.println("3. Lihat Semua Pelanggan");
                        System.out.print("Pilih (1-3): ");
                        int menuP = scanner.nextInt();
                        scanner.nextLine();

                        if (menuP == 1) {
                            System.out.print("Masukkan ID Pelanggan: ");
                            String id = scanner.nextLine();
                            System.out.print("Masukkan Nama Pelanggan: ");
                            String namaP = scanner.nextLine();
                            restoKu.tambahPelanggan(new Pelanggan(id, namaP));
                        } else if (menuP == 2) {
                            System.out.print("Masukkan ID yang dicari: ");
                            restoKu.cariPelanggan(scanner.nextLine());
                        } else if (menuP == 3) {
                            restoKu.lihatSemuaPelanggan();
                        }
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 5:
                        System.out.println("\n--- Sistem Transaksi Pesanan (Association) ---");
                        System.out.print("Masukkan ID Pelanggan: ");
                        String inputId = scanner.nextLine();
                        Pelanggan pembeli = restoKu.getPelanggan(inputId);

                        if (pembeli == null) {
                            System.out.println("Gagal: Pelanggan dengan ID tersebut belum terdaftar!");
                        } else if (restoKu.getJumlahMenu() == 0) {
                            System.out.println("Gagal: Belum ada menu yang tersedia untuk dipesan.");
                        } else {
                            restoKu.lihatSemuaMenu();
                            System.out.print("Pilih Nomor Menu yang ingin dipesan: ");
                            int noMenu = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noMenu >= 0 && noMenu < restoKu.getJumlahMenu()) {
                                Menu menuDipilih = restoKu.getMenuInt(noMenu);
                                // Menerapkan relasi Asosiasi pada method prosesPesan
                                TransaksiPesan.prosesPesan(pembeli, menuDipilih);
                            } else {
                                System.out.println("Nomor menu tidak valid!");
                            }
                        }
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 6:
                        System.out.println("\nTerima kasih telah menggunakan sistem MakanYuk!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Pilihan menu tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT] Harap masukkan format angka yang valid!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\n[SYSTEM ERROR] " + e.getMessage());
            }
        }
        scanner.close();
    }
}
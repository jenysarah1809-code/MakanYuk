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
        Restoran restonyaJeny = new Restoran("MakanYuk Resto Lampung");
        restonyaJeny.bukaRestoran();

        restonyaJeny.muatDataDariFile();

        boolean isRunning = true;

        System.out.println("==================================================");
        System.out.println("          SELAMAT DATANG DI MAKANYUK              ");
        System.out.println("==================================================");

        while (isRunning) {
            try {
                System.out.println("\n================ MENU UTAMA ================");
                System.out.println("1. Tambah Menu Baru");
                System.out.println("2. Lihat Daftar Menu");
                System.out.println("3. Cari Menu (Custom Exception)");
                System.out.println("4. Kelola Pelanggan (HashMap)");
                System.out.println("5. Transaksi Pesanan (Association)");
                System.out.println("6. Baca File Log Transaksi (File I/O Teks)");
                System.out.println("7. Simpan & Keluar (Serialization)");
                System.out.print("Pilih Menu (1-7): ");

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
                            restonyaJeny.tambahMenu(new Makanan(nama, harga, stok, scanner.nextLine()));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Ukuran (Reg/Lrg)  : ");
                            restonyaJeny.tambahMenu(new Minuman(nama, harga, stok, scanner.nextLine()));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Karakter Rasa     : ");
                            restonyaJeny.tambahMenu(new Dessert(nama, harga, stok, scanner.nextLine()));
                        }
                        break;

                    case 2:
                        System.out.println("\n================ DAFTAR MENU RESTORAN ================");
                        restonyaJeny.lihatSemuaMenu();
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 3:
                        System.out.println("\n--- Fitur Cari Menu ---");
                        System.out.print("Masukkan Nama Menu yang dicari: ");
                        try {
                            restonyaJeny.cariMenu(scanner.nextLine());
                        } catch (MenuTidakDitemukanException e) {
                            System.out.println("[PERINGATAN] " + e.getMessage());
                        }
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 4:
                        System.out.println("\n--- Kelola Pelanggan ---");
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
                            restonyaJeny.tambahPelanggan(new Pelanggan(id, namaP));
                        } else if (menuP == 2) {
                            System.out.print("Masukkan ID yang dicari: ");
                            restonyaJeny.cariPelanggan(scanner.nextLine());
                        } else if (menuP == 3) {
                            restonyaJeny.lihatSemuaPelanggan();
                        }
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 5:
                        System.out.println("\n--- Sistem Transaksi Pesanan ---");
                        System.out.print("Masukkan ID Pelanggan: ");
                        String inputId = scanner.nextLine();
                        Pelanggan pembeli = restonyaJeny.getPelanggan(inputId);

                        if (pembeli == null) {
                            System.out.println("Gagal: Pelanggan dengan ID tersebut belum terdaftar!");
                        } else if (restonyaJeny.getJumlahMenu() == 0) {
                            System.out.println("Gagal: Belum ada menu yang tersedia.");
                        } else {
                            restonyaJeny.lihatSemuaMenu();
                            System.out.print("Pilih Nomor Menu yang ingin dipesan: ");
                            int noMenu = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (noMenu >= 0 && noMenu < restonyaJeny.getJumlahMenu()) {
                                Menu menuDipilih = restonyaJeny.getMenuInt(noMenu);
                                TransaksiPesan.prosesPesan(pembeli, menuDipilih);
                            } else {
                                System.out.println("Nomor menu tidak valid!");
                            }
                        }
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 6:
                        restonyaJeny.bacaLogTransaksi();
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 7:
                        System.out.println("\nMenyimpan sesi ke penyimpanan internal...");
                        restonyaJeny.simpanDataKeFile();
                        System.out.println("Terima kasih telah menggunakan sistem MakanYuk!");
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
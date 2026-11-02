/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MakanYuk {

    // Method pencarian menggunakan Custom Exception dan throws
    public static void cariMenu(String nama, ArrayList<Menu> daftarMenu) throws MenuTidakDitemukanException {
        System.out.println("\n--- Hasil Pencarian Berdasarkan Nama: \"" + nama + "\" ---");
        boolean ditemukan = false;
        for (int i = 0; i < daftarMenu.size(); i++) {
            if (daftarMenu.get(i).getNama().equalsIgnoreCase(nama)) {
                System.out.print("> ");
                daftarMenu.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new MenuTidakDitemukanException("Gagal: Menu dengan nama \"" + nama + "\" tidak ditemukan di sistem!");
        }
    }

    public static void cariMenu(double maxHarga, ArrayList<Menu> daftarMenu) throws MenuTidakDitemukanException {
        System.out.println("\n--- Hasil Pencarian Menu dengan Harga Maksimal: Rp " + maxHarga + " ---");
        boolean ditemukan = false;
        for (int i = 0; i < daftarMenu.size(); i++) {
            if (daftarMenu.get(i).getHarga() <= maxHarga) {
                System.out.print("> ");
                daftarMenu.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            throw new MenuTidakDitemukanException("Gagal: Tidak ada menu yang sesuai dengan budget tersebut.");
        }
    }

    public static void simulasiProsesPesanan(Menu menuPilihan) {
        System.out.println("\n--- SIMULASI PROSES TRANSAKSI & PENYAJIAN ---");
        System.out.println("Memproses item: " + menuPilihan.getNama());
        menuPilihan.caraPenyajian(); 
        System.out.println("Status: Pesanan berhasil disiapkan dan diserahkan ke pelanggan!\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Menggunakan ArrayList sesuai modul
        ArrayList<Menu> daftarMenu = new ArrayList<>();
        // Menggunakan HashMap untuk manajemen anggota (Key: ID/Member, Value: Nama)
        HashMap<String, String> dataAnggota = new HashMap<>();
        boolean isRunning = true;

        try {
            // Inisialisasi data objek awal (3-5 data objek)
            daftarMenu.add(new Makanan("Nasi Goreng", 25000, 10, "Level 2"));
            daftarMenu.add(new Minuman("Es Teh Manis", 5000, 25, "Regular"));
            daftarMenu.add(new Dessert("Pudding Coklat", 12000, 15, "Manis"));
            daftarMenu.add(new Makanan("Ayam Geprek", 20000, 8, "Level 3"));

            // Inisialisasi data HashMap awal (2-3 data anggota)
            dataAnggota.put("M001", "Jeny Sarah");
            dataAnggota.put("M002", "Budi Santoso");
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
                System.out.println("2. Lihat Seluruh Daftar Menu");
                System.out.println("3. Cari Menu (Demo Custom Exception)");
                System.out.println("4. Simulasi Proses / Transaksi Pesanan");
                System.out.println("5. Cek Promo Diskon (Interface BisaDiskon)");
                System.out.println("6. Cetak Label Packing (Interface BisaDibungkus)");
                System.out.println("7. Manajemen Anggota (Demo HashMap)");
                System.out.println("8. Keluar");
                System.out.print("Pilih Menu (1-8): ");

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
                        String namaBaru = scanner.nextLine();

                        System.out.print("Masukkan Harga (Rp)        : ");
                        double hargaBaru = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Masukkan Stok              : ");
                        int stokBaru = scanner.nextInt();
                        scanner.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan Level Pedas       : ");
                            String pedas = scanner.nextLine();
                            daftarMenu.add(new Makanan(namaBaru, hargaBaru, stokBaru, pedas));
                        } else if (jenis == 2) {
                            System.out.print("Masukkan Ukuran (Reg/Lrg)  : ");
                            String ukuran = scanner.nextLine();
                            daftarMenu.add(new Minuman(namaBaru, hargaBaru, stokBaru, ukuran));
                        } else if (jenis == 3) {
                            System.out.print("Masukkan Karakter Rasa     : ");
                            String rasa = scanner.nextLine();
                            daftarMenu.add(new Dessert(namaBaru, hargaBaru, stokBaru, rasa));
                        } else {
                            System.out.println("Kategori tidak valid! Menu batal disimpan.");
                            break;
                        }

                        System.out.println("\n[Sukses] Menu baru berhasil ditambahkan! Total Menu: " + daftarMenu.size());
                        break;

                    case 2:
                        System.out.println("\n================ DAFTAR MENU MAKANYUK ================");
                        if (daftarMenu.isEmpty()) {
                            System.out.println("Belum ada menu yang tersimpan di sistem.");
                        } else {
                            for (int i = 0; i < daftarMenu.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarMenu.get(i).tampilkanInfo(); 
                            }
                            System.out.println("\n* Total Objek Menu Berhasil Dibuat: " + Menu.totalMenuDibuat);
                        }
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 3:
                        System.out.println("\n--- Menu Pencarian (Demo Custom Exception & Try-Catch-Finally) ---");
                        System.out.println("1. Cari Berdasarkan Nama Menu");
                        System.out.println("2. Cari Berdasarkan Budget Harga Maksimal");
                        System.out.print("Pilih Mode Pencarian (1/2): ");
                        int modeCari = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            if (modeCari == 1) {
                                System.out.print("Masukkan Nama Menu: ");
                                String kataKunci = scanner.nextLine();
                                cariMenu(kataKunci, daftarMenu); 
                            } else if (modeCari == 2) {
                                System.out.print("Masukkan Maksimal Harga (Rp): ");
                                double budget = scanner.nextDouble();
                                scanner.nextLine();
                                cariMenu(budget, daftarMenu); 
                            } else {
                                System.out.println("Pilihan mode pencarian tidak valid.");
                            }
                        } catch (MenuTidakDitemukanException e) {
                            System.out.println("[PERINGATAN CUSTOM EXCEPTION] " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian selesai dieksekusi.");
                        }

                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 4:
                        System.out.println("\n--- Simulasi Transaksi ---");
                        if (daftarMenu.isEmpty()) {
                            System.out.println("Belum ada menu untuk disimulasikan.");
                        } else {
                            for (int i = 0; i < daftarMenu.size(); i++) {
                                System.out.println((i + 1) + ". " + daftarMenu.get(i).getNama() + " (" + daftarMenu.get(i).getClass().getSimpleName() + ")");
                            }
                            System.out.print("Pilih nomor menu: ");
                            int indeksPilih = scanner.nextInt();
                            scanner.nextLine();

                            if (indeksPilih >= 1 && indeksPilih <= daftarMenu.size()) {
                                simulasiProsesPesanan(daftarMenu.get(indeksPilih - 1));
                            } else {
                                System.out.println("Pilihan nomor tidak valid.");
                            }
                        }
                        System.out.print("Tekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 5:
                        System.out.println("\n--- Pengecekan Promo Diskon (Interface BisaDiskon) ---");
                        System.out.print("Masukkan persentase diskon (contoh: 15 untuk 15%): ");
                        double diskon = scanner.nextDouble();
                        scanner.nextLine();

                        for (int i = 0; i < daftarMenu.size(); i++) {
                            if (daftarMenu.get(i) instanceof BisaDiskon) {
                                BisaDiskon itemDiskon = (BisaDiskon) daftarMenu.get(i);
                                double hargaDiskon = itemDiskon.hitungDiskon(diskon);
                                System.out.printf("- %s (Diskon %.0f%%): Rp %,10.0f%n", daftarMenu.get(i).getNama(), diskon, hargaDiskon);
                            } else {
                                System.out.println("- " + daftarMenu.get(i).getNama() + " (Tidak ada promo diskon)");
                            }
                        }
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 6:
                        System.out.println("\n--- Cetak Label Packing (Interface BisaDibungkus) ---");
                        for (int i = 0; i < daftarMenu.size(); i++) {
                            if (daftarMenu.get(i) instanceof BisaDibungkus) {
                                BisaDibungkus itemBungkus = (BisaDibungkus) daftarMenu.get(i);
                                itemBungkus.cetakLabelPacking();
                            } else {
                                System.out.println("- " + daftarMenu.get(i).getNama() + " tidak memerlukan label packing khusus.");
                            }
                        }
                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 7:
                        System.out.println("\n--- Kelola Anggota (Demo HashMap) ---");
                        System.out.println("1. Tambah Anggota Baru");
                        System.out.println("2. Cari Anggota via ID/NPM");
                        System.out.println("3. Tampilkan Semua Anggota");
                        System.out.print("Pilih (1-3): ");
                        int menuAnggota = scanner.nextInt();
                        scanner.nextLine();

                        if (menuAnggota == 1) {
                            System.out.print("Masukkan ID/NPM (sebagai Key): ");
                            String idAnggota = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (sebagai Value): ");
                            String namaAnggota = scanner.nextLine();

                            dataAnggota.put(idAnggota, namaAnggota);
                            System.out.println("Berhasil menambahkan anggota baru!");
                        } else if (menuAnggota == 2) {
                            System.out.print("Masukkan ID/NPM yang dicari: ");
                            String searchId = scanner.nextLine();

                            if (dataAnggota.containsKey(searchId)) {
                                System.out.println("Ditemukan! Nama Anggota: " + dataAnggota.get(searchId));
                            } else {
                                System.out.println("Anggota dengan ID/NPM tersebut tidak terdaftar.");
                            }
                        } else if (menuAnggota == 3) {
                            System.out.println("Total Anggota Terdaftar: " + dataAnggota.size());
                            for (String keyId : dataAnggota.keySet()) {
                                System.out.println("- ID/NPM: " + keyId + " | Nama: " + dataAnggota.get(keyId));
                            }
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }

                        System.out.print("\nTekan Enter untuk kembali ke menu...");
                        scanner.nextLine();
                        break;

                    case 8:
                        System.out.println("\nTerima kasih telah menggunakan MakanYuk. Sampai jumpa!");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("\nPilihan menu tidak valid, silakan masukkan angka 1 sampai 8.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n[ERROR INPUT] Terjadi kesalahan: Anda harus memasukkan format angka yang valid!");
                scanner.nextLine(); // membersihkan buffer scanner
            } catch (Exception e) {
                System.out.println("\n[SYSTEM ERROR] Terjadi kesalahan: " + e.getMessage());
            }
        }
        scanner.close();
    }
}
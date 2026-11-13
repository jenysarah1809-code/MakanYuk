/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */
import java.io.FileWriter;
import java.io.IOException;

public class TransaksiPesan {
    public static void prosesPesan(Pelanggan pelanggan, Menu menu) {
        System.out.println("\n--------------------------------------------------");
        System.out.println("               STRUK TRANSAKSI MAKANYUK           ");
        System.out.println("--------------------------------------------------");
        System.out.println("Pelanggan : " + pelanggan.getNama() + " (ID: " + pelanggan.getIdPelanggan() + ")");
        System.out.println("Menu      : " + menu.getNama() + " | Harga: Rp " + menu.getHarga());
        
        menu.caraPenyajian();

        if (menu instanceof BisaDibungkus) {
            ((BisaDibungkus) menu).cetakLabelPacking();
        }

        System.out.println("Status    : Transaksi berhasil diproses dan dicatat!");
        System.out.println("--------------------------------------------------");

        try (FileWriter pipaTulis = new FileWriter("log_transaksi.txt", true)) {
            String log = "Pelanggan: " + pelanggan.getNama() + " | Memesan: " + menu.getNama() + " | Harga: Rp " + menu.getHarga() + "\n";
            pipaTulis.write(log);
        } catch (IOException e) {
            System.out.println("Peringatan: Gagal menulis log transaksi ke file. " + e.getMessage());
        }
    }
}
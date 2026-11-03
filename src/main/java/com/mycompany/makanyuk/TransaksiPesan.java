/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */
public class TransaksiPesan {
    public static void prosesPesan(Pelanggan pelanggan, Menu menu) {
        System.out.println("\n--------------------------------------------------");
        System.out.println("               STRUK TRANSAKSI MAKANYUK           ");
        System.out.println("--------------------------------------------------");
        System.out.println("Pelanggan : " + pelanggan.getNama() + " (ID: " + pelanggan.getIdPelanggan() + ")");
        System.out.println("Menu      : " + menu.getNama() + " | Harga: Rp " + menu.getHarga());
        
        // Memanggil method penyajian secara polimorfis
        menu.caraPenyajian();

        // Jika menu mengimplementasikan interface BisaDibungkus
        if (menu instanceof BisaDibungkus) {
            ((BisaDibungkus) menu).cetakLabelPacking();
        }

        System.out.println("Status    : Transaksi berhasil diproses dan dicatat!");
        System.out.println("--------------------------------------------------");
    }
}

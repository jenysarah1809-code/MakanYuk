/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */

public class Minuman extends Menu implements BisaDibungkus {
    private String ukuran;

    public Minuman(String nama, double harga, int stok, String ukuran) throws Exception {
        super(nama, harga, stok);
        this.ukuran = ukuran;
    }

    public String getUkuran() {
        return ukuran;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Minuman] %-12s | Harga: Rp %,10.0f | Stok: %-3d | Ukuran: %s%n", 
                getNama(), getHarga(), getStok(), ukuran);
    }

    @Override
    public void caraPenyajian() {
        System.out.println("Meracik dan menuangkan minuman " + getNama() + " ukuran " + ukuran + " ke dalam gelas dengan es.");
    }

    @Override
    public void cetakLabelPacking() {
        System.out.println("[Label Packing Minuman] Masukkan cup ke dalam kantong plastik khusus es lengkap dengan sedotan untuk: " + getNama());
    }
}
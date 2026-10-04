/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */
public class Minuman extends Menu{
    private String ukuran; // Regular / Large

    public Minuman(String nama, double harga, int stok, String ukuran) {
        super(nama, harga, stok);
        this.ukuran = ukuran;
    }

    public String getUkuran() {
        return this.ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Minuman]  Nama: %-12s | Harga: Rp %,8.0f | Stok: %-2d | Ukuran: %s%n", 
                getNama(), getHarga(), getStok(), this.ukuran);
    }

    @Override
    public void caraPenyajian() {
        System.out.println("-> Info Pesanan: Minuman disajikan dingin dengan tambahan es batu di gelas.");
    }
}

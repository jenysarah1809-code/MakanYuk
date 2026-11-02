/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */

public abstract class Menu {
    private String nama;
    private double harga;
    private int stok;

    public static int totalMenuDibuat = 0;

    public Menu(String nama, double harga, int stok) throws Exception {
        if (harga < 0) {
            throw new Exception("Harga tidak boleh bernilai negatif!");
        }
        if (stok < 0) {
            throw new Exception("Stok tidak boleh bernilai negatif!");
        }
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
        totalMenuDibuat++;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return this.harga;
    }

    public void setHarga(double harga) {
        if (harga >= 0) {
            this.harga = harga;
        } else {
            this.harga = 0;
        }
    }

    public int getStok() {
        return this.stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            this.stok = 0;
        }
    }

    public void tampilkanInfo() {
        System.out.printf("Menu: %-15s | Harga: Rp %,10.0f | Stok: %d%n", 
                this.nama, this.harga, this.stok);
    }

    public void caraPenyajian() {
        System.out.println("Disajikan secara standar oleh restoran.");
    }
}
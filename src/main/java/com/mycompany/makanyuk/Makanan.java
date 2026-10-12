/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */
public class Makanan extends Menu implements BisaDiskon, BisaDibungkus{
    private String levelPedas;

    public Makanan(String nama, double harga, int stok, String levelPedas) {
        super(nama, harga, stok);
        this.levelPedas = levelPedas;
    }

    public String getLevelPedas() {
        return this.levelPedas;
    }

    public void setLevelPedas(String levelPedas) {
        this.levelPedas = levelPedas;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Makanan]  Nama: %-12s | Harga: Rp %,8.0f | Stok: %-2d | Pedas: %s%n", 
                getNama(), getHarga(), getStok(), this.levelPedas);
    }

    @Override
    public void caraPenyajian() {
        System.out.println("-> Info Pesanan: Makanan disajikan hangat di atas piring saji.");
    }

    @Override
    public double hitungDiskon(double persentase) {
        return getHarga() - (getHarga() * persentase / 100);
    }

    @Override
    public void cetakLabelPacking() {
        System.out.println("[Label Packing Makanan] Bungkus menggunakan kertas minyak tahan panas + Box eco-friendly untuk:" + getNama());
    }
}

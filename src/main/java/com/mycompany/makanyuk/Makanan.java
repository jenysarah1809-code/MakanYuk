/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */

public class Makanan extends Menu implements BisaDiskon, BisaDibungkus {
    private String levelPedas;

    public Makanan(String nama, double harga, int stok, String levelPedas) throws Exception {
        super(nama, harga, stok);
        if (levelPedas.isEmpty()) {
            throw new Exception("Level pedas tidak boleh kosong!");
        }
        this.levelPedas = levelPedas;
    }

    public String getLevelPedas() {
        return levelPedas;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Makanan] %-12s | Harga: Rp %,10.0f | Stok: %-3d | Level Pedas: %s%n", 
                getNama(), getHarga(), getStok(), levelPedas);
    }

    @Override
    public void caraPenyajian() {
        System.out.println("Menggoreng/Memasak hidangan makanan " + getNama() + " dengan tingkat kepedasan " + levelPedas + ".");
    }

    @Override
    public double hitungDiskon(double persentase) {
        return getHarga() - (getHarga() * persentase / 100);
    }

    @Override
    public void cetakLabelPacking() {
        System.out.println("[Label Packing Makanan] Bungkus menggunakan kertas minyak tahan panas + Box eco-friendly untuk: " + getNama());
    }
}
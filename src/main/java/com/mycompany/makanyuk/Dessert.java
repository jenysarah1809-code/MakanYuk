/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */
public class Dessert extends Menu{
    private String rasaManis;

    public Dessert(String nama, double harga, int stok, String rasaManis) {
        super(nama, harga, stok);
        this.rasaManis = rasaManis;
    }

    public String getrasaManis() {
        return this.rasaManis;
    }

    public void setrasaManis(String rasaManis) {
        this.rasaManis = rasaManis;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Dessert]  Nama: %-12s | Harga: Rp %,8.0f | Stok: %-2d | Rasa Manis: %s%n", 
                getNama(), getHarga(), getStok(), this.rasaManis);
    }

    @Override
    public void caraPenyajian() {
        System.out.println("-> [Proses Dessert] Hidangan penutup dikeluarkan dari lemari pendingin dan diberi topping manis.");
    }
}

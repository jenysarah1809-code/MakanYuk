/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */

public class Dessert extends Menu implements BisaDiskon {
    private String rasa;

    public Dessert(String nama, double harga, int stok, String rasa) throws Exception {
        super(nama, harga, stok);
        this.rasa = rasa;
    }

    public String getRasa() {
        return rasa;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[Dessert] %-12s | Harga: Rp %,10.0f | Stok: %-3d | Rasa: %s%n", 
                getNama(), getHarga(), getStok(), rasa);
    }

    @Override
    public void caraPenyajian() {
        System.out.println("Menata hidangan penutup " + getNama() + " beraroma/rasa " + rasa + " di atas piring saji cantik.");
    }

    @Override
    public double hitungDiskon(double persentase) {
        return getHarga() - (getHarga() * persentase / 100);
    }
}
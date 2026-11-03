/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.makanyuk;

/**
 *
 * @author JENY SARAH C SILABAN
 */
public class DapurRestoran {
    private String namaBagian;
    private int jumlahKoki;

    public DapurRestoran(String namaBagian, int jumlahKoki) {
        this.namaBagian = namaBagian;
        this.jumlahKoki = jumlahKoki;
    }

    public void infoDapur() {
        System.out.println("-> [Komposisi Dapur] Bagian: " + namaBagian + " | Jumlah Koki Siaga: " + jumlahKoki + " orang.");
    }
}

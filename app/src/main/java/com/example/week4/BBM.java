package com.example.week4;

public class BBM {
    private String nama;
    private int harga;

    public BBM(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return nama + " : Rp. " + harga;
    }

    public int getHarga() {
        return harga;
    }
}

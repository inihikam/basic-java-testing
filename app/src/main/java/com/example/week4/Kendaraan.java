package com.example.week4;

public class Kendaraan {
    private String nama;
    private double ltr;

    public Kendaraan(String nama, double ltr) {
        this.nama = nama;
        this.ltr = ltr;
    }

    @Override
    public String toString() {
        return nama + " : " + ltr;
    }

    public double getLtr() {
        return ltr;
    }

    public String getNama() {
        return nama;
    }
}

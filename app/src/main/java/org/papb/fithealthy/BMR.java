package org.papb.fithealthy;

/*
Ini adalah halaman BMR
 */

public class BMR {
    int tinggi, berat,umur;
    String jenisKelamin, time;
    double hasil;

    public BMR(String time, int tinggi, int berat, String jenisKelamin, int umur){
        this.time = time;
        this.tinggi = tinggi;
        this.berat = berat;
        this.jenisKelamin = jenisKelamin;
        this.umur = umur;
    }

    public double hitungHasil(){
        if(jenisKelamin.equalsIgnoreCase("Male")) {
            hasil = 66.47 + (13.7 * berat) + (5 * tinggi) - (6.8 * umur);
            return hasil;
        } else if(jenisKelamin.equalsIgnoreCase("Female")){
            hasil = 655.1 + (9.6 * berat) + (1.8 * tinggi) - (4.7 * umur);
            return hasil;
        }
        return 0;
    }
}
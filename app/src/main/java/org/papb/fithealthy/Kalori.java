package org.papb.fithealthy;

/*
Ini adalah halaman Hitung Kalori
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class Kalori extends AppCompatActivity implements View.OnClickListener {
    private Spinner Makanan1;
    private Spinner Makanan2;
    private Spinner Makanan3;
    private Spinner Makanan4;
    private Button hitung;
    private String Mak1;
    private String Mak2;
    private String Mak3;
    private String Mak4;
    private int kalori = 0;
    private TextView tvHasil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.kalori);

        Spinner spinner1 = (Spinner) findViewById(R.id.spMakanan1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.makananPokok, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        Spinner spinner2 = (Spinner) findViewById(R.id.spMakanan2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.laukPauk, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Spinner spinner3 = (Spinner) findViewById(R.id.spMakanan3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.laukPauk, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        Spinner spinner4 = (Spinner) findViewById(R.id.spMakanan4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.sayuran, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        this.Makanan1 = (Spinner) this.findViewById(R.id.spMakanan1);
        this.Makanan2 = (Spinner) this.findViewById(R.id.spMakanan2);
        this.Makanan3 = (Spinner) this.findViewById(R.id.spMakanan3);
        this.Makanan4 = (Spinner) this.findViewById(R.id.spMakanan4);

        this.hitung = (Button) this.findViewById(R.id.btHitung);
        this.tvHasil = (TextView) this.findViewById(R.id.tvHasil);

        this.hitung.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        this.Mak1 = this.Makanan1.getSelectedItem().toString();
        this.Mak2 = this.Makanan2.getSelectedItem().toString();
        this.Mak3 = this.Makanan3.getSelectedItem().toString();
        this.Mak4 = this.Makanan4.getSelectedItem().toString();

        Hitung();
        this.tvHasil.setText(""+kalori+"");

    }

    public void Hitung(){
        int M1 = 0;
        int M2 = 0;
        int M3 = 0;
        int M4 = 0;

        switch (Mak1){
            case "Nasi Putih":
                M1=175;
                break;
            case "Jagung Rebus":
                M1=90;
                break;
            case "Kentang Rebus":
                M1=166;
                break;
            case "Mie Instant":
                M1=168;
                break;
            case "Roti Tawar":
                M1=128;
                break;
            case "Makanan Pokok":
                M1=0;
                break;
        }

        switch (Mak2){
            case "Ayam Panggang":
                M2=385;
                break;
            case "Ikan Teri":
                M2=213;
                break;
            case "Telur Ayam Rebus":
                M2=97;
                break;
            case "Telur Asin":
                M2=138;
                break;
            case "Ikan Lele Goreng":
                M2=57;
                break;
            case "Ikan Bandeng Goreng":
                M2=180;
                break;
            case "Tempe Goreng":
                M2=118;
                break;
            case "Tahu Goreng":
                M2=111;
                break;
            case "Lauk Pauk":
                M2=0;
                break;
        }

        switch (Mak3){
            case "Ayam Panggang":
                M3=385;
                break;
            case "Ikan Teri":
                M3=213;
                break;
            case "Telur Ayam Rebus":
                M3=97;
                break;
            case "Telur Asin":
                M3=138;
                break;
            case "Ikan Lele Goreng":
                M3=57;
                break;
            case "Ikan Bandeng Goreng":
                M3=180;
                break;
            case "Tempe Goreng":
                M3=118;
                break;
            case "Tahu Goreng":
                M3=111;
                break;
            case "Lauk Pauk":
                M3=0;
                break;
        }

        switch (Mak4){
            case "Sop Bayam":
                M4=78;
                break;
            case "Sayur Lodeh":
                M4=61;
                break;
            case "Tumis Buncis":
                M4=52;
                break;
            case "Sayur Asam":
                M4=88;
                break;
            case "Tumis Daun Singkong":
                M4=151;
                break;
            case "Sayuran":
                M4=0;
                break;
        }

        kalori = M1 + M2 + M3 + M4;

    }
    //buat shared preference, untuk menghidupkan atau mematikan saran dari jumlah kalori
}
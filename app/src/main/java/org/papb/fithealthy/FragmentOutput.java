package org.papb.fithealthy;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kvnch on 12-Dec-17.
 */

public class FragmentOutput extends Fragment{

    private View view;
    private AdapterBMR adapterBMR;
    private ArrayList<BMR> bmr;
    private RecyclerView rvBMR;
    private TextView tvHitung;
    int tinggi, umur, berat;
    public BMR a[] = new BMR[100];


    String gender;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.view = (View)inflater.inflate(R.layout.fragment_output, container, false);
        this.bmr = new ArrayList<BMR>();
        return this.view;
    }

    public void terimaData(String time, int indeks, int tinggi, int berat, String gender, int umur) {
        this.tinggi = tinggi;
        this.berat = berat;
        this.umur = umur;
        this.gender = gender;
        a[indeks] = new BMR(time, tinggi, berat, gender, umur);
        bmr.add(0, a[indeks]);
        this.adapterBMR = new AdapterBMR(view.getContext(), this.bmr);
        this.rvBMR = (RecyclerView)view.findViewById(R.id.rvBMR);
        this.rvBMR.setAdapter(this.adapterBMR);
        this.rvBMR.setLayoutManager(new LinearLayoutManager(view.getContext()));
        this.adapterBMR.notifyItemInserted(0);
        this.adapterBMR.notifyDataSetChanged();
    }
}

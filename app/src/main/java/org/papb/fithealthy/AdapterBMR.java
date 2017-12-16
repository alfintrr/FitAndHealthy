package org.papb.fithealthy;


import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by kvnch on 12-Dec-17.
 */

public class AdapterBMR extends RecyclerView.Adapter<AdapterBMR.ViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<BMR> BMR;

    public AdapterBMR(Context context, ArrayList<BMR> bmr) {
        this.BMR = bmr;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public AdapterBMR.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewHolder = this.inflater.inflate(R.layout.item_bmr, parent, false);
        return new ViewHolder(viewHolder);

    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DecimalFormat precision = new DecimalFormat("0.00");
        BMR bmr = this.BMR.get(position);
        holder.tvWaktu.setText(bmr.time);

        holder.tvBMR.setText(precision.format(bmr.hitungHasil())+" kalori");
        holder.position=position;
    }
    @Override
    public int getItemCount() {
        return this.BMR.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvBMR, tvWaktu;
        public int position;
        public ViewHolder(View itemView) {
            super(itemView);
            this.tvWaktu = (TextView) this.itemView.findViewById(R.id.tvWaktu);
            this.tvBMR = (TextView)this.itemView.findViewById(R.id.tvBMR);
        }
    }
}

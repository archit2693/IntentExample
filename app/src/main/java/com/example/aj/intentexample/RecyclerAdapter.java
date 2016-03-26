package com.example.aj.intentexample;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerViewAccessibilityDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{

    String[] country_names,country_capitals;

    public RecyclerAdapter(String[] country_names,String[] country_capitals )
    {
        this.country_names=country_names;
        this.country_capitals=country_capitals;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }



    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tcon.setText(country_names[position]);
        holder.tcap.setText(country_capitals[position]);

    }

    @Override
    public int getItemCount() {
        return country_names.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView tcon,tcap;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            tcon=(TextView) itemView.findViewById(R.id.tx_country);
            tcap=(TextView) itemView.findViewById(R.id.tx_capital);


        }
    }

}

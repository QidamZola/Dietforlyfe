package com.example.dietforlyfe.Adapter;

/*
 * Tanggal Pengerjaan : 03-05-2019
 * NIM      : 10116055
 * Nama     : Qidam Zola Farhan
 * Kelas    : IF-2 / AKB-2
 */
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dietforlyfe.Model.ModelKalori;
import com.example.dietforlyfe.R;

import java.util.ArrayList;
import java.util.List;

public class KaloriAdapter extends RecyclerView.Adapter<KaloriAdapter.KaloriViewHolder> {

    private List<ModelKalori> kaloriList = new ArrayList<>();

    public KaloriAdapter(List<ModelKalori> kaloriList) {
        this.kaloriList = kaloriList;
    }


    @Override
    public KaloriAdapter.KaloriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kalori_layout,parent, false);
        KaloriAdapter.KaloriViewHolder kaloriViewHolder = new KaloriAdapter.KaloriViewHolder(view);
        return kaloriViewHolder;
    }

    @Override
    public void onBindViewHolder(KaloriAdapter.KaloriViewHolder holder, int position) {
        holder.txt_bmr.setText(kaloriList.get(position).getBmr());
        holder.txt_kalori.setText(kaloriList.get(position).getKalori());
    }

    @Override
    public int getItemCount(){
        return kaloriList.size();
    }
    public static class KaloriViewHolder extends RecyclerView.ViewHolder {

        TextView txt_bmr;
        TextView txt_kalori;

        public KaloriViewHolder(View itemView) {
            super(itemView);

            txt_bmr = (TextView) itemView.findViewById(R.id.txt_bmr);
            txt_kalori = (TextView) itemView.findViewById(R.id.txt_kalori);
        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }
}
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

import com.example.dietforlyfe.Model.ModelIMT;
import com.example.dietforlyfe.R;

import java.util.ArrayList;
import java.util.List;

public class IMTAdapter extends RecyclerView.Adapter<IMTAdapter.IMTViewHolder> {

    private List<ModelIMT> imtList = new ArrayList<>();

    public IMTAdapter(List<ModelIMT> imtList) {
        this.imtList = imtList;
    }


    @Override
    public IMTAdapter.IMTViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imt_layout,parent, false);
        IMTViewHolder imtViewHolder = new IMTViewHolder(view);
        return imtViewHolder;
    }

    @Override
    public void onBindViewHolder(IMTAdapter.IMTViewHolder holder, int position) {
        holder.txt_bbi.setText(imtList.get(position).getBbi());
        holder.txt_imt.setText(imtList.get(position).getImt());
        holder.txt_ket.setText(imtList.get(position).getKet());
    }

    @Override
    public int getItemCount(){
        return imtList.size();
    }
    public static class IMTViewHolder extends RecyclerView.ViewHolder {

        TextView txt_bbi;
        TextView txt_imt;
        TextView txt_ket;

        public IMTViewHolder(View itemView) {
            super(itemView);

            txt_bbi = (TextView) itemView.findViewById(R.id.txt_bbi);
            txt_imt = (TextView) itemView.findViewById(R.id.txt_imt);
            txt_ket = (TextView) itemView.findViewById(R.id.txt_ket);
        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView){
        super.onAttachedToRecyclerView(recyclerView);
    }
}

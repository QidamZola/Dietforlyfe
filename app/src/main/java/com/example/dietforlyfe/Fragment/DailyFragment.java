package com.example.dietforlyfe.Fragment;
/*
 * Tanggal Pengerjaan : 03-05-2019
 * NIM      : 10116055
 * Nama     : Qidam Zola Farhan
 * Kelas    : IF-2 / AKB-2
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dietforlyfe.Adapter.IMTAdapter;
import com.example.dietforlyfe.Adapter.KaloriAdapter;
import com.example.dietforlyfe.DB.DBIMTAdapter;
import com.example.dietforlyfe.DB.DBKalAdapter;
import com.example.dietforlyfe.Model.ModelIMT;
import com.example.dietforlyfe.Model.ModelKalori;
import com.example.dietforlyfe.R;

import java.util.ArrayList;
import java.util.List;

public class DailyFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private List<ModelIMT> imtList = new ArrayList<>();
    private List<ModelKalori>kaloriList = new ArrayList<>();
    private DBIMTAdapter dbAdapter;
    private DBKalAdapter dbKalAdapter;
    private IMTAdapter adapterIMT;
    private KaloriAdapter adapterKalori;
    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily, container, false);
        getDataIMT(view);
        getDataKalori(view);
       return view;
    }

    private void getDataIMT(View view){
        recyclerView = (RecyclerView)view.findViewById(R.id.recycleIMT);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dbAdapter = new DBIMTAdapter(getActivity());
        imtList = dbAdapter.getSemuaIMT();
        adapterIMT = new IMTAdapter(imtList);
        recyclerView.setAdapter(adapterIMT);
        adapterIMT.notifyDataSetChanged();


    }
    private void getDataKalori(View view){
        recyclerView = (RecyclerView)view.findViewById(R.id.recycleKalori);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dbKalAdapter = new DBKalAdapter(getActivity());
        kaloriList = dbKalAdapter.getSemuaKalori();
        adapterKalori = new KaloriAdapter(kaloriList);
        recyclerView.setAdapter(adapterKalori);
        adapterKalori.notifyDataSetChanged();;
    }
}


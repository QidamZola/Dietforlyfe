package com.example.dietforlyfe.Fragment;
/*
 * Tanggal Pengerjaan : 02-05-2019
 * NIM      : 10116055
 * Nama     : Qidam Zola Farhan
 * Kelas    : IF-2 / AKB-2
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dietforlyfe.Preferences;
import com.example.dietforlyfe.R;

public class HomeFragment extends Fragment {

    TextView txtnama;
    private String nama;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        TextView nama = view.findViewById(R.id.nama);
        nama.setText(Preferences.getLoggedInUser(getContext()));
        return view;
    }
}

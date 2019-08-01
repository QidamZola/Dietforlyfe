package com.example.dietforlyfe.Fragment;
/*
 * Tanggal Pengerjaan : 04-05-2019
 * NIM      : 10116055
 * Nama     : Qidam Zola Farhan
 * Kelas    : IF-2 / AKB-2
 */
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dietforlyfe.Adapter.IMTAdapter;
import com.example.dietforlyfe.DB.DBIMTAdapter;
import com.example.dietforlyfe.Model.ModelIMT;
import com.example.dietforlyfe.Preferences;
import com.example.dietforlyfe.R;

import java.util.List;

import static java.lang.Double.valueOf;

public class IMTFragment extends Fragment {

    Button btnHitung;
    EditText tb, bb;
    TextView bbi, imt,ket,jk;
    private DBIMTAdapter dbAdapter;
    private IMTAdapter imtAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_indexmasatubuh, container, false);

        btnHitung = (Button) view.findViewById(R.id.btnHitungIMT);
        tb = (EditText) view.findViewById(R.id.txt_tinggibadan);
        bb = (EditText) view.findViewById(R.id.txt_beratbadan);
        jk = (TextView) view.findViewById(R.id.txt_jk);
        bbi = (TextView) view.findViewById(R.id.txt_bbi);
        imt = (TextView) view.findViewById(R.id.txt_imt);
        ket = (TextView) view.findViewById(R.id.txt_ket);

        jk.setText(Preferences.getLoggedInJk(getContext()));
        dbAdapter = new DBIMTAdapter(getContext());

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungimtbbi();
                saveData();
            }
        });

        return view;
    }

    private void hitungimtbbi() {
        if (tb.getText().toString().length()==0){
            tb.setError("Data Kosong");
        }else if (bb.getText().toString().length()==0){
            bb.setError("Data Kosong");
        }else
        {
            String tinggib = tb.getText().toString().trim();
            String beratb = bb.getText().toString().trim();
            String ketb = ket.getText().toString().trim();
            String jkb = jk.getText().toString().trim();

            double tinggibadan = Double.parseDouble(tinggib);
            double beratbadan = Double.parseDouble(beratb);
            String keterangan = String.format(ketb);

            if(jk.getText().equals("Laki - Laki")){
                double hitungbbiL = (tinggibadan - 100) - (tinggibadan - 100) * 10 / 100;
                bbi.setText(String.format("%.1f", hitungbbiL));
            }
            else if(jk.getText().equals("Perempuan")){
                double hitungbbiP = (tinggibadan - 100) - (tinggibadan - 100) * 15/100;
                bbi.setText(String.format("%.1f", hitungbbiP));
            }

            double tinggidalammeter = tinggibadan / 100;

            double hitungimt = beratbadan / (tinggidalammeter * tinggidalammeter);
            imt.setText(String.format("%.1f", hitungimt));

            if(hitungimt<18.5)
            {
                ket.setText("Kurus");
            }
            else if(hitungimt>=18.5 && hitungimt<23)
            {
                ket.setText("Normal");
            }
            else if(hitungimt>=23 && hitungimt<30)
            {
                ket.setText("Kelebihan Berat Badan");
            }
            else if(hitungimt>30)
            {
                ket.setText("Obesitas");
            }

            Toast.makeText(getContext(), "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
        }

    }
    private void saveData() {
        String getbbi = bbi.getText().toString();
        String getimt = imt.getText().toString();
        String getket = ket.getText().toString();
        dbAdapter.tambahIMT(new ModelIMT(getbbi, getimt ,getket));
        List<ModelIMT> imtList = dbAdapter.getSemuaIMT();
        imtAdapter = new IMTAdapter(imtList);
        imtAdapter.notifyDataSetChanged();
    }

}

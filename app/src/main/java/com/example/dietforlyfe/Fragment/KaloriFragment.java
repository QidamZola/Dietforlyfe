package com.example.dietforlyfe.Fragment;
/*
 * Tanggal Pengerjaan : 04-05-2019
 * NIM      : 10116055
 * Nama     : Qidam Zola Farhan
 * Kelas    : IF-2 / AKB-2
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dietforlyfe.Adapter.KaloriAdapter;
import com.example.dietforlyfe.DB.DBKalAdapter;
import com.example.dietforlyfe.Model.ModelKalori;
import com.example.dietforlyfe.Preferences;
import com.example.dietforlyfe.R;

import java.util.List;

public class KaloriFragment extends Fragment {
    Button btnHitung;
    EditText tb, bb, usia;
    TextView bmr, kalori,jk;
    RadioGroup radioGroup;
    RadioButton radio1,radio2,radio3,radio4,radio5;
    private DBKalAdapter dbKalAdapter;
    private KaloriAdapter kaloriAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kalori,container,false);

        btnHitung = (Button) view.findViewById(R.id.btn_hitungKalori);
        tb = (EditText) view.findViewById(R.id.txt_tinggibadan);
        bb = (EditText) view.findViewById(R.id.txt_beratbadan);
        usia = (EditText) view.findViewById(R.id.txt_usia);
        jk = (TextView) view.findViewById(R.id.txt_jk);
        bmr = (TextView) view.findViewById(R.id.txt_bmr);
        kalori = (TextView) view.findViewById(R.id.txt_kalori);
        radioGroup = (RadioGroup) view.findViewById(R.id.radiogoupAktifitas);

        jk.setText(Preferences.getLoggedInJk(getContext()));
        dbKalAdapter = new DBKalAdapter(getContext());

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungkalori();
                saveData();
            }
        });

        return view;
    }

    private void hitungkalori() {
        if (tb.getText().toString().length()==0){
            tb.setError("Data Kosong");
        }else if (bb.getText().toString().length()==0){
            bb.setError("Data Kosong");
        }else if (usia.getText().toString().length()==0){
            usia.setError("Data Kosong");
        }else {


            String tinggib = tb.getText().toString().trim();
            String beratb = bb.getText().toString().trim();
            String usiab = usia.getText().toString().trim();


            double tinggibadan = Double.parseDouble(tinggib);
            double beratbadan = Double.parseDouble(beratb);
            double usia = Double.parseDouble(usiab);

            if(jk.getText().equals("Laki - Laki")) {
                double hitungbmrL = 66 + (13.7 * beratbadan) + (5 * tinggibadan) - (6.8 * usia);
                bmr.setText(String.format("%.1f", hitungbmrL));

                int id = radioGroup.getCheckedRadioButtonId();
                switch (id){
                    case R.id.radio1 :
                        double hitungkalori=hitungbmrL*1.2;
                        kalori.setText(String.format("%.1f",hitungkalori));
                        break;
                    case R.id.radio2 :
                        hitungkalori=hitungbmrL*1.375;
                        kalori.setText(String.format("%.1f",hitungkalori));
                        break;
                    case R.id.radio3 :
                        hitungkalori=hitungbmrL*1.55;
                        kalori.setText(String.format("%.1f",hitungkalori));
                        break;
                    case R.id.radio4 :
                        hitungkalori=hitungbmrL*1.725;
                        kalori.setText(String.format("%.1f",hitungkalori));
                        break;
                    case R.id.radio5 :
                        hitungkalori=hitungbmrL*1.9;
                        kalori.setText(String.format("%.1f",hitungkalori));
                        break;

                }

            }
            else if(jk.getText().equals("Perempuan")) {
                double hitungbmrP = 655 + (9.6 * beratbadan) + (1.8 * tinggibadan) - (4.7 * usia);
                bmr.setText(String.format("%.1f", hitungbmrP));
                int id = radioGroup.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.radio1:
                        double hitungkalori = hitungbmrP * 1.2;
                        kalori.setText(String.format("%.1f", hitungkalori));
                        break;
                    case R.id.radio2:
                        hitungkalori = hitungbmrP * 1.375;
                        kalori.setText(String.format("%.1f", hitungkalori));
                        break;
                    case R.id.radio3:
                        hitungkalori = hitungbmrP * 1.55;
                        kalori.setText(String.format("%.1f", hitungkalori));
                        break;
                    case R.id.radio4:
                        hitungkalori = hitungbmrP * 1.725;
                        kalori.setText(String.format("%.1f", hitungkalori));
                        break;
                    case R.id.radio5:
                        hitungkalori = hitungbmrP * 1.9;
                        kalori.setText(String.format("%.1f", hitungkalori));
                        break;
                }
            }

                Toast.makeText(getContext(), "Berhasil Menambahkan Data Kalori", Toast.LENGTH_SHORT).show();
        }
    }
    private void saveData() {
        String getbmr = bmr.getText().toString();
        String getkalori = kalori.getText().toString();
        dbKalAdapter.tambahKalori(new ModelKalori(getbmr, getkalori));
        List<ModelKalori> kaloriList = dbKalAdapter.getSemuaKalori();
        kaloriAdapter = new KaloriAdapter(kaloriList);
        kaloriAdapter.notifyDataSetChanged();
    }

}


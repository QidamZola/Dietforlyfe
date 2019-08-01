package com.example.dietforlyfe;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dietforlyfe.Fragment.HomeFragment;


public class Profilawal extends AppCompatActivity {
    Button login,register;
    EditText user,pass;
    RadioGroup radiogroup;
    RadioButton radiobutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilawal);
        login = (Button) findViewById(R.id.btnSelesai);
        register = (Button) findViewById(R.id.btnRegister);
        user = (EditText) findViewById(R.id.txt_nama);
        pass = (EditText) findViewById(R.id.txt_pass);
        radiogroup = (RadioGroup)findViewById(R.id.radiogroupJK);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek();
            }
        });

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
            }
        });
        if(Preferences.getLoggedInStatus(getBaseContext())){
            startActivity(new Intent(Profilawal.this,Menu.class));
            finish();
        }

    }
    public void cek() {
        user.setError(null);
        pass.setError(null);
        View fokus = null;
        boolean cancle = false;

        String username = user.getText().toString();
        String password = pass.getText().toString();
        int selectedID = radiogroup.getCheckedRadioButtonId();
        radiobutton = (RadioButton) findViewById(selectedID);
        String jk = radiobutton.getText().toString();

        if (TextUtils.isEmpty(username)) {
            user.setError("Username Required");
            fokus = user;
            cancle = true;
        } else if (!cekUser(username)) {
            user.setError("Username Tidak Ada");
            fokus = user;
            cancle = true;
        }
        if (TextUtils.isEmpty(password)) {
            pass.setError("Password Required");
            fokus = pass;
            cancle = true;
        } else if (!cekPassword(password)) {
            pass.setError("Password Salah");
            fokus = pass;
            cancle = true;
        }
        if (cancle) fokus.requestFocus();
        else masuk();
    }
    private void masuk(){
        Preferences.setLoggedInUser(getBaseContext(),Preferences.getRegisteredUser(getBaseContext()));
        Preferences.setLoggedInJk(getBaseContext(),Preferences.getRegisteredJk(getBaseContext()));
        Preferences.setLoggedInStatus(getBaseContext(),true);
        startActivity(new Intent(getBaseContext(),Menu.class));
        finish();
    }

    private boolean cekUser(String username){
        return username.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
    private boolean cekPassword(String password){
        return password.equals(Preferences.getRegisteredPass(getBaseContext()));
    }

    private  boolean cekJk(String jk){
        return jk.equals(Preferences.getRegisteredJk(getBaseContext()));
    }
}

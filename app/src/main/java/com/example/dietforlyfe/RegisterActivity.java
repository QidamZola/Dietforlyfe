package com.example.dietforlyfe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RegisterActivity extends AppCompatActivity {

    private EditText user,pass,repass;
    private Button register;
    private RadioGroup radiogroup;
    private RadioButton radiobutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        user = findViewById(R.id.txt_nama);
        pass = findViewById(R.id.txt_pass);
        register = findViewById(R.id.btnRegister);
        radiogroup = findViewById(R.id.radiogroupJK);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cek();
            }
        });
    }

    private void cek(){
        user.setError(null);
        pass.setError(null);
        View fokus = null;
        boolean cancle = false;

        String username = user.getText().toString();
        String password = pass.getText().toString();
        int selectedID = radiogroup.getCheckedRadioButtonId();
        radiobutton = (RadioButton) findViewById(selectedID);
        String jk = radiobutton.getText().toString();

        if(TextUtils.isEmpty(username)){
            user.setError("Username masih kosong");
            fokus = user;
            cancle = true;
        }else if(cekUser(username)){
            user.setError("Username Sudah Ada");
            fokus = user;
            cancle = true;
        }
        if(TextUtils.isEmpty(password)) {
            pass.setError("Password masih kosong");
            fokus = pass;
            cancle = true;
        }
        if(cancle){
            fokus.requestFocus();
        }else {
            Preferences.setRegisteredUser(getBaseContext(), username);
            Preferences.setRegisteredPass(getBaseContext(), password);
            Preferences.setRegisteredJk(getBaseContext(), jk);
            finish();
        }
    }
    private boolean cekUser(String username){
        return  username.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}

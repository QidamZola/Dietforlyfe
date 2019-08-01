package com.example.dietforlyfe;
/*
 * Tanggal Pengerjaan : 02-05-2019
 * NIM      : 10116055
 * Nama     : Qidam Zola Farhan
 * Kelas    : IF-2 / AKB-2
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dietforlyfe.Fragment.DailyFragment;
import com.example.dietforlyfe.Fragment.IMTFragment;
import com.example.dietforlyfe.Fragment.HomeFragment;
import com.example.dietforlyfe.Fragment.KaloriFragment;
import com.example.dietforlyfe.Fragment.InformasiFragment;

public class Menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        updateNavHeader();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_informasi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InformasiFragment()).commit();
                break;
            case R.id.nav_daily:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DailyFragment()).commit();
                break;
            case R.id.nav_kalori:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new KaloriFragment()).commit();
                break;

            case R.id.nav_imt:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new IMTFragment()).commit();
                break;
            case R.id.nav_about:
                Toast.makeText(this, "DIET4LIFE APPS VERSION 1.0", Toast.LENGTH_SHORT).show();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void updateNavHeader(){
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navNama = headerView.findViewById(R.id.nav_nama);
        TextView navJk = headerView.findViewById(R.id.nav_jk);
        navNama.setText(Preferences.getLoggedInUser(getBaseContext()));
        navJk.setText(Preferences.getLoggedInJk(getBaseContext()));
    }


}

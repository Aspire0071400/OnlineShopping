package com.aspire.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import com.aspire.onlineshopping.databaseModels.DataBaseHelper;
import com.aspire.onlineshopping.menu.AccountInfoFragment;
import com.aspire.onlineshopping.menu.CartFragment;
import com.aspire.onlineshopping.menu.HomeFragment;
import com.google.android.material.navigation.NavigationView;

public class LandingPage extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    //TextView tvUserNameDisplay,tvEmailDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        //tvUserNameDisplay = findViewById(R.id.tvUserNameDisplay);
        //tvEmailDisplay = findViewById(R.id.tvEmailDisplay);
        DataBaseHelper db = new DataBaseHelper(this);
        Cursor cursor = db.getUser();

        View header = navigationView.getHeaderView(0);
        TextView tvUserNameDisplay = header.findViewById(R.id.tvUserNameDisplay);
        TextView tvEmailDisplay = header.findViewById(R.id.tvEmailDisplay);

        if(cursor.getCount()==0){
            Toast.makeText(LandingPage.this,"Error",Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                tvUserNameDisplay.setText(""+cursor.getString(1));
                tvEmailDisplay.setText(""+cursor.getString(2));
            }
        }

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        loadFragment(new HomeFragment());

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id==R.id.home){
                    loadFragment(new HomeFragment());
                } else if (id==R.id.accountInfo) {
                    loadFragment(new AccountInfoFragment());
                } else if (id==R.id.cart) {
                    loadFragment(new CartFragment());
                } else {
                    Toast.makeText(LandingPage.this, "Move to Login", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawer(GravityCompat.START);

                return false;
            }
        });

    }

    @NonNull
    @Override
    public OnBackInvokedDispatcher getOnBackInvokedDispatcher() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.getOnBackInvokedDispatcher();
        }
        return null;
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.containerMain,fragment);
        ft.commit();
    }

}
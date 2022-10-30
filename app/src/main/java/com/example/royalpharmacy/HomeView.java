package com.example.royalpharmacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.royalpharmacy.IT211.AddOrder;
import com.example.royalpharmacy.IT211.UpdateProfile;
import com.example.royalpharmacy.IT212.StaffHome;
import com.example.royalpharmacy.IT213.DoctorHome;

import androidx.appcompat.app.AppCompatActivity;

public class HomeView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_view);


    }

    public void getStaff(View view) {
        Intent intent = new Intent(HomeView.this, StaffHome.class);
        startActivity(intent);
    }

    public void getStockHome(View view) {
        Intent intent = new Intent(HomeView.this, StockManagement.class);
        startActivity(intent);
    }

    public void getDoctorHome(View view) {
        Intent intent = new Intent(HomeView.this, DoctorHome.class);
        startActivity(intent);
    }

    public void addOrder(View view) {
        Intent intent = new Intent(HomeView.this, AddOrder.class);
        startActivity(intent);
    }

    public void getProfile(View view) {
        String  userName = getIntent().getStringExtra("name");
        String  phone = getIntent().getStringExtra("phone");
        String  email = getIntent().getStringExtra("email");
        String  passwored = getIntent().getStringExtra("passwored");
        Intent intent = new Intent(HomeView.this, UpdateProfile.class);
        intent.putExtra("name", userName);
        intent.putExtra("phone", phone);
        intent.putExtra("email", email);
        intent.putExtra("passwored", passwored);
        startActivity(intent);
    }
}

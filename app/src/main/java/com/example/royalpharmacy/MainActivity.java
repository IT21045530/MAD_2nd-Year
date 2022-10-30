package com.example.royalpharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.royalpharmacy.IT211.AddOrder;
import com.example.royalpharmacy.IT211.Login;
import com.example.royalpharmacy.IT212.AddMedicine;
import com.example.royalpharmacy.IT212.ShowCart;
import com.example.royalpharmacy.IT212.StaffHome;
import com.example.royalpharmacy.IT213.DoctorHome;

public class MainActivity extends AppCompatActivity {


    Button loginbtn,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbtn = findViewById(R.id.getAdminLogin);
        add = findViewById(R.id.buttonxx);

        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);

        String  stocktype = getIntent().getStringExtra("name");

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddOrder.class);
                startActivity(intent);
            }
        });



    }

    public void GetStaffView(View view) {
        Intent intent = new Intent(MainActivity.this, StaffHome.class);
        startActivity(intent);
    }

    public void OrderMedicine(View view) {
        Intent intent = new Intent(MainActivity.this, AddMedicine.class);
        startActivity(intent);
    }

    public void showList(View view) {
        Intent intent = new Intent(MainActivity.this, ShowCart.class);
        startActivity(intent);
    }

    public void checkui(View view) {
    }

    public void doctorHome(View view) {
        Intent intent = new Intent(MainActivity.this, DoctorHome.class);
        startActivity(intent);
    }

    public void GetStockMana(View view) {
        Intent intent = new Intent(MainActivity.this, StockManagement.class);
        startActivity(intent);
    }
}
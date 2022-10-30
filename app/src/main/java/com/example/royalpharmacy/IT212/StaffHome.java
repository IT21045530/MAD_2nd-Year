package com.example.royalpharmacy.IT212;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.royalpharmacy.HomeView;
import com.example.royalpharmacy.R;

import androidx.appcompat.app.AppCompatActivity;

public class StaffHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staff_home_view);

    }

    public void addmedicine(View view) {
        Intent intent = new Intent(StaffHome.this, AddMedicine.class);
        startActivity(intent);
    }

    public void vieworders(View view) {
        Intent intent = new Intent(StaffHome.this, ShowCart.class);
        startActivity(intent);
    }
}

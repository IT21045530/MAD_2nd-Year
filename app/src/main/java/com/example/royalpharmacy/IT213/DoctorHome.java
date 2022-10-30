package com.example.royalpharmacy.IT213;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.royalpharmacy.R;

import androidx.appcompat.app.AppCompatActivity;

public class DoctorHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_home_view);
    }

    public void addNotes(View view) {
        Intent intent = new Intent(DoctorHome.this, AddNotes.class);
        startActivity(intent);
    }

    public void getRequest(View view) {
        Intent intent = new Intent(DoctorHome.this, MedicineRequests.class);
        startActivity(intent);
    }
}

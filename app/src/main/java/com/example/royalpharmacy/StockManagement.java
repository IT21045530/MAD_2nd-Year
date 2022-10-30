package com.example.royalpharmacy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.royalpharmacy.IT213.AddNotes;
import com.example.royalpharmacy.IT213.DoctorHome;

import androidx.appcompat.app.AppCompatActivity;

public class StockManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stock_home_view);
    }

    public void addNewStock(View view) {
        Intent intent = new Intent(StockManagement.this, AddStock.class);
        startActivity(intent);
    }

    public void getRequest(View view) {
        Intent intent = new Intent(StockManagement.this, RequestedStock.class);
        startActivity(intent);
    }

    public void getAvailableStock(View view) {
        Intent intent = new Intent(StockManagement.this, AvailableStock.class);
        startActivity(intent);
    }

    public void updateStock(View view) {
        Intent intent = new Intent(StockManagement.this, UpdateStock.class);
        startActivity(intent);
    }
}

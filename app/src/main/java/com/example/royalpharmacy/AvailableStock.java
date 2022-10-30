package com.example.royalpharmacy;

import android.os.Bundle;
import android.view.View;


import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class AvailableStock extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.availble_stock);
        mRecyclerView= (RecyclerView) findViewById(R.id.availbleList);

        new StockHolder().stockRead(new StockHolder.DataStatus() {
            @Override
            public void DataIsLoaded(List<Stock> stocks, List<String> keys) {
                findViewById(R.id.Loadingdata).setVisibility(View.GONE);
                new StockListView().setConfig(mRecyclerView, AvailableStock.this, stocks,keys);
            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });


    }
}

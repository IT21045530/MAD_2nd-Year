package com.example.royalpharmacy.IT213;

import android.os.Bundle;
import android.view.View;

import com.example.royalpharmacy.IT212.Medicine;
import com.example.royalpharmacy.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ShowCart extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_cart);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView_Item);


        new CartHolder().rateRead(new CartHolder.DataStatus() {
            @Override
            public void DataIsLoaded(List<Note> carts, List<String> keys) {
                findViewById(R.id.Loading).setVisibility(View.GONE);
                new MedicineRecyclerView().setConfig(mRecyclerView, ShowCart.this, carts,keys);
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

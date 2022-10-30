package com.example.royalpharmacy;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class StockHolder {
    private FirebaseDatabase firebase;
    private DatabaseReference reference;
    private List<Stock> stocks =new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Stock> stocks, List<String> keys);
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public StockHolder() {
        firebase = FirebaseDatabase.getInstance();
        reference = firebase.getReference("stocks");

    }

    public void stockRead(final StockHolder.DataStatus dataStatus){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stocks.clear();
                List<String> keys=new ArrayList<>();
                for (DataSnapshot keyNode:dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Stock value=keyNode.getValue(Stock.class);
                    stocks.add(value);
                }
                dataStatus.DataIsLoaded(stocks,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void stockUpdate(String key, Stock stock, final StockHolder.DataStatus dataStatus){
        reference.child(key).setValue(stock).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }

    public void stockDelete(String key, final StockHolder.DataStatus dataStatus){
        reference.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }
}

package com.example.royalpharmacy.IT212;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class CartHolder {

    private FirebaseDatabase firebase;
    private DatabaseReference reference;
    private List<Medicine> carts =new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Medicine> carts, List<String> keys);
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public CartHolder() {
        firebase = FirebaseDatabase.getInstance();
        reference = firebase.getReference("medicine");

    }

    public void rateRead(final DataStatus dataStatus){
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                carts.clear();
                List<String> keys=new ArrayList<>();
                for (DataSnapshot keyNode:dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Medicine cart=keyNode.getValue(Medicine.class);
                    carts.add(cart);
                }
                dataStatus.DataIsLoaded(carts,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void rateUpdate(String key, Medicine cart, final DataStatus dataStatus){
        reference.child(key).setValue(cart).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsUpdated();
            }
        });
    }

    public void rateDelete(String key, final DataStatus dataStatus){
        reference.child(key).setValue(null).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                dataStatus.DataIsDeleted();
            }
        });
    }



}

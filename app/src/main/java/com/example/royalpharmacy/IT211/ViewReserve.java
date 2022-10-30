package com.example.royalpharmacy.IT211;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.royalpharmacy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ViewReserve extends AppCompatActivity {

    EditText oID;
    Button searcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_reservation);

        oID = findViewById(R.id.editTextoid);

        searcher = findViewById(R.id.serchbtn);

        searcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String orderID = oID.getText().toString().trim();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("reserves");
                Query checkOrder = reference.orderByChild("orderId").equalTo(orderID);
                checkOrder.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
//                            orderID.setError(null)
                                String oIDFromDB = dataSnapshot.child(orderID).child("orderId").getValue(String.class);
                                String nameFromDB = dataSnapshot.child(orderID).child("oName").getValue(String.class);
                                String ageFromDB = dataSnapshot.child(orderID).child("oAge").getValue(String.class);
                                String dateFromDB = dataSnapshot.child(orderID).child("oDate").getValue(String.class);
                                Intent intent = new Intent(ViewReserve.this, UpdateReserve.class);
                                intent.putExtra("orderId", oIDFromDB);
                                intent.putExtra("oName", nameFromDB);
                                intent.putExtra("oAge", ageFromDB);
                                intent.putExtra("oDate", dateFromDB);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "Request Completed", Toast.LENGTH_SHORT).show();

                        } else {

                            oID.setError("Try Again");
                            oID.requestFocus();
                        }
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

    }
}

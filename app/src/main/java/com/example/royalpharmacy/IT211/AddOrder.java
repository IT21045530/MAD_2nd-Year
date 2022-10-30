package com.example.royalpharmacy.IT211;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.royalpharmacy.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class AddOrder extends AppCompatActivity {

    EditText orderId;
    EditText pName;
    EditText pAge;
    EditText oDate;

    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    Button addOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_order);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("reserves");

        orderId = (EditText) findViewById(R.id.reserveId);
        pName = (EditText) findViewById(R.id.editTextTextPersonName10);
        pAge = (EditText) findViewById(R.id.editTextTextPersonName11);
        oDate = (EditText) findViewById(R.id.editTextTextPersonName12);
        addOrder = findViewById(R.id.button8);


        addOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = orderId.getText().toString();
                String name = pName.getText().toString();
                String age = pAge.getText().toString();
                String date = AddOrder.this.oDate.getText().toString();

                if(id.isEmpty() || name.isEmpty() ||  age.isEmpty() || date.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Fill all Fields",Toast.LENGTH_SHORT).show();
                }else {
                    Order orders = new Order(id, name, age, date);
                    mRef.child(id).setValue(orders);

                    Toast.makeText(getApplicationContext(), "Successfully Reserved Order", Toast.LENGTH_SHORT).show();
                    orderId.setText("");
                    pName.setText("");
                    pAge.setText("");
                    oDate.setText("");
                }
            }
        });

    }

    public void viewReserve(View view) {
        Intent intent = new Intent(AddOrder.this, ViewReserve.class);
        startActivity(intent);
    }
}

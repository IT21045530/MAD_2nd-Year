package com.example.royalpharmacy.IT211;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.royalpharmacy.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateReserve extends AppCompatActivity {

    TextView orderId;
    EditText pName;
    EditText pAge;
    EditText oDate;

    FirebaseDatabase mDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_order_view);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("reserves");

        orderId = (TextView) findViewById(R.id.reserveId1);
        pName = (EditText) findViewById(R.id.editTextTextPersonName22);
        pAge = (EditText) findViewById(R.id.editTextTextPersonName23);
        oDate = (EditText) findViewById(R.id.editTextTextPersonName24);


        String  orderID = getIntent().getStringExtra("orderId");
        String orderCusName = getIntent().getStringExtra("oName");
        String orderCusAge = getIntent().getStringExtra("oAge");
        String orderDate = getIntent().getStringExtra("oDate");

        orderId.setText(orderID);
        pName.setText(orderCusName);
        pAge.setText(orderCusAge);
        oDate.setText(orderDate);

    }

    public void DeleteOrder(View view) {
        String id = orderId.getText().toString();
        mRef.child(id).setValue(null);
        Toast.makeText(UpdateReserve.this, "Order Removed", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(UpdateReserve.this, AddOrder.class);
        startActivity(intent);
    }

    public void UpdateOrder(View view) {
        String id = orderId.getText().toString();
        String name = pName.getText().toString();
        String age = pAge.getText().toString();
        String date = UpdateReserve.this.oDate.getText().toString();

        if(id.isEmpty() || name.isEmpty() ||  age.isEmpty() || date.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please Fill all Fields",Toast.LENGTH_SHORT).show();
        }else {
            Order orders = new Order(id, name, age, date);
            mRef.child(id).setValue(orders);

            Toast.makeText(getApplicationContext(), "Successfully Updated Order", Toast.LENGTH_SHORT).show();

        }
    }
}

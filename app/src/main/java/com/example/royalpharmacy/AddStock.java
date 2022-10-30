package com.example.royalpharmacy;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.royalpharmacy.IT213.Note;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class AddStock extends AppCompatActivity {
    EditText type, quantity, price;
    Button add;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_stock);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("stocks");

        type = (EditText) findViewById(R.id.stockName);
        quantity = (EditText) findViewById(R.id.stockQuantity);
        price = (EditText) findViewById(R.id.stockprice);
        add = (Button) findViewById(R.id.addstock);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stockType = type.getText().toString();
                String stockQuantity = quantity.getText().toString();
                String stockTotal = price.getText().toString();

                if(stockType.isEmpty() || stockQuantity.isEmpty() ||  stockTotal.isEmpty() ){
                    Toast.makeText(getApplicationContext(),"Please Fill All Inputs",Toast.LENGTH_SHORT).show();
                }else {
                    Stock pharmacist = new Stock(stockType, stockQuantity, stockTotal);
                    reference.child(stockType).setValue(pharmacist);

                    Toast.makeText(getApplicationContext(), "New Stock added", Toast.LENGTH_SHORT).show();
                    type.setText("");
                    quantity.setText("");
                    price.setText("");
                }
            }
        });
    }

}

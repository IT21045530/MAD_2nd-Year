package com.example.royalpharmacy;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;


public class UpdateStock extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    EditText type, quantity, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_stock);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("stocks");

        type = (EditText) findViewById(R.id.stockNameupdate);
        quantity = (EditText) findViewById(R.id.quantityupdate);
        price = (EditText) findViewById(R.id.priceupdate);

        String  stocktype = getIntent().getStringExtra("name");
        String stockquantity = getIntent().getStringExtra("quantity");
        String srockprice = getIntent().getStringExtra("prize");

        type.setText(stocktype);
        quantity.setText(stockquantity);
        price.setText(srockprice);


    }

    public void update(View view) {

                String stockType = type.getText().toString();
                String stockQuantity = quantity.getText().toString();
                String stockTotal = price.getText().toString();

                if(stockType.isEmpty() || stockQuantity.isEmpty() ||  stockTotal.isEmpty() ){
                    Toast.makeText(getApplicationContext(),"Please Fill All Inputs",Toast.LENGTH_SHORT).show();
                }else {
                    Stock pharmacist = new Stock(stockType, stockQuantity, stockTotal);
                    reference.child(stockType).setValue(pharmacist);

                    Toast.makeText(getApplicationContext(), "Stock Updated", Toast.LENGTH_SHORT).show();
                    type.setText("");
                    quantity.setText("");
                    price.setText("");
                }
            }

}

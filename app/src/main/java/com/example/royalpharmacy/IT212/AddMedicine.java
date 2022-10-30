package com.example.royalpharmacy.IT212;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.royalpharmacy.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class AddMedicine extends AppCompatActivity {

    EditText medicineName, addDate, quantity;
    FirebaseDatabase mDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_medicine_view);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("medicine");

        medicineName = (EditText) findViewById(R.id.medicineName);
        addDate = (EditText) findViewById(R.id.medicineDate);
        quantity = (EditText) findViewById(R.id.medicineQun);
    }

    public void addMedicine(View view) {
        String medicineName = this.medicineName.getText().toString();
        String addDate = this.addDate.getText().toString();
        String quantity = this.quantity.getText().toString();

        if(medicineName.isEmpty() || addDate.isEmpty() ||  quantity.isEmpty() ){
            Toast.makeText(getApplicationContext(),"Please Fill all Fields",Toast.LENGTH_SHORT).show();
        }else {
            Medicine medicine = new Medicine(medicineName, addDate, quantity);
            mRef.child(medicineName).setValue(medicine);

            Toast.makeText(getApplicationContext(), "Successfully Added Medicine Details", Toast.LENGTH_SHORT).show();
            this.medicineName.setText("");
            this.addDate.setText("");
            this.quantity.setText("");
        }
    }
}

package com.example.royalpharmacy.IT213;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.royalpharmacy.IT213.Note;
import com.example.royalpharmacy.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateNote extends AppCompatActivity {

    EditText noteID, noteDate, description;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_update_view);

        noteID = (EditText) findViewById(R.id.notenumber1);
        noteDate = (EditText) findViewById(R.id.date1);
        description = (EditText) findViewById(R.id.about1);

        String  stocktype = getIntent().getStringExtra("name");
        String stockquantity = getIntent().getStringExtra("quantity");
        String srockprice = getIntent().getStringExtra("add");

        noteID.setText(stocktype);
        noteDate.setText(stockquantity);
        description.setText(srockprice);
    }

    public void updateNote(View view) {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("doctorNotes");
        String noteID = this.noteID.getText().toString();
        String noteAddDate = noteDate.getText().toString();
        String noteAbout = description.getText().toString();

        if(noteID.isEmpty() || noteAddDate.isEmpty() ||  noteAbout.isEmpty() ){
            Toast.makeText(getApplicationContext(),"Please Check Again",Toast.LENGTH_SHORT).show();
        }else {
            Note note = new Note(noteID, noteAddDate, noteAbout);
            databaseReference.child(noteID).setValue(note);

            Toast.makeText(getApplicationContext(), "note Updated", Toast.LENGTH_SHORT).show();

        }
    }
}

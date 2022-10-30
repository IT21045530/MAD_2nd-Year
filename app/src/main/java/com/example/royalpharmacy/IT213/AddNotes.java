package com.example.royalpharmacy.IT213;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.royalpharmacy.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class AddNotes extends AppCompatActivity {

    EditText noteID, noteDate, description;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_notes_view);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("doctorNotes");

        noteID = (EditText) findViewById(R.id.notenumber);
        noteDate = (EditText) findViewById(R.id.date);
        description = (EditText) findViewById(R.id.about55);
    }

    public void addNewNote(View view) {
        String noteid = noteID.getText().toString();
        String noteAddDate = noteDate.getText().toString();
        String noteAbout = description.getText().toString();

        if(noteid.isEmpty() || noteAddDate.isEmpty() ||  noteAbout.isEmpty() ){
            Toast.makeText(getApplicationContext(),"Please Check Again",Toast.LENGTH_SHORT).show();
        }else {
            Note note = new Note(noteid, noteAddDate, noteAbout);
            databaseReference.child(noteid).setValue(note);

            Toast.makeText(getApplicationContext(), "New note added", Toast.LENGTH_SHORT).show();
            this.noteID.setText("");
            noteDate.setText("");
            description.setText("");
        }
    }

    public void deleteNote(View view) {
        String noteID = this.noteID.getText().toString();

        if(noteID.isEmpty() ){
            Toast.makeText(getApplicationContext(),"Please Enter NoteID",Toast.LENGTH_SHORT).show();
        }else {
            databaseReference.child(noteID).setValue(null);
            Toast.makeText(getApplicationContext(), "Note Deleted", Toast.LENGTH_SHORT).show();
            this.noteID.setText("");
            noteDate.setText("");
            description.setText("");
        }
    }



    public void viewRequest(View view) {
        Intent intent = new Intent(AddNotes.this, ShowCart.class);
        startActivity(intent);
    }

    public void updateNote(View view) {
        Intent intent = new Intent(AddNotes.this, UpdateNote.class);
        startActivity(intent);
    }
}

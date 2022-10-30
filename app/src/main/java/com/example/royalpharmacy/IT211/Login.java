package com.example.royalpharmacy.IT211;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.royalpharmacy.HomeView;
import com.example.royalpharmacy.MainActivity;
import com.example.royalpharmacy.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    EditText uName,uPassword;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_view);
        uName = findViewById(R.id.editText1);
        uPassword = findViewById(R.id.editText2);

        btn = findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String adminUsername = uName.getText().toString().trim();
                final String adminPasswored = uPassword.getText().toString().trim();
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
                Query checkUser = reference.orderByChild("username").equalTo(adminUsername);
                checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            uName.setError(null);

                            String passwordFromDB = dataSnapshot.child(adminUsername).child("password").getValue(String.class);
                            if (passwordFromDB.equals(adminPasswored)) {
                                uName.setError(null);

                                String nameFromDB = dataSnapshot.child(adminUsername).child("username").getValue(String.class);
                                String phone = dataSnapshot.child(adminUsername).child("phoneNo").getValue(String.class);
                                String email = dataSnapshot.child(adminUsername).child("email").getValue(String.class);
                                String passwored = dataSnapshot.child(adminUsername).child("password").getValue(String.class);
                                Intent intent = new Intent(getApplicationContext(), HomeView.class);
                                intent.putExtra("name", nameFromDB);
                                intent.putExtra("phone", phone);
                                intent.putExtra("email", email);
                                intent.putExtra("passwored", passwored);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "Successfully Admin Logged", Toast.LENGTH_SHORT).show();
                            } else {

                                uPassword.setError("Wrong Password");
                                uPassword.requestFocus();
                            }
                        } else {

                            uPassword.setError("No such Admin exist");
                            uName.requestFocus();
                        }
                    }



                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });


    }

    public void getSignUp(View view) {
        Intent intent = new Intent(Login.this, SignUp.class);
        startActivity(intent);
    }
}

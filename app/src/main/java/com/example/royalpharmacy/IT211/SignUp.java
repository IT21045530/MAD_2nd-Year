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

public class SignUp extends AppCompatActivity {

    EditText name, email, phone, password;
    Button signUp;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_view);
        signUp = findViewById(R.id.getAdminLogin);

        name = findViewById(R.id.editText8);
        phone = findViewById(R.id.editText5);
        email = findViewById(R.id.editText4);

        password = findViewById(R.id.editTextTextPassword);
        signUp = findViewById(R.id.button6);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("users");


                String username = name.getText().toString();
                String useremail = email.getText().toString();
                String phoneNo = phone.getText().toString();
                String userpassword = SignUp.this.password.getText().toString();

                if(username.isEmpty() || useremail.isEmpty() ||  phoneNo.isEmpty() || userpassword.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please Fill all Fields",Toast.LENGTH_SHORT).show();
                }else {
                    User userclass = new User(username, useremail, phoneNo, userpassword);
                    reference.child(username).setValue(userclass);

                    Toast.makeText(getApplicationContext(), "Successfully User Added", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUp.this, Login.class);
                    startActivity(intent);
                }
            }
        });

    }
}

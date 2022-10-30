package com.example.royalpharmacy.IT211;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.royalpharmacy.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateProfile extends AppCompatActivity {

    EditText name, email, phone, password, newpass;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_profile);

        name = findViewById(R.id.username);
        phone = findViewById(R.id.userphone);
        email = findViewById(R.id.useremail);

        password = findViewById(R.id.userpasswored);
        String  userName = getIntent().getStringExtra("name");
        String  phone1 = getIntent().getStringExtra("phone");
        String  email1 = getIntent().getStringExtra("email");
        String  passwored1 = getIntent().getStringExtra("passwored");
        name.setText(userName);
        phone.setText(phone1);
        email.setText(email1);
        password.setText(passwored1);





    }

    public void updateUser(View view) {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");


        String username = name.getText().toString();
        String useremail = email.getText().toString();
        String phoneNo = phone.getText().toString();
        String userpassword = UpdateProfile.this.password.getText().toString();


            User userclass = new User(username, useremail, phoneNo, userpassword);
            reference.child(username).setValue(userclass);

            Toast.makeText(getApplicationContext(), "User Updated", Toast.LENGTH_SHORT).show();


    }

    public void deleteUser(View view) {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("users");
        String username = name.getText().toString();

        if(username.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter Name",Toast.LENGTH_SHORT).show();
        }else {
            reference.child(username).setValue(null);
            Toast.makeText(getApplicationContext(), "User Removed", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UpdateProfile.this, Login.class);
            startActivity(intent);
        }
    }
}

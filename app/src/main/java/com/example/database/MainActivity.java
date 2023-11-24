package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText txtUsername, txtPassword;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        txtUsername = (EditText) findViewById(R.id.username_text);
        txtPassword = (EditText) findViewById(R.id.password_text);

        btnRegister = (Button) findViewById(R.id.newuser_btn);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if(username.equals("")||password.equals("")){
                    Toast.makeText(getApplicationContext(), "Fields are empty!", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkUsername = db.checkUsername(username);
                    if (checkUsername==true){
                        Boolean insert = db.insert(username,password);
                        Toast.makeText(getApplicationContext(), "Register Successful!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "User already exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        //btnLogin = (Button)findViewById(R.id.btnLogin);
    }
}
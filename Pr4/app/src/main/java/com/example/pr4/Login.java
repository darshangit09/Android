package com.example.pr4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText e1,e2;
    String s1,s2;
    DataStore ds;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1=findViewById(R.id.Name1);
        e2=findViewById(R.id.Password1);

        b1=findViewById(R.id.Login1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();

                ds=new DataStore(getApplicationContext());
                if (ds.login(s1,s2)){
                    Intent i=new Intent(Login.this, Home.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(Login.this,"Invalid credentials",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
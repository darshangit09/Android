package com.example.pr4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    DataStore ds;
    String s1,s2,s3,s4,s5,s6;

    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.Name);
        e2=findViewById(R.id.Email);
        e3=findViewById(R.id.DOB);
        e4=findViewById(R.id.Phone);
        e5=findViewById(R.id.Address);
        e6=findViewById(R.id.Password);

        b1=findViewById(R.id.Login);
        b2=findViewById(R.id.Registration);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ds=new DataStore(getApplicationContext());

                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=e6.getText().toString();

                if(ds.addData(s1,s2,s3,s4,s5,s6)){
                    Intent i= new Intent( MainActivity.this, Login.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity.this,"Registration unsuccessful", Toast.LENGTH_LONG ).show();
                }

            }
        });

    }
}
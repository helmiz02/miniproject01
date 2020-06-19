package com.example.miniproject;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    private EditText log;
    private EditText pass;

    private Button loginB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        log = (EditText) findViewById(R.id.username);
        pass =  (EditText) findViewById(R.id.password);

        loginB = (Button) findViewById(R.id.login);


        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( (log.getText().toString()).equals("admin")&&(pass.getText().toString()).equals("admin")){

                    Toast.makeText(login.this,"Connection Verified",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(login.this,MainActivity.class);
                    startActivity(intent);
                }else
                {


                    Toast.makeText(login.this,"Connection Denied !",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}

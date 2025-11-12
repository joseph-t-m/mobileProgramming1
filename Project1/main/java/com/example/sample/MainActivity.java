package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button login_Button, register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button register_Button = findViewById(R.id.register_Button);
        Button login_Button = findViewById(R.id.login_Button);
        register_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(intent);
            }
        });
        } // onCreate
    } // MainActivity



//        openSite = findViewById(R.id.register_button);
//        openSite.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                String str = "https://Google.com"; // Make sure to provide a valid URL
//                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));
//            } // onClick
//        }); // setOnClickListener
//
//        call = findViewById(R.id.login_button);
//        call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                // Corrected the method to set data
//                intent.setData(Uri.parse("tel: 09017409068")); // Fixed the syntax issue here
//                startActivity(intent);
//            } // onClick
//        }); // setOnClickListener

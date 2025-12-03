package com.example.sample;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.graphics.Color;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    ConstraintLayout constraintLayout;

    TextView textView;

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getTitle() == "Blue") {
            constraintLayout.setBackgroundColor(Color.parseColor("#abdbe3"));
        } else if (item.getTitle() == "Light Orchid") {
            constraintLayout.setBackgroundColor(Color.parseColor("#e3abd9"));
        } else if (item.getTitle() == "Green") {
            constraintLayout.setBackgroundColor(Color.parseColor("#cbe3ab"));
        }
        return true;
    }//onContextItemSelected
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose a color");
        menu.add( 0, v.getId(),  0, "Blue");
        menu.add( 0, v.getId(),  0, "Light Orchid");
        menu.add( 0, v.getId(),  0, "Green");
    }//onCreateContextMenu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        constraintLayout = findViewById(R.id.constraintLayout); textView = findViewById(R.id.textView);
        registerForContextMenu(textView);
    }//onCreate

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);

        return true;
    }
}
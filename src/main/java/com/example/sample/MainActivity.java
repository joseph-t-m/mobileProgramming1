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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout constraintLayout;
    TextView textView;

    //////////////float////////////////
    FloatingActionButton hintFab, camFab, locFab;
    TextView camText, locText;
    Boolean isAllFabsVisible;

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
        menu.add(0, v.getId(), 0, "Blue");
        menu.add(0, v.getId(), 0, "Light Orchid");
        menu.add(0, v.getId(), 0, "Green");
    }//onCreateContextMenu


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //////////////toolbar////////////////
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //////////////constraintLayout////////////////
//        constraintLayout = findViewById(R.id.constraintLayout);
//        textView = findViewById(R.id.textView);
//        registerForContextMenu(textView);



        //////////////float////////////////
        setContentView(R.layout.activity_main);
        hintFab.findViewById(R.id.hint_fab);
        camFab = findViewById(R.id.camera_fab);
        locFab = findViewById(R.id.location_fab);
        camText = findViewById(R.id.camera_fab);
        locText = findViewById(R.id.location_text);
        camFab.setVisibility(View.GONE);
        locFab.setVisibility(View.GONE);
        camText.setVisibility(View.GONE);
        locText.setVisibility(View.GONE);
        isAllFabsVisible = false;


        hintFab.setOnClickListener(view -> {
            if (!isAllFabsVisible) {
                camFab.show();
                locFab.show();
                camText.setVisibility(View.VISIBLE);
                locText.setVisibility(View.VISIBLE);

                isAllFabsVisible = true;
            } else {
                camFab.hide();
                locFab.hide();
                camText.setVisibility(View.GONE);
                locText.setVisibility(View.GONE);
                isAllFabsVisible = false;
            }
        });
        locFab.setOnClickListener(
                view -> Toast.makeText(MainActivity.this,
                        "Location is clicked", Toast.LENGTH_SHORT).show());
        camFab.setOnClickListener(
                view -> Toast.makeText(MainActivity.this,
                        "camphone is clicked", Toast.LENGTH_SHORT).show());
    }
    }






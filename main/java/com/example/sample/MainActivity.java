package com.example.sample;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

    public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.showbtn);
            btn.setOnClickListener(new View.OnClickListener() {

                @RequiresApi(api = Build.VERSION_CODES.Q)
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(MainActivity.this, v);
                    popup.setOnMenuItemClickListener(MainActivity.this);
                    popup.inflate(R.menu.popup_menu);
                    popup.show();
                    popup.setForceShowIcon(true);
                }
        });
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        Toast.makeText(this, "Selected item: " + item.getTitle(), Toast.LENGTH_SHORT).show();

        if (item.getItemId() == R.id.download){
            Intent intent1 = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent1);
        } else if (item.getItemId() == R.id.attach) {
            Intent intent2 = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent2);
        } else if (item.getItemId() == R.id.back) {
            Intent intent3 = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent3);
        } else if (item.getItemId() == R.id.approve) {
            Intent intent4 = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(intent4);
        }
        return true;

    }

}
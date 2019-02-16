package com.example.tasksession7sematec;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnDrawer;
    Button btnAdan;
    DrawerLayout drawerLayout;
    Button btnActive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDrawer = findViewById(R.id.btnDrawer);
        btnAdan = findViewById(R.id.btnAdan);
        drawerLayout = findViewById(R.id.drawerLayout);
        btnActive = findViewById(R.id.btnActive);

        btnActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This btn is activated", Toast.LENGTH_LONG).show();
            }
        });



        btnDrawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        btnAdan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maintoAdanTime = new Intent(MainActivity.this,AdanTime.class);
                startActivity(maintoAdanTime);
            }
        });


    }
}

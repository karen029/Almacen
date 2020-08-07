package com.example.almacen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button btnprod;
    Button btnprov;
    Button btnColab;


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Menu.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menul);
        btnprod = (Button) findViewById(R.id.btnprod);
        btnprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Registraprodu.class);
                startActivity(intent);
                finish();
            }
        });
        btnprov = (Button) findViewById(R.id.btnprov);
        btnprov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Registraproveed.class);
                startActivity(intent);
                finish();
            }
        });
        btnColab = (Button) findViewById(R.id.btncolab);
        btnColab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Registracolab.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
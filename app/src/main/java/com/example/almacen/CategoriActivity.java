package com.example.almacen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoriActivity extends AppCompatActivity {
CardView btnlibro;
CardView btnmanu;
CardView btncoc;
CardView btnofic;
CardView btnlim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categori);
        btnlibro = (CardView) findViewById(R.id.btnlibro);
        btnlibro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(CategoriActivity.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });
        btnmanu= (CardView) findViewById(R.id.btnmanu);
        btnmanu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(CategoriActivity.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });
        btncoc= (CardView) findViewById(R.id.btncocina);
        btncoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(CategoriActivity.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });
        btnofic= (CardView) findViewById(R.id.btnofic);
        btnofic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(CategoriActivity.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });
        btnlim= (CardView) findViewById(R.id.btnlim);
        btnlim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(CategoriActivity.this, Menu.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(CategoriActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
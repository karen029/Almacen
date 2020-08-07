package com.example.almacen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Registraprodu extends AppCompatActivity {
    FloatingActionButton fabingresar;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Registraprodu.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verproducto);

    }
}
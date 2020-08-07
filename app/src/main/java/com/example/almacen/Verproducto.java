package com.example.almacen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.almacen.adapters.ArticuloAdapter;
import com.example.almacen.entity.Articulo;
import com.example.almacen.publico.Funciones;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;

import java.util.ArrayList;



public class Verproducto extends AppCompatActivity {
    FloatingActionButton fabingresar;
    RecyclerView rvArticulos;
    ArrayList<Articulo> articulos;
    ArticuloAdapter articuloAdapter;

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Verproducto.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraproducto);
¿

        fabingresar= (FloatingActionButton) findViewById(R.id.fabingresar);
        rvArticulos = (RecyclerView) findViewById(R.id.rvArticulos);

        rvArticulos.setLayoutManager(new LinearLayoutManager(this)); //asignarle una forma de agrupamiento (lineal y vertical en este caso)
        cargarDatos();
        fabingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(Verproducto.this, Registraprodu.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void cargarDatos() {
        articulos = new ArrayList<>();
        Log.i("cargarDatos", "Verproducto");
        Thread tr = new Thread() { //creamos una nueva tarea
            @Override
            public void run() {
                //asignamos la consulta al procedimiento "primero" que creamos en la clase Funciones
                final String result = Funciones.primero("http://bootcampdojo.com/impacto/select_producto.php");
                Log.i("cargarDatos", result);
                runOnUiThread(new Runnable() { //Arrancamos desde el procedimiento principal
                    @Override
                    public void run() {
                        int r = Funciones.segundo(result); //asignamos el resultado de la consulta para revisar si tiene contenido
                        if (r > 0) {
                            try {
                                JSONArray jsonArray = new JSONArray(result); //convertimos el resultado en Array
                                for (int i = 0; i < jsonArray.length(); i++) { //recorremos el array
                                    //asignamos el valor de cada elemento de JSON en una variable de texto
                                    String idArticulo = jsonArray.getJSONObject(i).getString("idarticulo");
                                    String nombreArticulo = jsonArray.getJSONObject(i).getString("nombre");
                                    String stock = jsonArray.getJSONObject(i).getString("stock");
                                    //agregamos todos los elementos de la fila a u registro de nuestro ArrayList de articulos
                                    articulos.add(new Articulo(idArticulo, nombreArticulo, stock));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        //asignamos un ocntexto y la lista de datos a un nuevo adaptador
                        articuloAdapter = new ArticuloAdapter(Verproducto.this, articulos);
                        rvArticulos.setAdapter(articuloAdapter); //asignamos el adaptador al RecyclerView
                    }
                });
            }
        };
        tr.start(); //iniciamos la tarea de webservice
    }
}
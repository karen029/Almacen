package com.example.almacen.publico;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Funciones {

    public static String primero(String direccion) {
        URL url; //para la url de tu php
        String linea = ""; //cada línea de resultado
        int respuesta = 0; //respuesta de la conexión
        StringBuilder result = null; //resultado
        try {
            url = new URL(direccion); //creamos la url recibida como parámetro
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //abrimos la conexión http
            respuesta = connection.getResponseCode(); //obtenemos la respuesta
            result = new StringBuilder(); //empezamos a construir el resultado
            if (respuesta == HttpURLConnection.HTTP_OK) { //si la conexión se realizó correctamente
                InputStream in = new BufferedInputStream(connection.getInputStream()); //crea una nueva entrada de datos
                BufferedReader reader = new BufferedReader(new InputStreamReader(in)); //y una lectura de datos
                while ((linea = reader.readLine()) != null) { //mientras existan datos
                    result.append(linea); //agrega esos datos al resultado
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString(); //devuelve el resultado como String
    }

    //comprueba que response tenga contenido y devuelve 1 si tiene contenido, 0 si está vacío
    public static int segundo(String response) {
        int res = 0;
        if (response != null) {
            res = 1;
        }
        return res;
    }
}

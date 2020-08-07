package com.example.almacen.entity;

public class Articulo {
    private String idArticulo;
    private String nombreArticulo;
    private String stock;

    public Articulo(String idArticulo, String nombreArticulo, String stock) {
        this.idArticulo = idArticulo;
        this.nombreArticulo = nombreArticulo;
        this.stock = stock;
    }

    public String getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(String idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}

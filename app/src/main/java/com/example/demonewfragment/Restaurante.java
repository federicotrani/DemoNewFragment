package com.example.demonewfragment;

public class Restaurante {
    private String nombre;
    private String urlFoto;
    private float valoracion;
    private String domicilio;

    public Restaurante(String nombre, String urlFoto, float valoracion, String domicilio) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.valoracion = valoracion;
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}

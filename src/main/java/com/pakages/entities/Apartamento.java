package com.pakages.entities;


public class Apartamento {
    private int id, piso, numero, torre;
    private double arriendo;
    private String estado, descripcion;
    private boolean propiedad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTorre() {
        return torre;
    }

    public void setTorre(int torre) {
        this.torre = torre;
    }

    public double getArriendo() {
        return arriendo;
    }

    public void setArriendo(double arriendo) {
        this.arriendo = arriendo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isPropiedad() {
        return propiedad;
    }

    public void setPropiedad(boolean propiedad) {
        this.propiedad = propiedad;
    }
    
    
}

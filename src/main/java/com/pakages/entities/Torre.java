package com.pakages.entities;

/**
 *
 * @author Usuario
 */
public class Torre {
    private String nombre;
    private int id, pisos, apts, ocupados, reparacion, disponibles;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    public int getApts() {
        return apts;
    }

    public void setApts(int apts) {
        this.apts = apts;
    }

    public int getId() {
        return id;
    }

    public void setId(int conjunto) {
        this.id = conjunto;
    }

    public int getOcupados() {
        return ocupados;
    }

    public void setOcupados(int ocupados) {
        this.ocupados = ocupados;
    }

    public int getReparacion() {
        return reparacion;
    }

    public void setReparacion(int reparacion) {
        this.reparacion = reparacion;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }    
}

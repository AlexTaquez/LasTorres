package com.pakages.entities;

import java.util.Date;

public class Habitante {
    private int id, idResidente, idApt;
    private Date inicio;//
    private Date fin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdResidente() {
        return idResidente;
    }

    public void setIdResidente(int idResidente) {
        this.idResidente = idResidente;
    }

    public int getIdApt() {
        return idApt;
    }

    public void setIdApt(int idApt) {
        this.idApt = idApt;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
    
}

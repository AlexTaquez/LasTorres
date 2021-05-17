/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakages.dao;

import com.pakages.entities.Apartamento;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        ApartamentoDAO a = new ApartamentoDAO();
        
        int torre = 35;
        int id = 0;
        for (int t = 1; t <= 4; t++) {//torre
            for (int p = 1; p <= 5; p++) {//pisos
                for (int n = 1; n <= 4; n++) {//apt por piso
                    id=id+1;
                    Apartamento apt = new Apartamento();
                    //apt.setId(id);
                    apt.setNumero(n);
                    apt.setPiso(p);
                    apt.setPropiedad(true);
                    apt.setArriendo(550000.00);
                    apt.setEstado("D");
                    apt.setDescripcion("NUEVO");
                    apt.setTorre(torre);
                    
                    a.registrar(apt);
                    System.err.println(">>" + t+p+n);
                    
                }
            }
            torre++;
        }
    }
    
}

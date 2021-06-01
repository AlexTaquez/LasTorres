package com.pakages.dao;

import com.pakages.entities.Deudor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultasDAO extends Conexion{
    
    //LISTA DE DEUDORES
    public List<Deudor> listaDeudores() throws SQLException{
       List<Deudor> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT * FROM(" +
            " SELECT F.idFactura, F.valor, F.residenteFk, F.aptFk, F.termino, F.estado," +
            " R.nombres, R.apellidos" +
            " FROM residente R JOIN factura F" +
            " ON R.idResidente=F.residenteFk) FA" +//FACTURA JOIN RESIDENTE
        " JOIN (" +
            " SELECT A.idApt, A.piso, A.numero, T.nombre" +//APARTAMENTO JOIN TORRE
            " FROM apartamento A JOIN torre T" +
            " ON A.idTorre=T.idTorre" +
            " )AP ON FA.aptFK = AP.idApt" +
        " WHERE FA.estado='PENDIENTE' AND FA.termino<'2021-05-31'";
        try {
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Deudor deu = new Deudor();
            
            deu.setId(resultSet.getInt(1));
            deu.setValor(resultSet.getString(2));
            deu.setIdDeudor(resultSet.getInt(3));
            deu.setIdApt(resultSet.getInt(4));
            deu.setTermino(resultSet.getString(5));
            deu.setEstado(resultSet.getString(6));
            deu.setNombres(resultSet.getString(7));
            deu.setApellidos(resultSet.getString(8));
            deu.setIdApt(resultSet.getInt(9));
            deu.setApartamento(resultSet.getInt(10)+"0"+resultSet.getInt(11));
            deu.setTorre(resultSet.getString(12));

            
            lista.add(deu);
        }
       
        con.commit();
        ps.close();
        return lista;
        
        } catch(SQLException e){
            System.err.println("Error al LISTAR POR ID >>>  "+e);
            return null;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println("Erros al intentar cerrar>>>"+ e);
            }
        }
       
    } 
    
}

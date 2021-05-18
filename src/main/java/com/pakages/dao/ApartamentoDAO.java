package com.pakages.dao;

import com.pakages.entities.Apartamento;
import com.pakages.entities.Torre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApartamentoDAO extends Conexion {
    
    public boolean registrar(Apartamento apt) throws SQLException{
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        String sql ="INSERT INTO apartamento"+
                    "(idApt, piso, numero, propiedad, arriendo, estado, descripcion, idTorre)"+
                    " VALUES(?,?,?,?,?,?,?,?)";//8  
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, apt.getId());
            ps.setInt(2, apt.getPiso());
            ps.setInt(3, apt.getNumero());
            ps.setBoolean(4, apt.isPropiedad());
            ps.setDouble(5, apt.getArriendo());
            ps.setString(6, apt.getEstado());
            ps.setString(7, apt.getDescripcion());
            ps.setInt(8, apt.getTorre());
            
            ps.execute();
            con.commit();
            ps.close();
            con.close();
            //System.out.println("RETURN");
            return true;
            
        }catch(SQLException e){
            System.err.println("Error al incertar>>>  "+e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println("Erros al intentar cerrar>>>"+ e);
            }
        }
    }
    
    public List<Torre> listaTorres() throws SQLException{
        List<Torre> lista = new ArrayList<>();
        
        PreparedStatement psTorres;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);

        String sql ="SELECT idTorre, nombre, nPisos, nApt, " +
                    "(SELECT COUNT(idApt) FROM apartamento " +
                    "WHERE idTorre=torre.idTorre AND estado = 'O'), " +//OCUPADOS
                    "(SELECT COUNT(idApt) FROM apartamento " +
                    "WHERE idTorre=torre.idTorre AND estado = 'D'), " +//DESOCUPADOS O DISPONIBLES
                    "(SELECT COUNT(idApt) FROM apartamento " +
                    "WHERE idTorre=torre.idTorre AND estado = 'M') " +//EN MANTENIMIENTO
                    "FROM torre";
        
        psTorres = con.prepareStatement(sql);
        ResultSet resultSet = psTorres.executeQuery(sql);
        
        while (resultSet.next()) {
                       
            Torre torre = new Torre();
            torre.setId(resultSet.getInt(1));
            torre.setNombre(resultSet.getString(2));
            torre.setPisos(resultSet.getInt(3));
            torre.setApts(resultSet.getInt(4));
            torre.setApts(resultSet.getInt(5));
            torre.setApts(resultSet.getInt(6));
            torre.setApts(resultSet.getInt(7));            
            
            lista.add(torre);
        }

        return lista;
    }
    
    //LISTA DE APARTAMENTOS POR TORRE
    public List<Apartamento> listaApts(int idTorre) throws SQLException{
       List<Apartamento> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT * FROM apartamento WHERE idTorre="+idTorre;
       ps = con.prepareStatement(sql);
       ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Apartamento apt = new Apartamento();
            
            apt.setId(resultSet.getInt(1));
            apt.setPiso(resultSet.getInt(2));
            apt.setNumero(resultSet.getInt(3));
            apt.setPropiedad(resultSet.getBoolean(4));
            apt.setArriendo(resultSet.getDouble(5));
            apt.setEstado(resultSet.getString(6));
            apt.setDescripcion(resultSet.getString(7));
            apt.setTorre(resultSet.getInt(8));
            
            lista.add(apt);
        }
       
        return lista;
    }
    //LISTA DE APARTAMENTOS DISPONIBLES POR TORRE
    public List<Apartamento> listaAptsDisp(int idTorre) throws SQLException{
       List<Apartamento> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT * FROM apartamento WHERE idTorre="+idTorre+" AND estado='D' ";//8 columnas
       ps = con.prepareStatement(sql);
       ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Apartamento apt = new Apartamento();
            
            apt.setId(resultSet.getInt(1));
            apt.setPiso(resultSet.getInt(2));
            apt.setNumero(resultSet.getInt(3));
            apt.setPropiedad(resultSet.getBoolean(4));
            apt.setArriendo(resultSet.getDouble(5));
            apt.setEstado(resultSet.getString(6));
            apt.setDescripcion(resultSet.getString(7));
            apt.setTorre(resultSet.getInt(8));
            
            lista.add(apt);
        }
       
        return lista;
    }
    //ACTUALIZAR  
    public boolean actualizar(Apartamento apt) throws SQLException{
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        String sql ="UPDATE apartamento SET "+
                    "propiedad=?, arriendo=?, estado=?, descripcion=? "+
                    "WHERE idApt=? ";//8  
        try{
            ps = con.prepareStatement(sql);

            ps.setBoolean(1, apt.isPropiedad());
            ps.setDouble(2, apt.getArriendo());
            ps.setString(3, apt.getEstado());
            ps.setString(4, apt.getDescripcion());
            
            ps.setInt(5, apt.getId());
            
            ps.execute();
            con.commit();
            ps.close();
            con.close();
            
            return true;
            
        }catch(SQLException e){
            System.err.println("Error al incertar>>>  "+e);
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println("Erros al intentar cerrar>>>"+ e);
            }
        }
    }
    
    //CONSULTAR  
    public Apartamento consultar(int id) throws SQLException{
        
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        
        String sql ="SELECT * FROM apartamento WHERE idApt="+id;        
        try{
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            if (resultSet.next()) {
                Apartamento apt = new Apartamento();
            
                apt.setId(resultSet.getInt(1));
                apt.setPiso(resultSet.getInt(2));
                apt.setNumero(resultSet.getInt(3));
                apt.setPropiedad(resultSet.getBoolean(4));
                apt.setArriendo(resultSet.getDouble(5));
                apt.setEstado(resultSet.getString(6));
                apt.setDescripcion(resultSet.getString(7));
                
                return apt;
            }
            
            //System.out.println("RETURN");
            return null;
            
        }catch(SQLException e){
            System.err.println("Error al incertar>>>  "+e);
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

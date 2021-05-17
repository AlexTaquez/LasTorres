package com.pakages.dao;


import com.pakages.entities.Evento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO extends Conexion {
    //REGISTRAR
    public boolean registrar(Evento even) throws SQLException{
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        String sql ="INSERT INTO evento "+
                    "(titulo, descripcion, detalles, lugar, tipo, inicio, finalizacion, fotos, estado, residente_fk)"+
                    " VALUES(?,?,?,?,?,?,?,?,?,?)";//10
        
        Date inicio = new Date(even.getInicio().getDay(), even.getInicio().getMonth(), even.getInicio().getYear());
        inicio.setHours(even.getInicio().getHours());
        inicio.setMinutes(even.getInicio().getMinutes());
        
        Date fin = new Date(even.getFin().getDay(), even.getFin().getMonth(), even.getFin().getYear());
        fin.setHours(even.getFin().getHours());
        fin.setMinutes(even.getFin().getMinutes());
        
        try{
            ps = con.prepareStatement(sql);
            
            ps.setString(1, even.getTitulo());
            ps.setString(2, even.getDescripcion());
            ps.setString(3, even.getDetalles());
            ps.setString(4, even.getLugar());
            ps.setString(5, even.getTipo());
            ps.setDate(6, inicio);
            ps.setDate(7, fin);
            ps.setString(8, even.getFoto());
            ps.setString(9, even.getEstado());
            ps.setInt(10, even.getId());
            
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
    
    //LISTAR
    public List<Evento> lista() throws SQLException{
       List<Evento> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT * FROM evento" +
                    " WHERE estado='V'";
        try {
            ps = con.prepareStatement(sql);
       ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Evento even = new Evento();
            
            even.setId(resultSet.getInt(1));
            even.setTitulo(resultSet.getString(2));
            even.setDescripcion(resultSet.getString(3));
            even.setDetalles(resultSet.getString(4));
            even.setLugar(resultSet.getString(5));
            even.setTipo(resultSet.getString(6)); 
            even.setInicio(resultSet.getDate(7));
            even.setFin(resultSet.getDate(8));
            even.setFoto(resultSet.getString(9));
            even.setEstado(resultSet.getString(10));
            even.setResidente(resultSet.getInt(11));
            
            lista.add(even);
        }
       
        return lista;
        
        } catch(SQLException e){
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
    
    //LISTAR POR ID
    public List<Evento> listaById(int id) throws SQLException{
       List<Evento> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT * FROM evento" +
                    " WHERE estado='V' and residente_fk="+id;
        try {
            ps = con.prepareStatement(sql);
       ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Evento even = new Evento();
            
            even.setId(resultSet.getInt(1));
            even.setTitulo(resultSet.getString(2));
            even.setDescripcion(resultSet.getString(3));
            even.setDetalles(resultSet.getString(4));
            even.setLugar(resultSet.getString(5));
            even.setTipo(resultSet.getString(6)); 
            even.setInicio(resultSet.getDate(7));
            even.setFin(resultSet.getDate(8));
            even.setFoto(resultSet.getString(9));
            even.setEstado(resultSet.getString(10));
            even.setResidente(resultSet.getInt(11));
            
            lista.add(even);
        }
       
        return lista;
        
        } catch(SQLException e){
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

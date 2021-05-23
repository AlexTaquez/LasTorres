package com.pakages.dao;

import com.pakages.entities.Evento;
import java.sql.Connection;
//import java.sql.Date;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
                    " VALUES(?,?,?,?,?,?,?,?,?,?)";//10}
        
        String fin = null;
        String inicio = null;
        try{
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            if(even.getFin()!=null){
                fin = formato.format(even.getFin());
            }
            
            inicio = formato.format(even.getInicio());

            
            System.out.println("FECHA DESDE DAO>>>"+ inicio);
            
            ps = con.prepareStatement(sql);
            
            ps.setString(1, even.getTitulo());
            ps.setString(2, even.getDescripcion());
            ps.setString(3, even.getDetalles());
            ps.setString(4, even.getLugar());
            ps.setString(5, even.getTipo());
            ps.setString(6, inicio);
            ps.setString(7, fin);
            ps.setString(8, even.getFoto());
            ps.setString(9, even.getEstado());            
            ps.setInt(10, even.getResidente());
            
            ps.execute();
            con.commit();
            ps.close();
            con.close();
            System.out.println("RETURN EVENTO REGISTRADO");
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
    
    //LISTAR EVENTOS DE USUARIOS
    public List<Evento> lista() throws SQLException{
       List<Evento> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT * FROM evento" +
                    " WHERE estado='V' AND residente_fk!=5";
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
    
    
    //LISTAR POR ID NULL (ADMIN)
    public List<Evento> listaByIdNull() throws SQLException, ParseException{
       List<Evento> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT * FROM evento" +
                    " WHERE residente_fk=5";
        try {
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
            
            System.out.println("DESDE DAO>>F1>>>>"+resultSet.getDate(7));
            
            Evento even = new Evento();
            
            even.setId(resultSet.getInt(1));
            even.setTitulo(resultSet.getString(2));
            even.setDescripcion(resultSet.getString(3));
            even.setDetalles(resultSet.getString(4));
            even.setLugar(resultSet.getString(5));
            even.setTipo(resultSet.getString(6)); 
            even.setInicio(resultSet.getDate(7));//FECHA
            even.setFin(resultSet.getDate(8));
            even.setFoto(resultSet.getString(9));
            even.setEstado(resultSet.getString(10));
            even.setResidente(resultSet.getInt(11));
            
            lista.add(even);
        }
        System.out.println("RETURN LISTA DESDE DAO>>>");
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
    
    
    public List<Evento> listaVigentes() throws SQLException{
       List<Evento> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT * FROM evento" +
                    " WHERE estado='V' ";
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
    
    public Evento consultar(int id) throws SQLException{
        
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        
        String sql ="SELECT * FROM evento WHERE idEvento="+id;        
        try{
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            if (resultSet.next()) {
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
                return even;
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
    
    
    private void cambiaEstado(){
    
    
    }
}

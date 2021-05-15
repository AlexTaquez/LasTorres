package com.pakages.dao;

import com.pakages.entities.Habitante;
import com.pakages.entities.Residente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;
import java.util.List;

public class ResidenteDAO extends Conexion{
    //REGISTRAR
    public boolean registrar(Residente residente) throws SQLException{
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        String sql ="INSERT INTO residente"+
                    " (numero, tipoId, nombres, apellidos, usuario, contato, activo, titular)"+
                    " VALUES(?,?,?,?,?,?,?,?)";//8  
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, residente.getNumero());
            ps.setString(2, residente.getTipoId());
            ps.setString(3, residente.getNombres());
            ps.setString(4, residente.getApellidos());
            ps.setString(5, residente.getUsuario());
            ps.setString(6, residente.getContacto());
            ps.setBoolean(7, residente.isActivo());
            
            ps.setInt(8, residente.getTitular());
            
            
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
    
    //VINCULAR CON APARTAMENTO
    public boolean vincular(Habitante residente) throws SQLException{
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        String sql ="INSERT INTO residente"+
                    "(reside_fk, apt_fk, fechaRegistro, fechaSalida)"+
                    " VALUES(?,?,?,?)";//4
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, residente.getIdResidente());
            ps.setInt(2, residente.getIdApt());
            ps.setDate(3, (Date) residente.getInicio());
            ps.setDate(4, (Date) residente.getFin());
            
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
    public List<Residente> lista(int idTorre) throws SQLException{
       List<Residente> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT DISTINCT RD.idResidente, RD.numero, RD.tipoId, RD.nombres, RD.apellidos, RD.usuario, RD.contato, RD.titular" +
                    " FROM reside_apt RA" +
                    " JOIN residente RD ON RA.reside_fk=RD.idResidente" +
                    " JOIN apartamento AP ON RA.apt_fk=AP.idApt" +
                    " WHERE RD.activo=true AND  AP.idTorre="+idTorre;
        try {
            ps = con.prepareStatement(sql);
       ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Residente res = new Residente();
            
            res.setId(resultSet.getInt(1));
            res.setNumero(resultSet.getString(2));
            res.setTipoId(resultSet.getString(3));
            res.setNombres(resultSet.getString(4));
            res.setApellidos(resultSet.getString(5));
            res.setUsuario(resultSet.getString(6)); 
            res.setContacto(resultSet.getString(7));
            res.setTitular(resultSet.getInt(8));
            
            lista.add(res);
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
    //LISTA INACTIVOS
    public List<Residente> listaInactivos() throws SQLException{
       List<Residente> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT * FROM residente WHERE activo=false";
        try {
            ps = con.prepareStatement(sql);
       ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Residente res = new Residente();
            
            res.setId(resultSet.getInt(1));
            res.setNumero(resultSet.getString(2));
            res.setTipoId(resultSet.getString(3));
            res.setNombres(resultSet.getString(4));
            res.setApellidos(resultSet.getString(5));
            res.setUsuario(resultSet.getString(6)); 
            res.setContacto(resultSet.getString(7));
            res.setTitular(resultSet.getInt(8));
            
            lista.add(res);
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
    
    //LISTA TITULARES
    public List<Residente> listaTitulares(int idTorre) throws SQLException{
       List<Residente> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT DISTINCT RD.idResidente, RD.numero, RD.tipoId, RD.nombres, RD.apellidos, RD.usuario, RD.contato, RD.titular" +
                    " FROM reside_apt RA" +
                    " JOIN residente RD ON RA.reside_fk=RD.idResidente" +
                    " JOIN apartamento AP ON RA.apt_fk=AP.idApt" +
                    " WHERE RD.activo=true AND RD.titular=null AND AP.idTorre="+idTorre;
        try {
            ps = con.prepareStatement(sql);
       ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Residente res = new Residente();
            
            res.setId(resultSet.getInt(1));
            res.setNumero(resultSet.getString(2));
            res.setTipoId(resultSet.getString(3));
            res.setNombres(resultSet.getString(4));
            res.setApellidos(resultSet.getString(5));
            res.setUsuario(resultSet.getString(6)); 
            res.setContacto(resultSet.getString(7));
            res.setTitular(resultSet.getInt(8));
            
            lista.add(res);
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
    //CONSULTAR POR NUMERO DE DOCUMENTO
    public int consultarId(String id) throws SQLException{
        
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        
        String sql ="SELECT idResidente FROM residente WHERE numero="+id;        
        try{
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            if (resultSet.next()) {
                Residente res = new Residente();
                
                res.setId(resultSet.getInt(1));
                
                return res.getId();
            }
            
            //System.out.println("RETURN");
            return 0;
            
        }catch(SQLException e){
            System.err.println("Error al incertar>>>  "+e);
            return 0;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.err.println("Erros al intentar cerrar>>>"+ e);
            }
        }
    }
    
    //CONSULTAR POR NUMERO DE DOCUMENTO
    public Residente consultarUser(String user) throws SQLException{
        
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        
        String sql ="SELECT * FROM residente WHERE usuario='"+user+"'"; 
        try{
            ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);
            if (resultSet.next()) {
                Residente res = new Residente();
                
                res.setId(resultSet.getInt(1));
                res.setNumero(resultSet.getString(2));
                res.setTipoId(resultSet.getString(3));
                res.setNombres(resultSet.getString(4));
                res.setApellidos(resultSet.getString(5));
                res.setUsuario(resultSet.getString(6));
                res.setContacto(resultSet.getString(7));
                res.setActivo(resultSet.getBoolean(8));
                res.setTitular(resultSet.getInt(9));
                
                return res;
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
    
    //ACTUALIZAR
    public boolean actualizar(Residente res) throws SQLException{
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        String sql ="UPDATE residente SET "+
                    "numero=?, tipoId=?, nombres=?, apellidos=?, usuario=?, contacto=?, activo=?, titular=? "+
                    "WHERE idResidente=? ";//9  
        try{
            ps = con.prepareStatement(sql);

            ps.setString(1, res.getNumero());
            ps.setString(2, res.getTipoId());
            ps.setString(3, res.getNombres());
            ps.setString(4, res.getApellidos());
            ps.setString(5, res.getUsuario());
            ps.setString(6, res.getContacto());
            ps.setBoolean(7, res.isActivo());
            ps.setInt(8, res.getTitular());
            
            ps.setInt(9, res.getId());
            
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
}

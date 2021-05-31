package com.pakages.dao;

import static com.pakages.dao.Conexion.getConnection;
import com.pakages.entities.Comentario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ComentarioDAO extends Conexion{
    
    //LISTA DE COMETARIOS PUBLICOS
    public List<Comentario> listaPublicComent(int idEvent) throws SQLException{
       List<Comentario> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT C.id, C.fecha, C.mensaje, C.privado, C.emisor_fk, C.motivo_fk, C.visto, R.nombres, R.apellidos" +
                    " FROM comentario C JOIN residente R ON C.emisor_fk=R.idResidente"+
                    " WHERE privado=0 AND motivo_fk="+idEvent;//7 columnas
       ps = con.prepareStatement(sql);
       ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Comentario com = new Comentario();
            
            com.setId(resultSet.getInt(1));
            com.setFecha(resultSet.getString(2));
            com.setMensaje(resultSet.getString(3));
            com.setPrivado(resultSet.getBoolean(4));
            com.setEmisor(resultSet.getInt(5));
            com.setMotivo(resultSet.getInt(6));
            com.setVisto(resultSet.getBoolean(7));
            com.setResidente(resultSet.getString(8)+" "+resultSet.getString(9));
            
            lista.add(com);
        }
        
        con.commit();
        ps.close();
        con.close();
        return lista;
    }
    
    //LISTA LOS COMETARIOS PRIVADOS
    public List<Comentario> listaPrivateComent(int idEvent) throws SQLException{
       List<Comentario> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT C.id, C.fecha, C.mensaje, C.privado, C.emisor_fk, C.motivo_fk, C.visto, R.nombres, R.apellidos" +
                    " FROM comentario C JOIN residente R ON C.id=R.idResidente"+
                    " WHERE privado=1 AND motivo_fk="+idEvent;//7 columnas
       ps = con.prepareStatement(sql);
       ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Comentario com = new Comentario();
            
            com.setId(resultSet.getInt(1));
            com.setFecha(resultSet.getString(2));
            com.setMensaje(resultSet.getString(3));
            com.setPrivado(resultSet.getBoolean(4));
            com.setEmisor(resultSet.getInt(5));
            com.setMotivo(resultSet.getInt(6));
            com.setVisto(resultSet.getBoolean(7));
            com.setResidente(resultSet.getString(8)+" "+resultSet.getString(9));
            
            lista.add(com);
        }
        con.commit();
        ps.close();
        con.close();
        return lista;
    }
    
    //LISTA LOS COMETARIOS PRIVADOS
    public List<Comentario> listaMyPrivateComent(int idEvent, int idUser) throws SQLException{
       List<Comentario> lista = new ArrayList<>();
       
       PreparedStatement ps;
       Connection con;       
       con = getConnection();
       con.setAutoCommit(false);
       
       String sql = "SELECT C.id, C.fecha, C.mensaje, C.privado, C.emisor_fk, C.motivo_fk, C.visto, R.nombres, R.apellidos" +
                    " FROM comentario C JOIN residente R ON C.id=R.idResidente"+
                    " WHERE privado=1 AND motivo_fk="+idEvent+" AND emisor_fk="+idUser;//7 columnas
       ps = con.prepareStatement(sql);
       ResultSet resultSet = ps.executeQuery(sql);
       
        while (resultSet.next()) {
                        
            Comentario com = new Comentario();
            
            com.setId(resultSet.getInt(1));
            com.setFecha(resultSet.getString(2));
            com.setMensaje(resultSet.getString(3));
            com.setPrivado(resultSet.getBoolean(4));
            com.setEmisor(resultSet.getInt(5));
            com.setMotivo(resultSet.getInt(6));
            com.setVisto(resultSet.getBoolean(7));
            com.setResidente(resultSet.getString(8)+" "+resultSet.getString(9));
            
            lista.add(com);
        }
       
        con.commit();
        ps.close();
        con.close();
        return lista;
    }
    
    //COMENTAR
    public boolean registrar(Comentario com) throws SQLException{
        PreparedStatement ps;
        Connection con;
        con = getConnection();
        con.setAutoCommit(false);
        String sql ="INSERT INTO comentario"+
                    "(fecha, mensaje, privado, emisor_fk, motivo_fk, visto)"+
                    " VALUES(?,?,?,?,?,?)";//6
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, com.getFecha());
            ps.setString(2, com.getMensaje());
            ps.setBoolean(3, com.isPrivado());
            ps.setInt(4, com.getEmisor());
            ps.setInt(5, com.getMotivo());
            ps.setBoolean(6, com.isVisto());
            
            ps.execute();
            con.commit();
            ps.close();
            con.close();
            //System.out.println("RETURN");
            return true;
            
        }catch(SQLException e){
            System.err.println("Error al COMETAR>>>  "+e);
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

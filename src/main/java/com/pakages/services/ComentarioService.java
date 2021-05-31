package com.pakages.services;

import com.pakages.dao.ComentarioDAO;
import com.pakages.entities.Comentario;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST}, allowCredentials = "*" )
@Path("/coment")
public class ComentarioService {
    
    @GET//COMENTARIOS PUBLICOS
    @Path("/public/{event}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Comentario> getComent(@PathParam("event") int id) throws SQLException{
        ComentarioDAO dao = new ComentarioDAO();
        List<Comentario> lista = dao.listaPublicComent(id);
        
        System.out.println("API COMENT GET PUBLIC>>>" + id);
        
        return lista;
    }
    
    @GET//COMENTARIOS PRIVADOS QUIEN CREO EL EVENTO
    @Path("/private/{event}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Comentario> getPrivate(@PathParam("event") int id) throws SQLException{
        ComentarioDAO dao = new ComentarioDAO();
        List<Comentario> lista = dao.listaPrivateComent(id);
        
        System.out.println("API COMENT GET PRIVATE>>>");
        
        return lista;
    }
        
    @POST// COMENTAR
    @Path("/set")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public boolean setEvent(Comentario com) throws SQLException{
        ComentarioDAO dao = new ComentarioDAO();
        System.out.println("POST COMENT "+com.getMensaje());
        if(dao.registrar(com)){
            System.out.println("SERVICE COMENT TRUE ");
            return true;
        }else{return false;}        
    }
}

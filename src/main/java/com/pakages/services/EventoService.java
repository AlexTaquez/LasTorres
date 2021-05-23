/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pakages.services;

import com.pakages.dao.EventoDAO;
import com.pakages.entities.Evento;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8100
@RestController
@CrossOrigin(origins="*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST} )
@Path("/even")
public class EventoService {
   
    @GET//EVENTOS VIGENTES POR ID DE RESIDENTE
    @Path("/{user}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Evento> getMyEvent(@PathParam("user") int user) throws SQLException{
        EventoDAO dao = new EventoDAO();
        List<Evento> lista = dao.listaById(user);
        
        System.out.println("API EVENT GET user>>>");
        
        return lista;
    }
    
    @GET//EVENTOS VIGENTES
    @GetMapping("/get")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Evento> getEvent() throws SQLException{
        EventoDAO dao = new EventoDAO();
        List<Evento> lista;
        lista = dao.listaVigentes();
        
        System.out.println("API EVENT GET>>>");
        
        return lista;
    }
    
    
    
    @POST
    @Path("/set")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public boolean setEvent(Evento e) throws SQLException{
        EventoDAO dao = new EventoDAO();
        if(dao.registrar(e)){
            System.out.println("API SET EVENT " + e.getFoto());
            return true;
        }else{return false;}        
    }
}

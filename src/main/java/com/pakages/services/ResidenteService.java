package com.pakages.services;


import com.pakages.dao.ResidenteDAO;
import com.pakages.entities.Residente;
import java.sql.SQLException;
//import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*", methods= {RequestMethod.GET})
@Path("/res")
public class ResidenteService {
    
    @GET//OBTENER USUARIO CON CUENTA DE GMAIL
    @Path("/{user}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Residente getUser(@PathParam("user") String user) throws SQLException{//int torre
        user +="@gmail.com";
        System.out.println("API USER>> " +user);
        ResidenteDAO res = new ResidenteDAO();
        Residente residente = res.consultarUser(user);
        return residente;
    }
    
    
    @GET
    @Path("/g/{user}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Residente getU(@PathParam("user") String user) throws SQLException{//int torre
        ResidenteDAO res = new ResidenteDAO();
        Residente residente = res.consultarUser(user);
        return residente;
    }
    
}
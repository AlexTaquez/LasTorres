package com.pakages.services;


import com.pakages.dao.ResidenteDAO;
import com.pakages.entities.Residente;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/res")
public class ResidenteService {
    
    @GET
    @Path("/get/{user}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Residente getUser(@PathParam("user") String user) throws SQLException{//int torre
        ResidenteDAO res = new ResidenteDAO();
        Residente residente = res.consultarUser(user);
        return residente;
    }
    
}
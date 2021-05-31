package com.pakages.services;

import com.pakages.dao.ConsultasDAO;
import com.pakages.entities.Deudor;
import java.sql.SQLException;
import java.util.List;
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
@CrossOrigin(origins="*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST}, allowCredentials = "*" )
@Path("/deudores")
public class DeudoresService {
    
    @GET//LISTA DE DEUDORES
    @Path("/list")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Deudor> getComent() throws SQLException{
        ConsultasDAO dao = new ConsultasDAO();
        List<Deudor> lista = dao.listaDeudores();
        
        System.out.println("API DEUDORES LIST>>>");
        
        return lista;
    }
}

package com.pakages.services;

import com.pakages.dao.ApartamentoDAO;
import com.pakages.entities.Apartamento;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Usuario
 */

@Path("/form")
public class FormService {
    
    @GET
    @Path("/apt-disp/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public List<Apartamento> getLista(@PathParam("id") int id) throws SQLException{//int torre
        ApartamentoDAO apt = new ApartamentoDAO();
        List<Apartamento> lista = apt.listaAptsDisp(id);
        return lista;
    }
    
}

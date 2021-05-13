package com.pakages.servlet;

import com.pakages.dao.ApartamentoDAO;
import com.pakages.dao.ResidenteDAO;
import com.pakages.entities.Apartamento;
import com.pakages.entities.Residente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "residente", urlPatterns = {"/residente"})
public class ResidenteServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //residente?torre=1
        String option = request.getParameter("torre");        
        String id = request.getParameter("id");
        
        int torre = 0;
        ResidenteDAO dao = new ResidenteDAO();
        //List<Residente> lista = null;
        try {
            
            if(option==null && id==null){
                //CREAR
                List<Residente> lista1, lista2, lista3, lista4 = null;
                lista1 = dao.listaTitulares(4);
                lista2 = dao.listaTitulares(14);
                lista3 = dao.listaTitulares(24);
                lista4 = dao.listaTitulares(34);
                
                request.setAttribute("lista", lista1);
                request.setAttribute("lista", lista2);
                request.setAttribute("lista", lista3);                
                request.setAttribute("lista", lista4);
                
                request.getRequestDispatcher("/pages/residentes/crear.jsp").forward(request, response);
                
            }else if(option!=null){
                //LISTA POR TORRES
                List<Residente> lista = null;
                switch (option) 
                {
                    case "1":  torre = 4; break;
                    case "2":  torre = 14;break;
                    case "3":  torre = 24;break;
                    case "4":  torre = 34;break;
                    default: torre = 0; break;
                }

                if(torre==0){
                    lista = dao.listaInactivos();
                    option = "INACTIVOS";
                }else{
                    lista = dao.lista(torre);
                    option = "TORRE "+option;
                }
                request.setAttribute("torre", option);
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("/pages/residentes/residentes.jsp").forward(request, response);
                
            }else if(id!=null){
                //CONSULTAR
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ResidenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       Residente res = new Residente();
        
        res.setNumero(request.getParameter("id"));
        res.setTipoId(request.getParameter("tipo"));
        res.setNombres(request.getParameter("nombres"));
        res.setApellidos(request.getParameter("apellidos"));
        res.setUsuario(request.getParameter("usuario"));
        res.setContacto(request.getParameter("contacto"));
        res.setActivo(true);
        res.setTitular(0);
        
        ResidenteDAO dao = new ResidenteDAO();
        
        try {
            List<Residente> lista = null;
            dao.registrar(res);
            lista = dao.lista(4);
            request.setAttribute("lista", lista);
            request.setAttribute("torre", "TORRE 1");
            request.getRequestDispatcher("/pages/residentes/residentes.jsp").forward(request, response);
                    
        } catch (SQLException ex) {
            Logger.getLogger(ResidenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.getRequestDispatcher("/Admin/residente?torre=1").forward(request, response);;
    }


}

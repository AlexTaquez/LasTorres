package com.pakages.servlet;

import com.pakages.dao.ApartamentoDAO;
import com.pakages.dao.ObtenerFecha;
import com.pakages.dao.ResidenteDAO;
import com.pakages.entities.Apartamento;
import com.pakages.entities.Habitante;
import com.pakages.entities.Residente;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat; 
import java.util.Date;
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
                ObtenerFecha objFecha=new ObtenerFecha();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                String fecha = formato.format(objFecha.getNTPDate());

                request.setAttribute("fecha", fecha);

                request.getRequestDispatcher("/pages/residentes/crear.jsp").forward(request, response);
                
            }else if(option!=null){
                //LISTA POR TORRES
                List<Residente> lista = null;
                switch (option) 
                {
                    case "1":  torre = 35; break;
                    case "2":  torre = 36;break;
                    case "3":  torre = 37;break;
                    case "4":  torre = 38;break;
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
                request.getRequestDispatcher("/index.html").forward(request, response);
            }         
            
        } catch (SQLException ex) {
            Logger.getLogger(ResidenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       Date fecha2 = null;
        ObtenerFecha objFecha=new ObtenerFecha();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fecha = formato.format(objFecha.getNTPDate());
        try {
            fecha2 = formato.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(ResidenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
               
       Residente res = new Residente();
       Habitante h = new Habitante();
        
        res.setNumero(request.getParameter("id"));
        res.setTipoId(request.getParameter("tipo"));
        res.setNombres(request.getParameter("nombres"));
        res.setApellidos(request.getParameter("apellidos"));
        res.setUsuario(request.getParameter("usuario"));
        res.setContacto(request.getParameter("contacto"));
        res.setActivo(true);
        res.setTitular(0);
                
        h.setIdApt(Integer. parseInt (request.getParameter("aptID")));
        h.setInicio(fecha2);
        
        ResidenteDAO dao = new ResidenteDAO();
        
        try {
            List<Residente> lista = null;
            dao.registrar(res);
            
            res.setId(dao.consultarId(res.getNumero()));
            h.setIdResidente(res.getId());
            
            dao.vincular(h);
            dao.estado(h.getIdApt());
            
            lista = dao.lista(4);
            request.setAttribute("lista", lista);
            request.setAttribute("torre", "TORRE 1");
            request.getRequestDispatcher("/pages/residentes/residentes.jsp").forward(request, response);
            //request.getRequestDispatcher("/Admin/residente?torre=1").forward(request, response);            
                    
        } catch (SQLException ex) {
            Logger.getLogger(ResidenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //request.getRequestDispatcher("/Admin/residente?torre=1").forward(request, response);
    }


}

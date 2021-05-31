package com.pakages.servlet;

import com.pakages.dao.ApartamentoDAO;
import com.pakages.entities.Apartamento;
import com.pakages.entities.Torre;
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
@WebServlet(name = "apt", urlPatterns = {"/apt"})
public class ApartamentoServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String option = request.getParameter("torre");
        String get = request.getParameter("get");
        int torre;
        
        ApartamentoDAO dao = new ApartamentoDAO();
        
        try {
            if(option!=null){
                //LISTA POR TORRES
                List<Apartamento> lista = null;
                System.out.println("OPCION>>>>>>"+option);//seguimiento
                switch (option) 
                {
                    case "35":  torre = 35; option="1";break;
                    case "36":  torre = 36; option="2";break;
                    case "37":  torre = 37; option="3";break;
                    case "38":  torre = 38; option="4";break;
                      default:  torre = 35; option="1";break;
                }

                lista = dao.listaApts(torre);
                option = "TORRE "+option;
                
                System.out.println("OPCION>>>>>>"+option+lista);//seguimiento
                
                request.setAttribute("torre", option);
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("/pages/apartamentos/apartamentos.jsp").forward(request, response);
                
            }else if(option==null && get==null){
                List<Torre> lista = null;
                lista = dao.listaTorres();
                option = "Lista de torres";
                request.setAttribute("torre", option);
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("/pages/apartamentos/torres.jsp").forward(request, response);
                
            }else if(get!=null){
                int idApt = Integer. parseInt(get);
                Apartamento objeto = new Apartamento();
                objeto = dao.consultar(idApt);
                
                option = "APARTAMENTO "+ objeto.getPiso() + "0" +objeto.getNumero() ;
                request.setAttribute("opcion", option);
                request.setAttribute("apartamento", objeto);
                request.getRequestDispatcher("/pages/apartamentos/editar.jsp").forward(request, response);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ApartamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            boolean propiedad=true;
            if(request.getParameter("propiedad").equals('0')){propiedad=false;}


            Apartamento apt = new Apartamento();

            apt.setId(Integer.parseInt(request.getParameter("id")));
            apt.setPropiedad(propiedad);
            apt.setEstado(request.getParameter("estado"));
            apt.setArriendo(Double.parseDouble(request.getParameter("arriendo")));
            apt.setDescripcion(request.getParameter("descripcion"));
        
        
            ApartamentoDAO dao = new ApartamentoDAO();
            String option = "Lista de Torres";
            if (dao.actualizar(apt)){                
                option = "Actualización exitosa";
            }else{
                option = "No se pudo completar la actualización";
            }
            
            
            List<Torre> lista = null;
            lista = dao.listaTorres();
            request.setAttribute("torre", option);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/pages/apartamentos/torres.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            request.getRequestDispatcher("/Admin").forward(request, response);
            Logger.getLogger(ResidenteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

package com.pakages.servlet;

import com.pakages.dao.ConsultasDAO;
import com.pakages.entities.Deudor;
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
@WebServlet(name = "deudores", urlPatterns = {"/deudores"})
public class DeudorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ConsultasDAO dao = new ConsultasDAO();
        List<Deudor> lista = null;
        try {
            lista = dao.listaDeudores();
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/pages/residentes/deudores.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(DeudorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

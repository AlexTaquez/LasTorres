package com.pakages.servlet;

import com.pakages.dao.EventoDAO;
import com.pakages.entities.Evento;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig
@WebServlet(name = "evento", urlPatterns = {"/evento"})
public class EventoServlet extends HttpServlet {
    
    EventoDAO dao = new EventoDAO();
    private static final long serialVersionUID = 1L;
    private String pathFiles = "C:\\Users\\Usuario\\Documents\\UNIVERCIDAD\\2021-1\\BASE DE DATOS\\LasTorres\\src\\main\\webapp\\resources\\img\\cliente";
    private File uploads = new File(pathFiles);
    private String[] extens = {".png",".jpg",".jpeg"};
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String tipo = request.getParameter("tipo");
        if(tipo == null){tipo="Nuevo";}        
        
        try{
            List<Evento> lista = null;
            
            if(tipo.equals("1")){
                tipo = "Administración";
                lista = dao.listaByIdNull();
                
            }else if (tipo.equals("2")){
                tipo = "Residentes";
                lista = dao.lista();
            }else{
                request.getRequestDispatcher("/pages/eventos/crear.jsp").forward(request, response);
                return;
            }
            
            
            request.setAttribute("tipo", tipo);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/pages/eventos/eventos.jsp").forward(request, response);
            
            
        } catch (SQLException ex) {
            System.out.println("ERROR DO GET>>>"+ex);
        } catch (ParseException ex) {
            Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Evento even = new Evento();
        String f1, f2 ,h2 = null;      
        
        f1= request.getParameter("inicio")+" "+request.getParameter("h1");
        f2= request.getParameter("fin");
        
        System.out.println("Titulo ñ Ñ>> " + request.getParameter("titulo").toUpperCase());                    
        
        try{//------------- GUARDAR FOTO
            String photo = "";
            Part part = request.getPart("foto");
            System.out.println(">>>>PART FOTO>>>"+part);
            
            if(isExtencion(part.getSubmittedFileName(), extens)){
                photo = saveFile(part, uploads);
                
            }else {photo = "adminEvent.jpg";}
            
            //---FECHAS
            
            if (f2!=null){
                h2 = request.getParameter("h2");
                if(h2==null){
                    h2="12:00 PM";
                }
                f2 += " "+h2;
            }
            
            even.setTitulo(request.getParameter("titulo").toUpperCase());
            even.setDescripcion(request.getParameter("descripcion"));
            even.setDetalles(request.getParameter("detalles"));
            even.setLugar(request.getParameter("lugar").toUpperCase());
            even.setTipo(request.getParameter("tipo"));
            even.setInicio(f1);
            even.setFin(f2);
            even.setFoto(photo);
            even.setEstado("V");
            even.setResidente(5);
            
            boolean next;
            next = dao.registrar(even);
            String tipo = "No se pudo guardar el evento";
            List<Evento> lista = null;
            
            if(next){
                tipo = "Evento de Administración guardado con exito";   
            }
            lista = dao.listaByIdNull();
            request.setAttribute("tipo", tipo);
            request.setAttribute("lista", lista);
            request.getRequestDispatcher("/pages/eventos/eventos.jsp").forward(request, response);
            
        } catch (SQLException ex) {

        } catch (ParseException ex) {
            Logger.getLogger(EventoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    
    private String saveFile(Part part, File pathUpload){
        String patchAbsolute = "";
        
        try{
            
            if(part==null){
                patchAbsolute = "adminEvent.jpg";
                return patchAbsolute;
            }
            
              Path path = Paths.get(part.getSubmittedFileName());
              String fileName = path.getFileName().toString();
              InputStream input = part.getInputStream();
              
              if(input!=null){
                  File file = new File(pathUpload, fileName);//--------
                  patchAbsolute = fileName;  ///file.getAbsolutePath() --RUTA ABSOLUTA
                  Files.copy(input, file.toPath());
                  System.out.println("SAVE FILE>>> "+patchAbsolute);
                  System.out.println("SAVE FILE>>> "+fileName);
              }
              
        }catch(Exception e){
            System.out.println("ERROR SAVE FILE>>>" + e);
        }
        
        return patchAbsolute;
    }
    
    private boolean isExtencion(String fileName, String[] extensions){
        
        for (String extension : extensions) {
            if(fileName.toLowerCase().endsWith(extension)){return true;}
        }        
        return false;
    }

}

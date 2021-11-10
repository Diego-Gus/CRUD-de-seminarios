package com.emergentes.controlador;

import com.emergentes.dao.SeminarioDAO;
import com.emergentes.dao.SeminarioDAOimpl;
import com.emergentes.modelo.Seminario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            SeminarioDAO dao = new SeminarioDAOimpl();
            int id;
            Seminario se = new Seminario();
            String action = (request.getParameter("accion") != null) ? request.getParameter("accion"): "listar";
            
            if(action.equals("listar")){
                List<Seminario> lista = dao.getAll();
                request.setAttribute("seminarios", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if(action.equals("nuevo")){
                request.setAttribute("seminarios", se);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            }
            if(action.equals("editar")){
                id = Integer.parseInt(request.getParameter("id"));
                se = dao.getById(id);
                request.setAttribute("seminarios", se);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            }
            if(action.equals("eliminar")){
                id = Integer.parseInt(request.getParameter("id"));
                dao.delete(id);
                response.sendRedirect("MainController");
            }                        
        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String expositor = request.getParameter("expositor");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        
        SeminarioDAO dao = new SeminarioDAOimpl();
        Seminario se = new Seminario();
        
        se.setId(id);
        se.setTitulo(titulo);
        se.setExpositor(expositor);
        se.setFecha(fecha);
        se.setHora(hora);
        se.setCupo(cupo);
        
        if(id == 0){
            try{
                dao.insert(se);
                response.sendRedirect("MainController");
            }catch (Exception e){
                System.out.print("Error " + e.getMessage());
            }
        }else{
            try{
                dao.update(se);
                response.sendRedirect("MainController");
            }catch (Exception e){
                System.out.print("Error " + e.getMessage());
            }
        }
    }
}

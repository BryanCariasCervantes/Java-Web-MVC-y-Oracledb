/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.DBConnection;
import Models.Empleado;
import Models.User;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BRAYAN
 */
public class ServletEmpleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DBConnection cn =new DBConnection();
        User u = new User("Manuel","12345"); 
        cn.login(u);
        ResultSet res = cn.consultarTodo();
        ArrayList<Empleado> empleado = new ArrayList<Empleado>();
        
        if(res == null){
            String error = "No hay Datos Guardados";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        else{
            try {
                while(res.next()){
                    empleado.add( new Empleado(res.getInt("ide_empleado"),
                                               res.getString("nombre"),
                                               res.getString("apellido"),
                                               res.getString("puesto_trabajo"),
                                               res.getString("tel_casa"),
                                               res.getString("tel_movil"),
                                               res.getString("fecha_nacimiento"),
                                               res.getString("direccion")
                                              )
                                );
                }
                
                request.getSession().setAttribute("empleado",empleado);
                request.getRequestDispatcher("empleado.jsp").forward(request, response);
                
            } catch (SQLException ex) {
                Logger.getLogger(ServletEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BRAYAN
 */
public class DBConnection {
    
    private String forName = "oracle.jdbc.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private Connection cnn;
    private Statement state;
    private ResultSet res;
    
    public  boolean login(User u){
        try {
            Class.forName(forName); // Nombre de la Conexion
            this.cnn = DriverManager.getConnection(url,u.getUser(),u.getPassword());
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    } 
    
    public int insertar (Empleado e){
        int bandera=0;
        try {
            String query = "INSERT INTO EMPLEADO (ide_empleado,nombre,apellido,"
                    + "puesto_trabajo,tel_casa,tel_movil,fecha_nacimiento,direccion)"
                    +"VALUES ("+ e.getIde_empleado() +",'"
                               + e.getNombre() +"','"
                               + e.getApellido() +"','"
                               + e.getPuesto_trabajo() +"','"
                               + e.getTel_casa() +"','"
                               + e.getTel_movil() +"','"
                               + e.getFecha_nacimiento() +"','"
                               + e.getDireccion() +"')";
            
            state = cnn.createStatement();
            
            bandera = state.executeUpdate(query);
            

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bandera;
    }
    
    public ResultSet consultarTodo(){
        
        try {
            String query = "SELECT * FROM EMPLEADO";
            
            state = cnn.createStatement();
            
            res = state.executeQuery(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
     public int update (Empleado e){
        int bandera=0;
        try {
            String query = "UPDATE EMPLEADO SET nombre='"
                               + e.getNombre() +"',apellido='"
                               + e.getApellido() +"',puesto_trabajo='"
                               + e.getPuesto_trabajo() +"',tel_casa='"
                               + e.getTel_casa() +"',tel_movil='"
                               + e.getTel_movil() +"',fecha_nacimiento='"
                               + e.getFecha_nacimiento() +"',direccion='"
                               + e.getDireccion() +"' WHERE ide_empleado='"
                               + e.getIde_empleado() +"'";
            
            state = cnn.createStatement();
            
            bandera = state.executeUpdate(query);
            

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bandera;
    }
    
    public int delete (String ide){
        int bandera=0;
        try {
            String query = "DELETE FROM EMPLEADO WHERE ide_empleado='"+ ide +"'";
            
            state = cnn.createStatement();
            
            bandera = state.executeUpdate(query);
            

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return bandera;
    } 
}

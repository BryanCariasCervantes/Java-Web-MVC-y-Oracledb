/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author BRAYAN
 */
public class Empleado {
    
    private int ide_empleado;
    private String nombre;
    private String apellido;
    private String puesto_trabajo; 
    private String tel_casa;
    private String tel_movil;
    private String fecha_nacimiento;
    private String direccion;

    public Empleado(int ide_empleado, String nombre, String apellido, String puesto_trabajo, String tel_casa, String tel_movil, String fecha_nacimiento, String direccion) {
        this.ide_empleado = ide_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.puesto_trabajo = puesto_trabajo;
        this.tel_casa = tel_casa;
        this.tel_movil = tel_movil;
        this.fecha_nacimiento = fecha_nacimiento;
        this.direccion = direccion;
    }

    
    
    public int getIde_empleado() {
        return ide_empleado;
    }

    public void setIde_empleado(int ide_empleado) {
        this.ide_empleado = ide_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPuesto_trabajo() {
        return puesto_trabajo;
    }

    public void setPuesto_trabajo(String puesto_trabajo) {
        this.puesto_trabajo = puesto_trabajo;
    }

    public String getTel_casa() {
        return tel_casa;
    }

    public void setTel_casa(String tel_casa) {
        this.tel_casa = tel_casa;
    }

    public String getTel_movil() {
        return tel_movil;
    }

    public void setTel_movil(String tel_movil) {
        this.tel_movil = tel_movil;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
}

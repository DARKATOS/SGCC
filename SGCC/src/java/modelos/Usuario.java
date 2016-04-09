/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Jorge Alejandro
 */
public class Usuario {
    private int identificador;
    private String nombre;
    private String cedula;
    private String correo;
    private String cargo;
    private String contrasena;

    public Usuario(int identificador) {
        this.identificador=identificador;
        this.nombre=null;
        this.cedula=null;
        this.correo=null;
        this.cargo=null;
        this.contrasena=null;
    }
    
    

    public Usuario(int identificador, String nombre, String cedula, String correo, String cargo, String contrasena) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.cedula = cedula;
        this.correo = correo;
        this.cargo = cargo;
        this.contrasena = contrasena;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

/**
 *
 * @author Jorge Alejandro
 */
public class EmpleadoCRUD {
    
    public LinkedList<Empleado> leerEmpleados()
    {
        Conexion conexion=new Conexion();
        LinkedList<Empleado> empleados = new LinkedList<>();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("call LEER_EMPLEADOS()"));
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                String nombre = resultado.getString("NOMBRE");
                String cedula = resultado.getString("CEDULA");
                String correo = resultado.getString("CORREO");
                String cargo = resultado.getString("CARGO");
                int salarioBasico = Integer.parseInt(resultado.getString("SALARIO_BASICO"));
                Empleado empleado = new Empleado(identificador, nombre, cedula, correo, cargo, salarioBasico, null);
                empleados.add(empleado);
            }
            conexion.desconectar();
            return empleados;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
        
    }
    
    public boolean nuevoEmpleado(String nombre, String cedula, String correo, String cargo, int salarioBasico, String contrasena)
    {
        Conexion conexion=new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call NUEVO_EMPLEADO(?,?,?,?,?,?)}"));
            conexion.getFop().registerOutParameter(1, Types.BOOLEAN);
            conexion.getFop().setString(2, nombre);
            conexion.getFop().setString(3, cedula);
            conexion.getFop().setString(4, correo);
            conexion.getFop().setString(5, cargo);
            conexion.getFop().setInt(6, salarioBasico);
            conexion.getFop().setString(7, contrasena);
            conexion.getFop().execute();
            boolean mensaje = conexion.getFop().getBoolean(1);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }
    
    public boolean modificarEmpleado(String cedula, String nombre, String correo, String cargo, int salarioBasico, String contrasena)
    {
        Conexion conexion=new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call MODIFICAR_EMPLEADO(?,?,?,?,?,?)}"));
            conexion.getFop().registerOutParameter(1, Types.BOOLEAN);
            conexion.getFop().setString(2, cedula);
            conexion.getFop().setString(3, nombre);
            conexion.getFop().setString(4, correo);
            conexion.getFop().setString(5, cargo);
            conexion.getFop().setInt(6, salarioBasico);
            conexion.getFop().setString(7, contrasena);
            conexion.getFop().execute();
            boolean mensaje = conexion.getFop().getBoolean(1);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }
    
    public boolean eliminarEmpleado(String cedula)
    {
        Conexion conexion=new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call ELIMINAR_EMPLEADO(?)}"));
            conexion.getFop().registerOutParameter(1, Types.BOOLEAN);
            conexion.getFop().setString(2, cedula);
            conexion.getFop().execute();
            boolean mensaje = conexion.getFop().getBoolean(1);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }
    
    public LinkedList<Empleado> leerCedula()
    {
        Conexion conexion=new Conexion();
        LinkedList<Empleado> empleados = new LinkedList<>();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("call LEER_CEDULAS_EMPLEADOS()"));
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                String nombre = resultado.getString("NOMBRE");
                String cedula = resultado.getString("CEDULA");
                Empleado empleado = new Empleado(identificador, nombre,cedula, null, null, -1, null);
                empleados.add(empleado);
            }
            conexion.desconectar();
            return empleados;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }
    

    public Empleado inicarSesion(String cedula, String contrasena) {
        Conexion conexion=new Conexion();
        try {
            Empleado empleado = null;
            conexion.setFop(conexion.getConexion().prepareCall("call INICIAR_SESION(?,?)")); 
            conexion.getFop().setString(1, cedula);
            conexion.getFop().setString(2, contrasena);
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                int identificador=resultado.getInt("IDENTIFICADOR");
                String nombre = resultado.getString("NOMBRE");
                String correo = resultado.getString("CORREO");
                String cargo = resultado.getString("CARGO");
                int salarioBasico=Integer.parseInt(resultado.getString("SALARIO_BASICO"));
                empleado = new Empleado(identificador, nombre, cedula, correo, cargo, salarioBasico,contrasena);
            }
            return empleado;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Empleado buscarEmpleado(String pcedula)
    {
        Conexion conexion=new Conexion();
        Empleado empleado = null;
        try {
            conexion.setFop(conexion.getConexion().prepareCall("call BUSCAR_EMPLEADO(?)"));
            conexion.getFop().setString(1, pcedula);
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                String nombre = resultado.getString("NOMBRE");
                String cedula = resultado.getString("CEDULA");
                String correo = resultado.getString("CORREO");
                String cargo = resultado.getString("CARGO");
                int salarioBasico=Integer.parseInt(resultado.getString("SALARIO_BASICO"));
                String contrasena = resultado.getString("CONTRASENA");
                empleado = new Empleado(identificador, nombre, cedula, correo, cargo, salarioBasico, contrasena);
            }
            conexion.desconectar();
            return empleado;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }
}

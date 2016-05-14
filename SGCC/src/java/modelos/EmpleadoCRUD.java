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
        LinkedList<Empleado> empleados = new LinkedList<>();
        try {
            Conexion.fop = Conexion.conexion.prepareCall("call LEER_EMPLEADOS()");
            ResultSet resultado = Conexion.fop.executeQuery();
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
            return empleados;
        } catch (SQLException ex) {
            return null;
        }
        
    }
    
    public boolean nuevoEmpleado(String nombre, String cedula, String correo, String cargo, int salarioBasico, String contrasena)
    {
        try {
            Conexion.fop = Conexion.conexion.prepareCall("{?=call NUEVO_EMPLEADO(?,?,?,?,?,?)}");
            Conexion.fop.registerOutParameter(1, Types.BOOLEAN);
            Conexion.fop.setString(2, nombre);
            Conexion.fop.setString(3, cedula);
            Conexion.fop.setString(4, correo);
            Conexion.fop.setString(5, cargo);
            Conexion.fop.setInt(6, salarioBasico);
            Conexion.fop.setString(7, contrasena);
            Conexion.fop.execute();
            boolean mensaje = Conexion.fop.getBoolean(1);
            return mensaje;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean modificarEmpleado(String cedula, String nombre, String correo, String cargo, int salarioBasico, String contrasena)
    {
        try {
            Conexion.fop = Conexion.conexion.prepareCall("{?=call MODIFICAR_GASTO(?,?,?,?,?,?)}");
            Conexion.fop.registerOutParameter(1, Types.BOOLEAN);
            Conexion.fop.setString(2, cedula);
            Conexion.fop.setString(3, nombre);
            Conexion.fop.setString(4, correo);
            Conexion.fop.setString(5, cargo);
            Conexion.fop.setInt(6, salarioBasico);
            Conexion.fop.setString(7, contrasena);
            Conexion.fop.execute();
            boolean mensaje = Conexion.fop.getBoolean(1);
            return mensaje;
        } catch (SQLException ex) {
            return false;
        }
    }

    public Empleado inicarSesion(String cedula, String contrasena) {
        try {
            Empleado empleado = null;
            Conexion.fop = Conexion.conexion.prepareCall("call INICIAR_SESION(?,?)");
            Conexion.fop.setString(1, cedula);
            Conexion.fop.setString(2, contrasena);
            ResultSet resultado = Conexion.fop.executeQuery();
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
}

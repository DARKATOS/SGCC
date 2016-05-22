/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

/**
 *
 * @author Jorge Alejandro
 */
public class LiquidacionCRUD {

    public LinkedList<Liquidacion> leerLiquidaciones() {
        Conexion conexion = new Conexion();
        LinkedList<Liquidacion> liquidaciones = new LinkedList<>();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("call LEER_LIQUIDACIONES()"));
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                Date fechab = resultado.getDate("FECHA");
                String fecha = fechab.toString();
                int comisiones = resultado.getInt("COMISIONES");
                int auxilioTransporte = resultado.getInt("AUXILIO_TRANSPORTE");
                int valorHoraExtra = resultado.getInt("VALOR_HORA_EXTRA");
                int numeroHorasExtra = resultado.getInt("NUMERO_HORAS_EXTRA");
                int totalHorasExtra = resultado.getInt("TOTAL_HORAS_EXTRA");
                double salud = resultado.getDouble("SALUD");
                double pension = resultado.getDouble("PENSION");
                double salarioNeto = resultado.getDouble("SALARIO_NETO");
                int idempleado = resultado.getInt("IDEMPLEADO");
                conexion.setFop(conexion.getConexion().prepareCall("call LEER_EMPLEADO_LIQUIDACION(?)"));
                conexion.getFop().setInt(1, idempleado);
                ResultSet resultado2 = conexion.getFop().executeQuery();
                Empleado empleado = null;
                while (resultado2.next()) {
                    empleado = new Empleado(resultado2.getString("NOMBRE"), resultado2.getString("CEDULA"));
                }
                Liquidacion liquidacion = new Liquidacion(identificador, fecha, comisiones, auxilioTransporte, valorHoraExtra, numeroHorasExtra, totalHorasExtra, salud, pension, salarioNeto, empleado);
                liquidaciones.add(liquidacion);
            }
            conexion.desconectar();
            return liquidaciones;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }

    public boolean nuevaLiquidacion(String fechap, int salarioBasico, int comisiones, int auxilioTransporte, int valorHoraExtra, int numeroHorasExtra, String empleado) {
        int totalHorasExtra = valorHoraExtra * numeroHorasExtra;
        double salud = (salarioBasico + comisiones + totalHorasExtra) * 0.04;
        double pension = (salarioBasico + comisiones + totalHorasExtra) * 0.04;
        double salarioNeto = salarioBasico + comisiones + totalHorasExtra - salud - pension;
        Conexion conexion = new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call NUEVA_LIQUIDACION(?,?,?,?,?,?,?,?,?,?)}"));
            conexion.getFop().registerOutParameter(1, Types.BOOLEAN);
            Date fecha = Date.valueOf(fechap);
            conexion.getFop().setDate(2, fecha);
            conexion.getFop().setInt(3, comisiones);
            conexion.getFop().setInt(4, auxilioTransporte);
            conexion.getFop().setInt(5, valorHoraExtra);
            conexion.getFop().setInt(6, numeroHorasExtra);
            conexion.getFop().setInt(7, totalHorasExtra);
            conexion.getFop().setDouble(8, salud);
            conexion.getFop().setDouble(9, pension);
            conexion.getFop().setDouble(10, salarioNeto);
            conexion.getFop().setString(11, empleado);
            conexion.getFop().execute();
            boolean mensaje = conexion.getFop().getBoolean(1);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }

    public boolean modificarLiquidacion(int identificador, String fechap, int salarioBasico, int comisiones, int valorHoraExtra, int numeroHorasExtra) {
        int auxilioTransporte = 77700;
        int totalHorasExtra = valorHoraExtra * numeroHorasExtra;
        double salud = (salarioBasico + comisiones + totalHorasExtra) * 0.04;
        double pension = (salarioBasico + comisiones + totalHorasExtra) * 0.04;
        double salarioNeto = salarioBasico + comisiones + auxilioTransporte + totalHorasExtra - salud - pension;
        Conexion conexion = new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call MODIFICAR_LIQUIDACION(?,?,?,?,?,?,?,?,?)}"));
            conexion.getFop().registerOutParameter(1, Types.BOOLEAN);
            conexion.getFop().setInt(2, identificador);
            Date fecha = Date.valueOf(fechap);
            conexion.getFop().setDate(3, fecha);
            conexion.getFop().setInt(4, comisiones);
            conexion.getFop().setInt(5, valorHoraExtra);
            conexion.getFop().setInt(6, numeroHorasExtra);
            conexion.getFop().setInt(7, totalHorasExtra);
            conexion.getFop().setDouble(8, salud);
            conexion.getFop().setDouble(9, pension);
            conexion.getFop().setDouble(10, salarioNeto);
            conexion.getFop().execute();
            boolean mensaje = conexion.getFop().getBoolean(1);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }

    public boolean eliminarLiquidacion(int identificador) {
        Conexion conexion = new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call ELIMINAR_LIQUIDACION(?)}"));
            conexion.getFop().registerOutParameter(1, Types.BOOLEAN);
            conexion.getFop().setInt(2, identificador);
            conexion.getFop().execute();
            boolean mensaje = conexion.getFop().getBoolean(1);
            System.out.println(mensaje);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return false;
        }
    }

    public LinkedList<Liquidacion> leerIdentificadoresLiquidaciones() {
        Conexion conexion = new Conexion();
        LinkedList<Liquidacion> liquidaciones = new LinkedList<>();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("call LEER_IDENTIFICADORES_LIQUIDACIONES()"));
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                Date fechab = resultado.getDate("FECHA");
                String fecha = fechab.toString();
                int idempleado = resultado.getInt("IDEMPLEADO");
                conexion.setFop(conexion.getConexion().prepareCall("call LEER_EMPLEADO_LIQUIDACION(?)"));
                conexion.getFop().setInt(1, idempleado);
                ResultSet resultado2 = conexion.getFop().executeQuery();
                Empleado empleado = null;
                while (resultado2.next()) {
                    empleado = new Empleado(resultado2.getString("NOMBRE"), resultado2.getString("CEDULA"));
                }
                Liquidacion liquidacion = new Liquidacion(identificador, fecha, empleado);
                liquidaciones.add(liquidacion);
            }
            conexion.desconectar();
            return liquidaciones;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }

    public Liquidacion buscarLiquidacion(int identificadorp) {
        Conexion conexion = new Conexion();
        Liquidacion liquidacion = null;
        try {
            conexion.setFop(conexion.getConexion().prepareCall("call BUSCAR_LIQUIDACION(?)"));
            conexion.getFop().setInt(1, identificadorp);
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                Date fechab = resultado.getDate("FECHA");
                String fecha = fechab.toString();
                int comisiones = resultado.getInt("COMISIONES");
                int auxilioTransporte = resultado.getInt("AUXILIO_TRANSPORTE");
                int valorHoraExtra = resultado.getInt("VALOR_HORA_EXTRA");
                int numeroHorasExtra = resultado.getInt("NUMERO_HORAS_EXTRA");
                int totalHorasExtra = resultado.getInt("TOTAL_HORAS_EXTRA");
                double salud = resultado.getDouble("SALUD");
                double pension = resultado.getDouble("PENSION");
                double salarioNeto = resultado.getDouble("SALARIO_NETO");
                int idempleado = resultado.getInt("IDEMPLEADO");
                conexion.setFop(conexion.getConexion().prepareCall("call LEER_EMPLEADO_LIQUIDACION(?)"));
                conexion.getFop().setInt(1, idempleado);
                ResultSet resultado2 = conexion.getFop().executeQuery();
                Empleado empleado = null;
                while (resultado2.next()) {
                    empleado = new Empleado(resultado2.getString("NOMBRE"), resultado2.getString("CEDULA"), resultado2.getInt("SALARIO_BASICO"));
                }
                liquidacion = new Liquidacion(identificador, fecha, comisiones, auxilioTransporte, valorHoraExtra, numeroHorasExtra, totalHorasExtra, salud, pension, salarioNeto, empleado);
            }
            conexion.desconectar();
            return liquidacion;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }

    public LinkedList<Empleado> leerEmpleadosLiquidacion() {
        Conexion conexion = new Conexion();
        LinkedList<Empleado> empleados = new LinkedList<>();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("call LEER_EMPLEADOS_LIQUIDACION()"));
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                String nombre = resultado.getString("NOMBRE");
                String cedula = resultado.getString("CEDULA");
                Empleado empleado = new Empleado(nombre, cedula);
                empleados.add(empleado);
            }
            conexion.desconectar();
            return empleados;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }

    public int leerSalarioBasicoCedula(String cedulap) {
        Conexion conexion = new Conexion();
        int salarioBasico = -1;
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call LEER_SALARIO_BASICO_CEDULA(?)}"));
            conexion.getFop().registerOutParameter(1, Types.INTEGER);
            conexion.getFop().setString(2, cedulap);
            conexion.getFop().execute();
            salarioBasico = conexion.getFop().getInt(1);
            System.out.println(salarioBasico);
            conexion.desconectar();
            return salarioBasico;
        } catch (SQLException ex) {
            conexion.desconectar();
            System.out.println("Error en leer el salario basico");
            return -1;
        }
    }
}

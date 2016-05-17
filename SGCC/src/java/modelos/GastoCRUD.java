/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Blob;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

/**
 *
 * @author Jorge Alejandro
 */
public class GastoCRUD {

    public GastoCRUD() {
    }

    public LinkedList<Gasto> leerGastos() {
        Conexion conexion=new Conexion();
        LinkedList<Gasto> gastos = new LinkedList<>();
        System.out.println("Llegue aca");
        try {
            conexion.setFop(conexion.getConexion().prepareCall("call LEER_GASTOS()"));
            System.out.println("Llegue aca 2");
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                String fecha = resultado.getDate("FECHA").toString();
                String empresa = resultado.getString("EMPRESA");
                System.out.println(empresa);
                int valortotal = resultado.getInt("VALORTOTAL");
                int idconcepto = resultado.getInt("IDCONCEPTO");
                conexion.setFop(conexion.getConexion().prepareCall("{?=call NOMBRE_CONCEPTO_GASTO(?)}"));
                conexion.getFop().registerOutParameter(1, Types.VARCHAR);
                conexion.getFop().setInt(2, idconcepto);
                conexion.getFop().execute();
                String nombreconcepto = conexion.getFop().getString(1);
                Concepto concepto = new Concepto(idconcepto, nombreconcepto);

                int idfuente = resultado.getInt("IDFUENTE");
                conexion.setFop(conexion.getConexion().prepareCall("{?=call NOMBRE_FUENTE(?)}"));
                conexion.getFop().registerOutParameter(1, Types.VARCHAR);
                conexion.getFop().setInt(2, idfuente);
                conexion.getFop().execute();
                String nombrefuente = conexion.getFop().getString(1);
                Fuente fuente = new Fuente(idfuente, nombrefuente);
                Empleado empleado = new Empleado(resultado.getInt("IDEMPLEADO"));
                //LinkedList<Soporte> soportes = soportesDeIngreso(identificador);
                Gasto gasto = new Gasto(empleado, identificador, fecha, empresa, concepto, valortotal, fuente, null);
                gastos.add(gasto);
            }
            conexion.desconectar();
            return gastos;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }

    public String nuevoGasto(String fecha, String empresa, int concepto, int valortotal, int fuente, int idempleado, String idsoporte, String soporte) {
        Conexion conexion=new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call NUEVO_GASTO(?,?,?,?,?,?)}"));
            conexion.getFop().registerOutParameter(1, Types.INTEGER);
            Date sqlfecha = Date.valueOf(fecha);
            conexion.getFop().setDate(2, sqlfecha);
            conexion.getFop().setString(3, empresa);
            conexion.getFop().setInt(4, valortotal);
            conexion.getFop().setInt(5, concepto);
            conexion.getFop().setInt(6, fuente);
            conexion.getFop().setInt(7, idempleado);
            conexion.getFop().execute();
            int idgasto = conexion.getFop().getInt(1);

            conexion.setFop(conexion.getConexion().prepareCall("{?=call NUEVO_SOPORTE_GASTO(?,?,?)}")); 
            conexion.getFop().registerOutParameter(1, Types.VARCHAR);
            conexion.getFop().setInt(2, idgasto);
            conexion.getFop().setString(3, idsoporte);
            //Problemas con el soporte: Hay que convertir la ruta en archivo de imagen y luego en un blob
            Blob sqlsoporte = null;
            conexion.getFop().setBlob(4, sqlsoporte);
            conexion.getFop().execute();
            String mensaje = conexion.getFop().getString(1);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return "No se ha ingresado correctamente el gasto";
        }
    }

    public Gasto buscarGasto(int identificador) {
        Conexion conexion=new Conexion();
        try {
            Gasto gasto = null;
            conexion.setFop(conexion.getConexion().prepareCall("call BUSCAR_GASTO(?)"));
            conexion.getFop().setInt(1, identificador);
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                String fecha = resultado.getDate("FECHA").toString();
                String empresa = resultado.getString("EMPRESA");
                int idconcepto = resultado.getInt("IDCONCEPTO");
                conexion.setFop(conexion.getConexion().prepareCall("{?=call NOMBRE_CONCEPTO_GASTO(?)}"));
                conexion.getFop().registerOutParameter(1, Types.VARCHAR);
                conexion.getFop().setInt(2, idconcepto);
                conexion.getFop().execute();
                String nombreconcepto = conexion.getFop().getString(1);
                Concepto concepto = new Concepto(idconcepto, nombreconcepto);
                
                int valortotal = resultado.getInt("VALORTOTAL");
                int idfuente = resultado.getInt("IDFUENTE");
                conexion.setFop(conexion.getConexion().prepareCall("{?=call NOMBRE_FUENTE(?)}")); 
                conexion.getFop().registerOutParameter(1, Types.VARCHAR);
                conexion.getFop().setInt(2, idfuente);
                conexion.getFop().execute();
                String nombrefuente = conexion.getFop().getString(1);
                Fuente fuente = new Fuente(idfuente, nombrefuente);
                Empleado empleado = new Empleado(resultado.getInt("IDEMPLEADO"));
//                Falta obtener soportes del ingreso
//                LinkedList<Soporte> soportes=soportesDeIngreso(identificador);
                gasto = new Gasto(empleado, identificador, fecha, empresa, concepto, valortotal, fuente, null);
            }
            conexion.desconectar();
            return gasto;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }
    
    public String modificarGasto(int identificador, String fecha, String empresa, int valortotal, int idconcepto, int idfuente, int idempleado)
    {
        Conexion conexion=new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call MODIFICAR_GASTO(?,?,?,?,?,?,?)}"));
            conexion.getFop().registerOutParameter(1, Types.VARCHAR);
            conexion.getFop().setInt(2, identificador);
            Date sqldate = Date.valueOf(fecha);
            conexion.getFop().setDate(3, sqldate);
            conexion.getFop().setString(4, empresa);
            conexion.getFop().setInt(5, valortotal);
            conexion.getFop().setInt(6, idconcepto);
            conexion.getFop().setInt(7, idfuente);
            conexion.getFop().setInt(8, idempleado);
            conexion.getFop().execute();
            String mensaje = conexion.getFop().getString(1);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return "No se ha modificado correctamente el gasto";
        }
    }
    
    public String  eliminarGasto(int identificador){
        Conexion conexion=new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call ELIMINAR_GASTO(?)}"));
            conexion.getFop().registerOutParameter(1, Types.VARCHAR);
            conexion.getFop().setInt(2, identificador);
            conexion.getFop().execute();
            String mensaje = conexion.getFop().getString(1);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return "No se ha eliminado correctamente el gasto";
        }
    }
}

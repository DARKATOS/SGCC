/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Image;
import java.awt.Toolkit;
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
public class IngresoCRUD {

    public LinkedList<Ingreso> leerIngresos() {
        Conexion conexion=new Conexion();
        try {
            LinkedList<Ingreso> ingresos = new LinkedList<>();
            conexion.setFop(conexion.getConexion().prepareCall("call LEER_INGRESOS()"));
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                String fecha = resultado.getDate("FECHA").toString();
                String empresa = resultado.getString("EMPRESA");
                int idconcepto = resultado.getInt("IDCONCEPTO");
                conexion.setFop(conexion.getConexion().prepareCall("{?=call NOMBRE_CONCEPTO_INGRESO(?)}"));
                conexion.getFop().registerOutParameter(1, Types.VARCHAR);
                conexion.getFop().setInt(2, idconcepto);
                conexion.getFop().execute();
                String nombreconcepto = conexion.getFop().getString(1);
                Concepto concepto = new Concepto(idconcepto, nombreconcepto);

                int cantidad = resultado.getInt("CANTIDAD");
                int valorunitario = resultado.getInt("VALORUNITARIO");
                int valortotal = resultado.getInt("VALORTOTAL");
                int idfuente = resultado.getInt("IDFUENTE");
                conexion.setFop(conexion.getConexion().prepareCall("{?=call NOMBRE_FUENTE(?)}"));
                conexion.getFop().registerOutParameter(1, Types.VARCHAR);
                conexion.getFop().setInt(2, idfuente);
                conexion.getFop().execute();
                String nombrefuente = conexion.getFop().getString(1);
                Fuente fuente = new Fuente(idfuente, nombrefuente);
                Empleado empleado = new Empleado(resultado.getInt("IDEMPLEADO"));
                //Falta obtener soportes del ingreso
//                LinkedList<Soporte> soportes=soportesDeIngreso(identificador);

                Ingreso ingreso = new Ingreso(empleado, fecha, identificador, empresa, concepto, cantidad, valorunitario, valortotal, fuente, null);
                ingresos.add(ingreso);
            }
            conexion.desconectar();
            return ingresos;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }

    public String nuevoIngreso(String fecha, String empresa, int concepto, int valorunitario, int cantidad, int valortotal, int fuente, String idsoporte, String soporte, int idempleado) {
        Conexion conexion=new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call NUEVO_INGRESO(?,?,?,?,?,?,?,?)}"));
            conexion.getFop().registerOutParameter(1, Types.INTEGER);
            Date sqlfecha = Date.valueOf(fecha);
            conexion.getFop().setDate(2, sqlfecha);
            conexion.getFop().setString(3, empresa);
            conexion.getFop().setInt(4, cantidad);
            conexion.getFop().setInt(5, valorunitario);
            conexion.getFop().setInt(6, valortotal);
            conexion.getFop().setInt(7, concepto);
            conexion.getFop().setInt(8, fuente);
            conexion.getFop().setInt(9, idempleado);
            conexion.getFop().execute();
            int idingreso = conexion.getFop().getInt(1);

            conexion.setFop(conexion.getConexion().prepareCall("{?=call NUEVO_SOPORTE_INGRESO(?,?,?)}"));
            conexion.getFop().registerOutParameter(1, Types.VARCHAR);
            conexion.getFop().setInt(2, idingreso);
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
            return "Error en el nuevo ingreso" + ex.getMessage();
        }
    }

    public Ingreso buscarIngreso(int identificador) {
        Conexion conexion=new Conexion();
        try {
            Ingreso ingreso = null;
            conexion.setFop(conexion.getConexion().prepareCall("call BUSCAR_INGRESO(?)"));
            conexion.getFop().setInt(1, identificador);
            ResultSet resultado = conexion.getFop().executeQuery();
            while (resultado.next()) {
                String fecha = resultado.getDate("FECHA").toString();
                String empresa = resultado.getString("EMPRESA");
                int idconcepto = resultado.getInt("IDCONCEPTO");
                conexion.setFop(conexion.getConexion().prepareCall("{?=call NOMBRE_CONCEPTO_INGRESO(?)}"));
                conexion.getFop().registerOutParameter(1, Types.VARCHAR);
                conexion.getFop().setInt(2, idconcepto);
                conexion.getFop().execute();
                String nombreconcepto = conexion.getFop().getString(1);
                Concepto concepto = new Concepto(idconcepto, nombreconcepto);

                int cantidad = resultado.getInt("CANTIDAD");
                int valorunitario = resultado.getInt("VALORUNITARIO");
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
                ingreso = new Ingreso(empleado, fecha, identificador, empresa, concepto, cantidad, valorunitario, valortotal, fuente, null);
            }
            conexion.desconectar();
            return ingreso;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }

    /**
     * @see Falta la modificacion del soporte.
     * @param identificador
     * @param fecha
     * @param empresa
     * @param concepto
     * @param valorunitario
     * @param cantidad
     * @param valortotal
     * @param fuente
     * @param idsoporte
     * @param soporte
     * @param idempleado
     * @return mensaje que indica el exito de la modificacion
     */
    public String modificarIngreso(int identificador,String fecha, String empresa, int concepto, int valorunitario, int cantidad, int valortotal, int fuente, String idsoporte, String soporte, int idempleado) {
        Conexion conexion=new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call MODIFICAR_INGRESO(?,?,?,?,?,?,?,?,?)}"));
            conexion.getFop().registerOutParameter(1, Types.VARCHAR);
            conexion.getFop().setInt(2, identificador);
            Date sqldate = Date.valueOf(fecha);
            conexion.getFop().setDate(3, sqldate);
            conexion.getFop().setString(4, empresa);
            conexion.getFop().setInt(5, cantidad);
            conexion.getFop().setInt(6, valorunitario);
            conexion.getFop().setInt(7, valortotal);
            conexion.getFop().setInt(8, concepto);
            conexion.getFop().setInt(9, fuente);
            conexion.getFop().setInt(10, idempleado);
            conexion.getFop().execute();
            String mensaje = conexion.getFop().getString(1);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return "No se ha modificado correctamente el ingreso";
        }
    }

    /**
     *
     * @param identificador
     * @return mensaje indicando la eliminacion del ingreso
     */
    public String eliminarIngreso(int identificador) {
        Conexion conexion=new Conexion();
        try {
            conexion.setFop(conexion.getConexion().prepareCall("{?=call ELIMINAR_INGRESO(?)}"));
            conexion.getFop().registerOutParameter(1, Types.VARCHAR);
            conexion.getFop().setInt(2, identificador);
            conexion.getFop().execute();
            String mensaje = conexion.getFop().getString(1);
            conexion.desconectar();
            return mensaje;
        } catch (SQLException ex) {
            conexion.desconectar();
            return "No se ha eliminado correctamente el ingreso";
        }
    }

    /**
     * @see Metodo de la clase controladora que permite obtener los soportes
     * asignados a un ingreso.
     * @param idingreso identificador del ingreso.
     * @return un LinkedList<Soporte> Una lista de los soportes que tiene el
     * ingreso.
     */
//    private LinkedList<Soporte> soportesDeIngreso(int idingreso) {
//        LinkedList<Soporte> soportes = new LinkedList<>();
//        try {
//            Conexion.fop = Conexion.conexion.prepareCall("call LEER_SOPORTES_INGRESO(?)");
//            Conexion.fop.setInt(1, idingreso);
//            ResultSet resultado = Conexion.fop.executeQuery();
//            while (resultado.next()) {
//                int identificador = resultado.getInt("IDENTIFICADOR");
//                String numero = resultado.getString("NUMERO");
//                byte[] bytes=resultado.getBlob("ARCHIVO").getBytes(1, (int) resultado.getBlob("ARCHIVO").length());
//                Image archivo=Toolkit.getDefaultToolkit().createImage(bytes);

//                Soporte soporte = new Soporte(identificador, numero, null);
//                soportes.add(soporte);
//            }
//            return soportes;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
}

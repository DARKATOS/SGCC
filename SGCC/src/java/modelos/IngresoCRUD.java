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
        try {
            LinkedList<Ingreso> ingresos = new LinkedList<>();
            Conexion.fop = Conexion.conexion.prepareCall("call LEER_INGRESOS()");
            ResultSet resultado = Conexion.fop.executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                String fecha = resultado.getDate("FECHA").toString();
                String empresa = resultado.getString("EMPRESA");
                int idconcepto = resultado.getInt("IDCONCEPTO");
                Conexion.fop = Conexion.conexion.prepareCall("{?=call NOMBRE_CONCEPTO_INGRESO(?)}");
                Conexion.fop.registerOutParameter(1, Types.VARCHAR);
                Conexion.fop.setInt(2, idconcepto);
                Conexion.fop.execute();
                String nombreconcepto = Conexion.fop.getString(1);
                Concepto concepto = new Concepto(idconcepto, nombreconcepto);

                int cantidad = resultado.getInt("CANTIDAD");
                int valorunitario = resultado.getInt("VALORUNITARIO");
                int valortotal = resultado.getInt("VALORTOTAL");
                int idfuente = resultado.getInt("IDFUENTE");
                Conexion.fop = Conexion.conexion.prepareCall("{?=call NOMBRE_FUENTE(?)}");
                Conexion.fop.registerOutParameter(1, Types.VARCHAR);
                Conexion.fop.setInt(2, idfuente);
                Conexion.fop.execute();
                String nombrefuente = Conexion.fop.getString(1);
                Fuente fuente = new Fuente(idfuente, nombrefuente);
                Empleado usuario = new Empleado(resultado.getInt("IDUSUARIO"));
                //Falta obtener soportes del ingreso
//                LinkedList<Soporte> soportes=soportesDeIngreso(identificador);

                Ingreso ingreso = new Ingreso(usuario, fecha, identificador, empresa, concepto, cantidad, valorunitario, valortotal, fuente, null);
                ingresos.add(ingreso);
            }
            return ingresos;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String nuevoIngreso(String fecha, String empresa, int concepto, int valorunitario, int cantidad, int valortotal, int fuente, String idsoporte, String soporte, int usuario) {
        try {
            Conexion.fop = Conexion.conexion.prepareCall("{?=call NUEVO_INGRESO(?,?,?,?,?,?,?,?)}");
            Conexion.fop.registerOutParameter(1, Types.INTEGER);
            Date sqlfecha = Date.valueOf(fecha);
            Conexion.fop.setDate(2, sqlfecha);
            Conexion.fop.setString(3, empresa);
            Conexion.fop.setInt(4, cantidad);
            Conexion.fop.setInt(5, valorunitario);
            Conexion.fop.setInt(6, valortotal);
            Conexion.fop.setInt(7, concepto);
            Conexion.fop.setInt(8, fuente);
            Conexion.fop.setInt(9, usuario);
            Conexion.fop.execute();
            int idingreso = Conexion.fop.getInt(1);

            Conexion.fop = Conexion.conexion.prepareCall("{?=call NUEVO_SOPORTE_INGRESO(?,?,?)}");
            Conexion.fop.registerOutParameter(1, Types.VARCHAR);
            Conexion.fop.setInt(2, idingreso);
            Conexion.fop.setString(3, idsoporte);
            //Problemas con el soporte: Hay que convertir la ruta en archivo de imagen y luego en un blob
            Blob sqlsoporte = null;
            Conexion.fop.setBlob(4, sqlsoporte);
            Conexion.fop.execute();
            String mensaje = Conexion.fop.getString(1);
            return mensaje;
        } catch (SQLException ex) {
            return "Error en el nuevo ingreso" + ex.getMessage();
        }
    }

    public Ingreso buscarIngreso(int identificador) {
        try {
            Ingreso ingreso = null;
            Conexion.fop = Conexion.conexion.prepareCall("call BUSCAR_INGRESO(?)");
            Conexion.fop.setInt(1, identificador);
            ResultSet resultado = Conexion.fop.executeQuery();
            while (resultado.next()) {
                String fecha = resultado.getDate("FECHA").toString();
                String empresa = resultado.getString("EMPRESA");
                int idconcepto = resultado.getInt("IDCONCEPTO");
                Conexion.fop = Conexion.conexion.prepareCall("{?=call NOMBRE_CONCEPTO_INGRESO(?)}");
                Conexion.fop.registerOutParameter(1, Types.VARCHAR);
                Conexion.fop.setInt(2, idconcepto);
                Conexion.fop.execute();
                String nombreconcepto = Conexion.fop.getString(1);
                Concepto concepto = new Concepto(idconcepto, nombreconcepto);

                int cantidad = resultado.getInt("CANTIDAD");
                int valorunitario = resultado.getInt("VALORUNITARIO");
                int valortotal = resultado.getInt("VALORTOTAL");
                int idfuente = resultado.getInt("IDFUENTE");
                Conexion.fop = Conexion.conexion.prepareCall("{?=call NOMBRE_FUENTE(?)}");
                Conexion.fop.registerOutParameter(1, Types.VARCHAR);
                Conexion.fop.setInt(2, idfuente);
                Conexion.fop.execute();
                String nombrefuente = Conexion.fop.getString(1);
                Fuente fuente = new Fuente(idfuente, nombrefuente);
                Empleado usuario = new Empleado(resultado.getInt("IDUSUARIO"));
//                Falta obtener soportes del ingreso
//                LinkedList<Soporte> soportes=soportesDeIngreso(identificador);
                ingreso = new Ingreso(usuario, fecha, identificador, empresa, concepto, cantidad, valorunitario, valortotal, fuente, null);
            }
            return ingreso;
        } catch (SQLException ex) {
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
     * @param usuario
     * @return mensaje que indica el exito de la modificacion
     */
    public String modificarIngreso(int identificador,String fecha, String empresa, int concepto, int valorunitario, int cantidad, int valortotal, int fuente, String idsoporte, String soporte, int usuario) {
        try {
            Conexion.fop = Conexion.conexion.prepareCall("{?=call MODIFICAR_INGRESO(?,?,?,?,?,?,?,?,?)}");
            Conexion.fop.registerOutParameter(1, Types.VARCHAR);
            Conexion.fop.setInt(2, identificador);
            Date sqldate = Date.valueOf(fecha);
            Conexion.fop.setDate(3, sqldate);
            Conexion.fop.setString(4, empresa);
            Conexion.fop.setInt(5, cantidad);
            Conexion.fop.setInt(6, valorunitario);
            Conexion.fop.setInt(7, valortotal);
            Conexion.fop.setInt(8, concepto);
            Conexion.fop.setInt(9, fuente);
            Conexion.fop.setInt(10, usuario);
            Conexion.fop.execute();
            String mensaje = Conexion.fop.getString(1);
            return mensaje;
        } catch (SQLException ex) {
            return "No se ha modificado correctamente el ingreso";
        }
    }

    /**
     *
     * @param identificador
     * @return mensaje indicando la eliminacion del ingreso
     */
    public String eliminarIngreso(int identificador) {
        try {
            Conexion.fop = Conexion.conexion.prepareCall("{?=call ELIMINAR_INGRESO(?)}");
            Conexion.fop.registerOutParameter(1, Types.VARCHAR);
            Conexion.fop.setInt(2, identificador);
            Conexion.fop.execute();
            String mensaje = Conexion.fop.getString(1);
            return mensaje;
        } catch (SQLException ex) {
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
    private LinkedList<Soporte> soportesDeIngreso(int idingreso) {
        LinkedList<Soporte> soportes = new LinkedList<>();
        try {
            Conexion.fop = Conexion.conexion.prepareCall("call LEER_SOPORTES_INGRESO(?)");
            Conexion.fop.setInt(1, idingreso);
            ResultSet resultado = Conexion.fop.executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                String numero = resultado.getString("NUMERO");
//                byte[] bytes=resultado.getBlob("ARCHIVO").getBytes(1, (int) resultado.getBlob("ARCHIVO").length());
//                Image archivo=Toolkit.getDefaultToolkit().createImage(bytes);

                Soporte soporte = new Soporte(identificador, numero, null);
                soportes.add(soporte);
            }
            return soportes;
        } catch (SQLException ex) {
            return null;
        }
    }
}

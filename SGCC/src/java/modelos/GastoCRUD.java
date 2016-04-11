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
        LinkedList<Gasto> gastos = new LinkedList<>();
        try {
            Conexion.fop = Conexion.conexion.prepareCall("call LEER_GASTOS()");
            ResultSet resultado = Conexion.fop.executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                String fecha = resultado.getDate("FECHA").toString();
                String empresa = resultado.getString("EMPRESA");
                int valortotal = resultado.getInt("VALORTOTAL");
                int idconcepto = resultado.getInt("IDCONCEPTO");
                Conexion.fop = Conexion.conexion.prepareCall("{?=call NOMBRE_CONCEPTO_GASTO(?)}");
                Conexion.fop.registerOutParameter(1, Types.VARCHAR);
                Conexion.fop.setInt(2, idconcepto);
                Conexion.fop.execute();
                String nombreconcepto = Conexion.fop.getString(1);
                Concepto concepto = new Concepto(idconcepto, nombreconcepto);

                int idfuente = resultado.getInt("IDFUENTE");
                Conexion.fop = Conexion.conexion.prepareCall("{?=call NOMBRE_FUENTE(?)}");
                Conexion.fop.registerOutParameter(1, Types.VARCHAR);
                Conexion.fop.setInt(2, idfuente);
                Conexion.fop.execute();
                String nombrefuente = Conexion.fop.getString(1);
                Fuente fuente = new Fuente(idfuente, nombrefuente);
                Usuario usuario = new Usuario(resultado.getInt("IDUSUARIO"));
                //LinkedList<Soporte> soportes = soportesDeIngreso(identificador);
                Gasto gasto = new Gasto(usuario, identificador, fecha, empresa, concepto, valortotal, fuente, null);
                gastos.add(gasto);
            }
            return gastos;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String nuevoGasto(String fecha, String empresa, int concepto, int valortotal, int fuente, int usuario, String idsoporte, String soporte) {
        try {
            Conexion.fop = Conexion.conexion.prepareCall("{?=call NUEVO_GASTO(?,?,?,?,?,?)}");
            Conexion.fop.registerOutParameter(1, Types.INTEGER);
            Date sqlfecha = Date.valueOf(fecha);
            Conexion.fop.setDate(2, sqlfecha);
            Conexion.fop.setString(3, empresa);
            Conexion.fop.setInt(4, valortotal);
            Conexion.fop.setInt(5, concepto);
            Conexion.fop.setInt(6, fuente);
            Conexion.fop.setInt(7, usuario);
            Conexion.fop.execute();
            int idgasto = Conexion.fop.getInt(1);

            Conexion.fop = Conexion.conexion.prepareCall("{?=call NUEVO_SOPORTE_GASTO(?,?,?)}");
            Conexion.fop.registerOutParameter(1, Types.VARCHAR);
            Conexion.fop.setInt(2, idgasto);
            Conexion.fop.setString(3, idsoporte);
            //Problemas con el soporte: Hay que convertir la ruta en archivo de imagen y luego en un blob
            Blob sqlsoporte = null;
            Conexion.fop.setBlob(4, sqlsoporte);
            Conexion.fop.execute();
            String mensaje = Conexion.fop.getString(1);
            return mensaje;
        } catch (SQLException ex) {
            return "No se ha ingresado correctamente el gasto";
        }
    }

    public Gasto buscarGasto(int identificador) {
        try {
            Gasto gasto = null;
            Conexion.fop = Conexion.conexion.prepareCall("call BUSCAR_GASTO(?)");
            Conexion.fop.setInt(1, identificador);
            ResultSet resultado = Conexion.fop.executeQuery();
            while (resultado.next()) {
                String fecha = resultado.getDate("FECHA").toString();
                String empresa = resultado.getString("EMPRESA");
                int idconcepto = resultado.getInt("IDCONCEPTO");
                Conexion.fop = Conexion.conexion.prepareCall("{?=call NOMBRE_CONCEPTO_GASTO(?)}");
                Conexion.fop.registerOutParameter(1, Types.VARCHAR);
                Conexion.fop.setInt(2, idconcepto);
                Conexion.fop.execute();
                String nombreconcepto = Conexion.fop.getString(1);
                Concepto concepto = new Concepto(idconcepto, nombreconcepto);
                
                int valortotal = resultado.getInt("VALORTOTAL");
                int idfuente = resultado.getInt("IDFUENTE");
                Conexion.fop = Conexion.conexion.prepareCall("{?=call NOMBRE_FUENTE(?)}");
                Conexion.fop.registerOutParameter(1, Types.VARCHAR);
                Conexion.fop.setInt(2, idfuente);
                Conexion.fop.execute();
                String nombrefuente = Conexion.fop.getString(1);
                Fuente fuente = new Fuente(idfuente, nombrefuente);
                Usuario usuario = new Usuario(resultado.getInt("IDUSUARIO"));
//                Falta obtener soportes del ingreso
//                LinkedList<Soporte> soportes=soportesDeIngreso(identificador);
                gasto = new Gasto(usuario, identificador, fecha, empresa, concepto, valortotal, fuente, null);
            }
            return gasto;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public String modificarGasto(int identificador, String fecha, String empresa, int valortotal, int idconcepto, int idfuente, int idusuario)
    {
        try {
            Conexion.fop = Conexion.conexion.prepareCall("{?=call MODIFICAR_GASTO(?,?,?,?,?,?,?)}");
            Conexion.fop.registerOutParameter(1, Types.VARCHAR);
            Conexion.fop.setInt(2, identificador);
            Date sqldate = Date.valueOf(fecha);
            Conexion.fop.setDate(3, sqldate);
            Conexion.fop.setString(4, empresa);
            Conexion.fop.setInt(5, valortotal);
            Conexion.fop.setInt(6, idconcepto);
            Conexion.fop.setInt(7, idfuente);
            Conexion.fop.setInt(8, idusuario);
            Conexion.fop.execute();
            String mensaje = Conexion.fop.getString(1);
            return mensaje;
        } catch (SQLException ex) {
            return "No se ha modificado correctamente el gasto";
        }
    }
    
    public String  eliminarGasto(int identificador){
        try {
            Conexion.fop = Conexion.conexion.prepareCall("{?=call ELIMINAR_GASTO(?)}");
            Conexion.fop.registerOutParameter(1, Types.VARCHAR);
            Conexion.fop.setInt(2, identificador);
            Conexion.fop.execute();
            String mensaje = Conexion.fop.getString(1);
            return mensaje;
        } catch (SQLException ex) {
            return "No se ha eliminado correctamente el gasto";
        }
    }
}

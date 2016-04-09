/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Image;
import java.awt.Toolkit;
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
    
    public LinkedList<Ingreso>leerIngresos()
    {
        try {
            LinkedList<Ingreso>ingresos=new LinkedList<>();
            Conexion.fop=Conexion.conexion.prepareCall("call leerIngresos()");
            ResultSet resultado=Conexion.fop.executeQuery();
            while(resultado.next())
            {
                Usuario usuario=new Usuario(resultado.getInt("IDUSUARIO"));
                String fecha=resultado.getDate("FECHA").toString();
                int identificador=resultado.getInt("IDENTIFICADOR");
                String empresa=resultado.getString("EMPRESA");
                Concepto concepto=new Concepto(resultado.getInt("IDCONCEPTO"));
                int cantidad=resultado.getInt("CANTIDAD");
                int valorunitario=resultado.getInt("VALORUNITARIO");
                int valortotal=resultado.getInt("VALORTOTAL");
                Fuente fuente=new Fuente(resultado.getInt("IDFUENTE"));
                //Falta obtener soportes del ingreso
                LinkedList<Soporte> soportes=soportesDeIngreso(identificador);
                
                Ingreso ingreso=new Ingreso(usuario,fecha,identificador, empresa, concepto, cantidad, valorunitario, valortotal, fuente, soportes);
                ingresos.add(ingreso);
            }
            return ingresos;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    
    public String crearIngreso(Ingreso ingreso)
    {
        try {
            Conexion.fop=Conexion.conexion.prepareCall("{?=call CREAR_INGRESO(?,?,?,?,?,?,?,?,?)}");
            Conexion.fop.registerOutParameter(1, Types.VARCHAR);
            Conexion.fop.setInt(2, ingreso.getIdentificador());
            Date sqldate=Date.valueOf(ingreso.getFecha());
            Conexion.fop.setDate(3, sqldate);
            Conexion.fop.setString(4, ingreso.getEmpresa());
            Conexion.fop.setInt(5, ingreso.getCantidad());
            Conexion.fop.setInt(6, ingreso.getValorunitario());
            Conexion.fop.setInt(7, ingreso.getValortotal());
            Conexion.fop.setInt(8, ingreso.getConcepto().getIdentificador());
            Conexion.fop.setInt(9, ingreso.getFuente().getIdentificador());
            Conexion.fop.setInt(10,ingreso.getUsuario().getIdentificador());
            Conexion.fop.execute();
            String mensaje=Conexion.fop.getString(1);
            return mensaje;
            
        } catch (SQLException ex) {
            return "No se ha modificado correctamente el ingreso";
        }
    }
    
     /**
     * @see Falta la modificacion del soporte.
     * @param ingreso Objeto ingreso que modifica un ingreso de la base de datos.
     * @return mensaje que indica el exito de la modificacion
     */
    public String modificarIngreso(Ingreso ingreso)
    {
        try {
            Conexion.fop=Conexion.conexion.prepareCall("{?=call MODIFICAR_INGRESO(?,?,?,?,?,?,?,?,?)}");
            Conexion.fop.registerOutParameter(1, Types.VARCHAR);
            Conexion.fop.setInt(2, ingreso.getIdentificador());
            Date sqldate=Date.valueOf(ingreso.getFecha());
            Conexion.fop.setDate(3, sqldate);
            Conexion.fop.setString(4, ingreso.getEmpresa());
            Conexion.fop.setInt(5, ingreso.getCantidad());
            Conexion.fop.setInt(6, ingreso.getValorunitario());
            Conexion.fop.setInt(7, ingreso.getValortotal());
            Conexion.fop.setInt(8, ingreso.getConcepto().getIdentificador());
            Conexion.fop.setInt(9, ingreso.getFuente().getIdentificador());
            Conexion.fop.setInt(10,ingreso.getUsuario().getIdentificador());
            Conexion.fop.execute();
            String mensaje=Conexion.fop.getString(1);
            return mensaje;
            
        } catch (SQLException ex) {
            return "No se ha modificado correctamente el ingreso";
        }
    }
    
     /**
     * 
     * @param ingreso Ingreso a eliminar en la base de datos.
     * @return mensaje indicando la eliminacion del ingreso 
     */

    public String eliminar(Ingreso ingreso) {
         try {
            Conexion.fop=Conexion.conexion.prepareCall("{?=call MODIFICAR_INGRESO(?)}");
            Conexion.fop.registerOutParameter(1, Types.VARCHAR);
            Conexion.fop.setInt(2, ingreso.getIdentificador());
            Conexion.fop.execute();
            String mensaje=Conexion.fop.getString(1);
            return mensaje;
            
        } catch (SQLException ex) {
            return "No se ha eliminado correctamente el ingreso";
        }
    }
    
    /**
     * @see Metodo de la clase controladora que permite obtener los soportes asignados a un ingreso.
     * @param idingreso identificador del ingreso.
     * @return un LinkedList<Soporte> Una lista de los soportes que tiene el ingreso.
     */
    private LinkedList<Soporte> soportesDeIngreso(int idingreso)
    {
        LinkedList<Soporte>soportes=new LinkedList<>();
        try {
            Conexion.fop=Conexion.conexion.prepareCall("call SOPORTES_DE_INGRESO");
            ResultSet resultado=Conexion.fop.executeQuery();
            while(resultado.next())
            {
                int identificador=resultado.getInt("IDENTIFICADOR");
                String numero=resultado.getString("NUMERO");
                byte[] bytes=resultado.getBlob("ARCHIVO").getBytes(1, (int) resultado.getBlob("ARCHIVO").length());
                Image archivo=Toolkit.getDefaultToolkit().createImage(bytes);
                
                Soporte soporte=new Soporte(identificador, numero,archivo);
                soportes.add(soporte);
            }
            return soportes;
        } catch (SQLException ex) {
            return null;
        }
    }
}

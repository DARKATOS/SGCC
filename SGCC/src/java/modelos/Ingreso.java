/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jorge Alejandro
 */
public class Ingreso {

    private Usuario usuario;
    private int identificador;
    private String fecha;
    private String empresa;
    private Concepto concepto;
    private int cantidad;
    private int valorunitario;
    private int valortotal;
    private Fuente fuente;
    private LinkedList<Soporte> soportes;

    public Ingreso(Usuario usuario, String fecha, int identificador, String empresa, Concepto concepto, int cantidad, int valorunitario, int valortotal, Fuente fuente, LinkedList<Soporte> soportes) {
        this.usuario = usuario;
        this.identificador = identificador;
        this.fecha=fecha;
        this.empresa = empresa;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
        this.valortotal = valortotal;
        this.fuente = fuente;
        this.soportes = soportes;
    }
    
    /**
     * @see Falta almacenar el soporte.
     * @return mensaje que indica la creacion de un ingreso
     * 
     */
    public String crear()
    {
        try {
            Conexion.funcion=Conexion.conexion.prepareCall("{?=call NUEVO_INGRESO(?,?,?,?,?,?,?,?)}");
            Conexion.funcion.registerOutParameter(1, Types.VARCHAR);
            Date sqldate=Date.valueOf(fecha);
            Conexion.funcion.setDate(2, sqldate);
            Conexion.funcion.setString(3, empresa);
            Conexion.funcion.setInt(4, cantidad);
            Conexion.funcion.setInt(5, valorunitario);
            Conexion.funcion.setInt(6, valortotal);
            Conexion.funcion.setInt(7, concepto.getIdentificador());
            Conexion.funcion.setInt(8, fuente.getIdentificador());
            Conexion.funcion.setInt(9, usuario.getIdentificador());
            Conexion.funcion.execute();
            String mensaje=Conexion.funcion.getString(1);
            return mensaje;
            
        } catch (SQLException ex) {
            return "No se ha creado correctamente el ingreso";
        }
    }
    

    /**
     * @see Falta la modificacion del soporte.
     * @param fecha En la que se realizo la ultima modificación
     * @param empresa nombre de la empresa que se referencia para el ingreso
     * @param concepto motivo por el cual se realiza el ingreso
     * @param cantidad La cantidad de productos vendidos 
     * @param valorunitario valor unitario del producto vendido
     * @param valortotal Valor total de los productos vendidos.
     * @param fuente Ubicacion del dinero.
     * @return mensaje que indica el exito de la modificacion
     */
    public String modificar(String fecha,String empresa, Concepto concepto, int cantidad, int valorunitario, int valortotal, Fuente fuente, Usuario usuario) {
        this.fecha=fecha;
        this.empresa = empresa;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
        this.valortotal = valortotal;
        this.fuente = fuente;
        this.usuario=usuario;
        
        try {
            Conexion.funcion=Conexion.conexion.prepareCall("{?=call MODIFICAR_INGRESO(?,?,?,?,?,?,?,?,?)}");
            Conexion.funcion.registerOutParameter(1, Types.VARCHAR);
            Conexion.funcion.setInt(2, this.identificador);
            Date sqldate=Date.valueOf(this.fecha);
            Conexion.funcion.setDate(3, sqldate);
            Conexion.funcion.setString(4, this.empresa);
            Conexion.funcion.setInt(5, this.cantidad);
            Conexion.funcion.setInt(6, this.valorunitario);
            Conexion.funcion.setInt(7, this.valortotal);
            Conexion.funcion.setInt(8, this.concepto.getIdentificador());
            Conexion.funcion.setInt(9, this.fuente.getIdentificador());
            Conexion.funcion.setInt(10,this.usuario.getIdentificador());
            Conexion.funcion.execute();
            String mensaje=Conexion.funcion.getString(1);
            return mensaje;
            
        } catch (SQLException ex) {
            return "No se ha modificado correctamente el ingreso";
        }
    }
    
    /**
     * 
     * @return mensaje indicando la eliminacion del ingreso 
     */

    public String eliminar() {
         try {
            Conexion.funcion=Conexion.conexion.prepareCall("{?=call MODIFICAR_INGRESO(?)}");
            Conexion.funcion.registerOutParameter(1, Types.VARCHAR);
            Conexion.funcion.setInt(2, this.identificador);
            Conexion.funcion.execute();
            String mensaje=Conexion.funcion.getString(1);
            return mensaje;
            
        } catch (SQLException ex) {
            return "No se ha eliminado correctamente el ingreso";
        }
    }
}

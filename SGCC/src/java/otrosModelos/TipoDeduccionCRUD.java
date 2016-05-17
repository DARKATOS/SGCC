/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otrosModelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import modelos.Conexion;

/**
 *
 * @author Jorge Alejandro
 */
public class TipoDeduccionCRUD {
    
//    public LinkedList<TipoDeduccion>leerTiposDeduccion()
//    {
//        LinkedList<TipoDeduccion> tiposDeduccion = new LinkedList<>();
//        try {
//            Conexion.fop = Conexion.conexion.prepareCall("call LEER_TIPOS_DEDUCCION()");
//            ResultSet resultado = Conexion.fop.executeQuery();
//            while (resultado.next()) {
//                int identificador = resultado.getInt("IDENTIFICADOR");
//                String nombre = resultado.getString("NOMBRE");
//                TipoDeduccion tipoDeduccion = new TipoDeduccion(identificador, nombre);
//                tiposDeduccion.add(tipoDeduccion);
//            }
//            return tiposDeduccion;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
}

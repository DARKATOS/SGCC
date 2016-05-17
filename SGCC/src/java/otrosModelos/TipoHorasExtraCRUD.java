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
public class TipoHorasExtraCRUD {
    
//    public LinkedList<TipoHorasExtra> leerTiposHorasExtra()
//    {
//        LinkedList<TipoHorasExtra> tiposHorasExtra = new LinkedList<>();
//        try {
//            Conexion.fop = Conexion.conexion.prepareCall("call LEER_TIPOS_HORAS_EXTRA()");
//            ResultSet resultado = Conexion.fop.executeQuery();
//            while (resultado.next()) {
//                int identificador = resultado.getInt("IDENTIFICADOR");
//                String nombre = resultado.getString("NOMBRE");
//                double porcentaje = resultado.getDouble("PORCENTAJE");
//                TipoHorasExtra tipoHorasExtra = new TipoHorasExtra(identificador, nombre, porcentaje);
//                tiposHorasExtra.add(tipoHorasExtra);
//            }
//            return tiposHorasExtra;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
}

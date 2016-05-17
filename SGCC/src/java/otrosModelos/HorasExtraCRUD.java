/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otrosModelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import modelos.Conexion;

/**
 *
 * @author Jorge Alejandro
 */
public class HorasExtraCRUD {

//    public LinkedList<HorasExtra> leerHorasExtras(int idLiquidacion) {
//        LinkedList<HorasExtra> horasExtras = new LinkedList<>();
//        try {
//            Conexion.fop = Conexion.conexion.prepareCall("call LEER_HORAS_EXTRA(?)");
//            Conexion.fop.setInt(1, idLiquidacion);
//            ResultSet resultado = Conexion.fop.executeQuery();
//            while (resultado.next()) {
//                int identificador = resultado.getInt("IDENTIFICADOR");
//                int numeroHoras = resultado.getInt("NUMERO_HORAS");
//                int valor = resultado.getInt("VALOR");
//                int idTipoHorasExtra = resultado.getInt("IDTIPO_HORAS_EXTRAS");
//                Conexion.fop = Conexion.conexion.prepareCall("call LEER_TIPO_HORAS_EXTRA(?)");
//                Conexion.fop.setInt(1, idTipoHorasExtra);
//                ResultSet resultado2 = Conexion.fop.executeQuery();
//                TipoHorasExtra tipoHorasExtra=null;
//                while (resultado2.next()) {
//                    tipoHorasExtra=new TipoHorasExtra(resultado2.getInt("IDENTIFICADOR"), resultado2.getString("NOMBRE"), resultado2.getInt("PORCENTAJE"));
//                }
//                HorasExtra horasExtra=new HorasExtra(identificador, numeroHoras, valor, tipoHorasExtra);
//                horasExtras.add(horasExtra);
//            }
//            return horasExtras;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
}

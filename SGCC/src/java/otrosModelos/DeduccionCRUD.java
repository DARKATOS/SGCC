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
public class DeduccionCRUD {
    
    
//    public LinkedList<Deduccion> leerDeducciones(int idLiquidacion)
//    {
//        LinkedList<Deduccion> deducciones = new LinkedList<>();
//        try {
//            Conexion.fop = Conexion.conexion.prepareCall("call LEER_DEDUCCIONES(?)");
//            Conexion.fop.setInt(1, idLiquidacion);
//            ResultSet resultado = Conexion.fop.executeQuery();
//            while (resultado.next()) {
//                int identificador = resultado.getInt("IDENTIFICADOR");
//                int valor = resultado.getInt("VALOR");
//                int idTipoDeduccion = resultado.getInt("IDTIPO_DEDUCCION");
//                Conexion.fop = Conexion.conexion.prepareCall("call LEER_TIPO_DEDUCCION(?)");
//                Conexion.fop.setInt(1, idTipoDeduccion);
//                ResultSet resultado2 = Conexion.fop.executeQuery();
//                TipoDeduccion tipoDeduccion=null;
//                while (resultado2.next()) {
//                    tipoDeduccion=new TipoDeduccion(resultado2.getInt("IDENTIFICADOR"), resultado2.getString("NOMBRE"));
//                }
//                Deduccion deduccion=new Deduccion(identificador, valor,tipoDeduccion);
//                deducciones.add(deduccion);
//            }
//            return deducciones;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }
}

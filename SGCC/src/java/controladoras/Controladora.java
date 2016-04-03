/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoras;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelos.Conexion;

/**
 *
 * @author Jorge Alejandro
 */
public class Controladora {
    
    
    public String obtenerConcepto(int idconcepto)
    {
        try {
            ResultSet resultado = Conexion.consulta.executeQuery("SELECT NOMBRE FROM CONCEPTO WHERE CONCEPTO.IDENTIFICADOR="+idconcepto);
            
            String concepto="";
            while (resultado.next()) {
                concepto = resultado.getString("NOMBRE");
            }
            return concepto;
        } catch (SQLException ex) {
            System.out.println("Error en la consulta");
            return null;
        }
    }
    
    public String obtenerFuente(int idfuente)
    {
        try {
            ResultSet resultado = Conexion.consulta.executeQuery("SELECT NOMBRE FROM FUENTE WHERE FUENTE.IDENTIFICADOR="+idfuente);
            
            String fuente="";
            while (resultado.next()) {
                fuente = resultado.getString("NOMBRE");
            }
            return fuente;
        } catch (SQLException ex) {
            System.out.println("Error en la consulta");
            return null;
        }
    }
}

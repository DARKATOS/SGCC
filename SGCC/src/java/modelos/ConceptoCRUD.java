/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Jorge Alejandro
 */
public class ConceptoCRUD {
    
    public LinkedList<Concepto> leerConceptosIngreso()
    {
        try {
            LinkedList<Concepto>conceptos=new LinkedList<>();
            Conexion.fop=Conexion.conexion.prepareCall("call LEER_CONCEPTOS_INGRESO()");
            ResultSet resultado=Conexion.fop.executeQuery();
            while(resultado.next())
            {
                Concepto concepto=new Concepto(resultado.getInt("IDENTIFICADOR"), resultado.getString("NOMBRE"));
                conceptos.add(concepto);
            }
            return conceptos;
        } catch (SQLException ex) {
            return null;
        }
    }
    public LinkedList<Concepto> leerConceptosGasto()
    {
        try {
            LinkedList<Concepto>conceptos=new LinkedList<>();
            Conexion.fop=Conexion.conexion.prepareCall("call LEER_CONCEPTOS_GASTO()");
            ResultSet resultado=Conexion.fop.executeQuery();
            while(resultado.next())
            {
                Concepto concepto=new Concepto(resultado.getInt("IDENTIFICADOR"), resultado.getString("NOMBRE"));
                conceptos.add(concepto);
            }
            return conceptos;
        } catch (SQLException ex) {
            return null;
        }
    }
}

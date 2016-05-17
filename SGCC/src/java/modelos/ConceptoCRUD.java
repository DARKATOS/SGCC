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
        Conexion conexion=new Conexion();
        try {
            LinkedList<Concepto>conceptos=new LinkedList<>();
            conexion.setFop(conexion.getConexion().prepareCall("call LEER_CONCEPTOS_INGRESO()"));
            ResultSet resultado=conexion.getFop().executeQuery();
            while(resultado.next())
            {
                Concepto concepto=new Concepto(resultado.getInt("IDENTIFICADOR"), resultado.getString("NOMBRE"));
                conceptos.add(concepto);
            }
            conexion.desconectar();
            return conceptos;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }
    public LinkedList<Concepto> leerConceptosGasto()
    {
        Conexion conexion=new Conexion();
        try {
            LinkedList<Concepto>conceptos=new LinkedList<>();
            conexion.setFop(conexion.getConexion().prepareCall("call LEER_CONCEPTOS_GASTO()"));
            ResultSet resultado=conexion.getFop().executeQuery();
            while(resultado.next())
            {
                Concepto concepto=new Concepto(resultado.getInt("IDENTIFICADOR"), resultado.getString("NOMBRE"));
                conceptos.add(concepto);
            }
            conexion.desconectar();
            return conceptos;
        } catch (SQLException ex) {
            conexion.desconectar();
            return null;
        }
    }
}

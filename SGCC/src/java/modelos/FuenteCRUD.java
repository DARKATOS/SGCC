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
public class FuenteCRUD {

    public FuenteCRUD() {
    }
    public LinkedList<Fuente> leerFuentes()
    {
        Conexion conexion=new Conexion();
        try {
            LinkedList<Fuente>fuentes=new LinkedList<>();
            conexion.setFop(conexion.getConexion().prepareCall("call LEER_FUENTES()"));
            ResultSet resultado=conexion.getFop().executeQuery();
            while(resultado.next())
            {
                Fuente fuente=new Fuente(resultado.getInt("IDENTIFICADOR"), resultado.getString("NOMBRE"));
                fuentes.add(fuente);
            }
            conexion.desconectar();
            return fuentes;
        } catch (SQLException ex) {
            return null;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Jorge Alejandro
 */
public class UsuarioCRUD {

    public Usuario inicarSesion(String cedula, String contrasena) {
        try {
            Usuario usuario = null;
            Conexion.fop = Conexion.conexion.prepareCall("call INICIAR_SESION(?,?)");
            Conexion.fop.setString(1, cedula);
            Conexion.fop.setString(2, contrasena);
            ResultSet resultado = Conexion.fop.executeQuery();
            while (resultado.next()) {
                int identificador=resultado.getInt("IDENTIFICADOR");
                String nombre = resultado.getString("NOMBRE");
                String correo = resultado.getString("CORREO");
                String cargo = resultado.getString("CARGO");
                usuario = new Usuario(identificador, nombre, cedula, correo, cargo, contrasena);
            }
            return usuario;
        } catch (SQLException ex) {
            return null;
        }
    }
}

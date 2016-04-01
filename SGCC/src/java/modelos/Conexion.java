/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.*;

/**
 *
 * @author Jorge Alejandro
 */
public class Conexion {

    private Connection conexion;
    private static Statement consulta;

    public Conexion() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/estvacaciones", "root", "jojoJOJO10");
            consulta=conexion.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la clase");
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}

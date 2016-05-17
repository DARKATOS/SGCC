/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jorge Alejandro
 */
public class Conexion {
    private Connection conexion;
    private Statement consulta;
    private CallableStatement fop;

    public Conexion() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectosoftware2", "root", "12345");
            consulta=conexion.createStatement();
            fop=null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la clase");
        } catch (SQLException ex) {
            System.out.println("Error en la conexion");
        }
    }
    
    public void desconectar() {
        try {
            consulta.close();
            fop.close();
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error al desconectar de la base de datos");
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public Statement getConsulta() {
        return consulta;
    }

    public CallableStatement getFop() {
        return fop;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public void setConsulta(Statement consulta) {
        this.consulta = consulta;
    }

    public void setFop(CallableStatement fop) {
        this.fop = fop;
    }

 
}

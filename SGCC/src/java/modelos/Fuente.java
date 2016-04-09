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
public class Fuente {
    private int identificador;
    private String nombre;

    public Fuente(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public Fuente(int identificador) {
        this.identificador=identificador;
    }

    /**
     * @see Permite obtener el nombre de la fuente segun su identificador
     * @return nombre de la fuente
     */
    public String NombreFuente()
    {
        return null;
    }

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Jorge Alejandro
 */
public class TipoDeduccion {
    private int identificador;
    private String nombre;

    public TipoDeduccion(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public TipoDeduccion(int identificador) {
        this.identificador=identificador;
        this.nombre=null;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }
}

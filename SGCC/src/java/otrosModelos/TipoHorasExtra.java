/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otrosModelos;

/**
 *
 * @author Jorge Alejandro
 */
public class TipoHorasExtra {
    private int identificador;
    private String nombre;
    private double porcentaje;

    public TipoHorasExtra(int identificador, String nombre, double porcentaje) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.LinkedList;

/**
 *
 * @author Jorge Alejandro
 */
public class Nomina {
    private int identificador;
    private String fechaInicial;
    private String fechaFinal;
    private LinkedList<Liquidacion>liquidaciones;

    public Nomina(int identificador, String fechaInicial, String fechaFinal, LinkedList<Liquidacion> liquidaciones) {
        this.identificador = identificador;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.liquidaciones = liquidaciones;
    }

    

    public Nomina(int identificador) {
        this.identificador=identificador;
        this.fechaFinal=null;
        this.fechaFinal=null;
        this.liquidaciones=null;
    }
    
    

    public String getFechaFinal() {
        return fechaFinal;
    }

    public String getFechaInicial() {
        return fechaInicial;
    }

    public int getIdentificador() {
        return identificador;
    }

    public LinkedList<Liquidacion> getLiquidaciones() {
        return liquidaciones;
    }
}

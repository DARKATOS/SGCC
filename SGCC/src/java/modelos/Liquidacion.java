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
public class Liquidacion {
    private int identificador;
    private String fecha;
    private int comisiones;
    private int auxilioTransporte;
    private int salud;
    private int pension;
    private int salarioNeto;
    private LinkedList<HorasExtra>horasExtras;
    private LinkedList<Deduccion>deducciones;

    public Liquidacion(int identificador, String fecha, int comisiones, int auxilioTransporte, int salud, int pension, int salarioNeto, LinkedList<HorasExtra> horasExtras, LinkedList<Deduccion> deducciones) {
        this.identificador = identificador;
        this.fecha = fecha;
        this.comisiones = comisiones;
        this.auxilioTransporte = auxilioTransporte;
        this.salud = salud;
        this.pension = pension;
        this.salarioNeto = salarioNeto;
        this.horasExtras = horasExtras;
        this.deducciones = deducciones;
    }

    public int getAuxilioTransporte() {
        return auxilioTransporte;
    }

    public int getComisiones() {
        return comisiones;
    }

    public String getFecha() {
        return fecha;
    }

    public int getIdentificador() {
        return identificador;
    }

    public int getPension() {
        return pension;
    }

    public int getSalarioNeto() {
        return salarioNeto;
    }

    public int getSalud() {
        return salud;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import otrosModelos.HorasExtra;
import otrosModelos.Deduccion;
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
    private int valorHoraExtra;
    private int numeroHorasExtra;
    private int totalHorasExtra;
    private double salud;
    private double pension;
    private double salarioNeto;
    private Empleado empleado;

    public Liquidacion(int identificador, String fecha, int comisiones, int auxilioTransporte, int valorHoraExtra, int numeroHorasExtra, int totalHorasExtra, double salud, double pension, double salarioNeto, Empleado empleado) {
        this.identificador = identificador;
        this.fecha = fecha;
        this.comisiones = comisiones;
        this.auxilioTransporte = auxilioTransporte;
        this.valorHoraExtra = valorHoraExtra;
        this.numeroHorasExtra = numeroHorasExtra;
        this.totalHorasExtra = totalHorasExtra;
        this.salud = salud;
        this.pension = pension;
        this.salarioNeto = salarioNeto;
        this.empleado = empleado;
    }

    public Liquidacion(int identificador, String fecha, Empleado empleado) {
        this.identificador = identificador;
        this.fecha = fecha;
        this.comisiones = -1;
        this.auxilioTransporte = -1;
        this.valorHoraExtra = -1;
        this.numeroHorasExtra = -1;
        this.totalHorasExtra = -1;
        this.salud = -1;
        this.pension = -1;
        this.salarioNeto = -1;
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public int getNumeroHorasExtra() {
        return numeroHorasExtra;
    }

    public int getValorHoraExtra() {
        return valorHoraExtra;
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

    public double getSalud() {
        return salud;
    }

    public double getPension() {
        return pension;
    }

    public double getSalarioNeto() {
        return salarioNeto;
    }

    public int getTotalHorasExtra() {
        return totalHorasExtra;
    }
}

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
public class Ingreso {

    private Empleado usuario;
    private int identificador;
    private String fecha;
    private String empresa;
    private Concepto concepto;
    private int cantidad;
    private int valorunitario;
    private int valortotal;
    private Fuente fuente;
    private LinkedList<Soporte> soportes;

    public Ingreso(Empleado usuario, String fecha, int identificador, String empresa, Concepto concepto, int cantidad, int valorunitario, int valortotal, Fuente fuente, LinkedList<Soporte> soportes) {
        this.usuario = usuario;
        this.identificador = identificador;
        this.fecha=fecha;
        this.empresa = empresa;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
        this.valortotal = valortotal;
        this.fuente = fuente;
        this.soportes = soportes;
    }

    /**
     * @return the usuario
     */
    public Empleado getUsuario() {
        return usuario;
    }

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @return the concepto
     */
    public Concepto getConcepto() {
        return concepto;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @return the valorunitario
     */
    public int getValorunitario() {
        return valorunitario;
    }

    /**
     * @return the valortotal
     */
    public int getValortotal() {
        return valortotal;
    }

    /**
     * @return the fuente
     */
    public Fuente getFuente() {
        return fuente;
    }

    /**
     * @return the soportes
     */
    public LinkedList<Soporte> getSoportes() {
        return soportes;
    }
    
}

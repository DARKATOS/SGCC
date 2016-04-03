/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author Jorge Alejandro
 */
public class Gasto {

    private Usuario usuario;
    private int identificador;
    private Date fecha;
    private String empresa;
    private Concepto concepto;
    private int valortotal;
    private Fuente fuente;
    private LinkedList<Soporte> soportes;

    public Gasto(Usuario usuario, int identificador, Date fecha, String empresa, Concepto concepto, int valortotal, Fuente fuente, LinkedList<Soporte> soportes) {
        this.usuario = usuario;
        this.identificador = identificador;
        this.fecha = fecha;
        this.empresa = empresa;
        this.concepto = concepto;
        this.valortotal = valortotal;
        this.fuente = fuente;
        this.soportes = soportes;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the empresa
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the concepto
     */
    public Concepto getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the valortotal
     */
    public int getValortotal() {
        return valortotal;
    }

    /**
     * @param valortotal the valortotal to set
     */
    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    /**
     * @return the fuente
     */
    public Fuente getFuente() {
        return fuente;
    }

    /**
     * @param fuente the fuente to set
     */
    public void setFuente(Fuente fuente) {
        this.fuente = fuente;
    }

    /**
     * @return the soportes
     */
    public LinkedList<Soporte> getSoportes() {
        return soportes;
    }

    /**
     * @param soportes the soportes to set
     */
    public void setSoportes(LinkedList<Soporte> soportes) {
        this.soportes = soportes;
    }
    
    

}

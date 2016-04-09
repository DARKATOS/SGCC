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
public class Concepto {
    private int identificador;
    private String nombre;

    public Concepto(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public Concepto(int identificador) {
        this.identificador=identificador;
    }
    
    
    /**
     * @see Permite obtener el nombre del concepto segun su identificador
     * @return el nombrre del concpeto
     */
    public String NombreConcepto()
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

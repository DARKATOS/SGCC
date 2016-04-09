/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Image;

/**
 *
 * @author Jorge Alejandro
 */
public class Soporte {
    private int identificador;
    private String numero;
    private Image imagen;

    public Soporte(int identificador, String numero, Image imagen) {
        this.identificador = identificador;
        this.numero = numero;
        this.imagen = imagen;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getNumero() {
        return numero;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the imagen
     */
    public Image getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
}

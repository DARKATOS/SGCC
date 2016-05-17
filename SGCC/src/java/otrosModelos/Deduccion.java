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
public class Deduccion {
    private int identificador;
    private int valor;
    private TipoDeduccion tipo;

    public Deduccion(int identificador, int valor, TipoDeduccion tipo) {
        this.identificador = identificador;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Deduccion(int identificador) {
        this.identificador=identificador;
        this.valor=-1;
        this.tipo=null;
    }
    
    
}

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
public class HorasExtra {
    private int identificador;
    private int numeroHoras;
    private int valor;
    private TipoHorasExtra tipoHora;

    public HorasExtra(int identificador, int numeroHoras, int valor, TipoHorasExtra tipoHora) {
        this.identificador = identificador;
        this.numeroHoras = numeroHoras;
        this.valor = valor;
        this.tipoHora = tipoHora;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public int getIdentificador() {
        return identificador;
    }

    public TipoHorasExtra getTipoHora() {
        return tipoHora;
    }

    public int getValor() {
        return valor;
    }
}

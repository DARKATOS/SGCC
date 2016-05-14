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
public class HorasExtra {
    private int identificador;
    private int horas;
    private int valor;
    private TipoHorasExtra tipoHora;

    public HorasExtra(int identificador, int horas, int valor, TipoHorasExtra tipoHora) {
        this.identificador = identificador;
        this.horas = horas;
        this.valor = valor;
        this.tipoHora = tipoHora;
    }

    public int getHoras() {
        return horas;
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

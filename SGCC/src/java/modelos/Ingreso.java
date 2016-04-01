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
    private int identificador;
    private String empresa;
    private String concepto;
    private int cantidad;
    private int valorunitario;
    private int valortotal;
    private LinkedList<Soporte>soportes;

    public Ingreso(int identificador, String empresa, String concepto, int cantidad, int valorunitario, int valortotal, Soporte soporte) {
        this.identificador = identificador;
        this.empresa=empresa;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.valorunitario = valorunitario;
        this.valortotal = valortotal;
        this.soportes=new LinkedList<>();
        this.soportes.add(soporte);
    }

    public void modificar(String empresa,String concepto,int cantidad,int valorunitario, int valortotal)
    {
        this.empresa=empresa;
        this.concepto=concepto;
        this.cantidad=cantidad;
        this.valorunitario=valorunitario;
        this.valortotal=valortotal;
 
        //Es aca donde llamo a la funcion de modificarIngreso de MYSQL.
    }
    
    public void eliminar()
    {
        
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getEmpresa() {
        return empresa;
    }
    
    public String getConcepto() {
        return concepto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getValorunitario() {
        return valorunitario;
    }

    public int getValortotal() {
        return valortotal;
    }

    public LinkedList<Soporte> getSoportes() {
        return soportes;
    }
}

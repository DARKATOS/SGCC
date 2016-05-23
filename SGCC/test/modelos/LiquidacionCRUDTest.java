/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jorge Alejandro
 */
public class LiquidacionCRUDTest {
    
    public LiquidacionCRUDTest() {
    }

    @Test
    public void testLeerLiquidaciones() {
        
    }

    @Test
    public void testNuevaLiquidacion() {
        LiquidacionCRUD crud=new LiquidacionCRUD();
        boolean exito=crud.nuevaLiquidacion("2016-02-02", 800000, 10000, 77700, 8000, 3, "12345");
        assertEquals(exito, true);
    }

    @Test
    public void testModificarLiquidacion() {
        LiquidacionCRUD crud=new LiquidacionCRUD();
        boolean exito=crud.modificarLiquidacion(1, "02-06-2016", 800000, 280000, 12000, 3);
        assertEquals(exito, true);
    }

    @Test
    public void testEliminarLiquidacion() {
        LiquidacionCRUD crud=new LiquidacionCRUD();
        boolean exito=crud.eliminarLiquidacion(1);
        assertEquals(exito, true);
    }

    @Test
    public void testLeerIdentificadoresLiquidaciones() {
    }

    @Test
    public void testBuscarLiquidacion() {
    }

    @Test
    public void testLeerEmpleadosLiquidacion() {
    }

    @Test
    public void testLeerSalarioBasicoCedula() {
    }
    
}

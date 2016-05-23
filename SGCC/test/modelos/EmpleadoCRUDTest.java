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
public class EmpleadoCRUDTest {
    
    public EmpleadoCRUDTest() {
    }

    @Test
    public void testLeerEmpleados() {
    }

    @Test
    public void testNuevoEmpleado() {
        EmpleadoCRUD crud=new EmpleadoCRUD();
        boolean exito=crud.nuevoEmpleado("XIMENA", "87654", "XIMENA@GMAIL.COM", "VENDEDOR", 1100000, "87654");
        assertEquals(exito, true);
    }

    @Test
    public void testModificarEmpleado() {
        EmpleadoCRUD crud=new EmpleadoCRUD();
        boolean exito=crud.modificarEmpleado("87654", "DANIEL", "DANIEL@GMAIL.COM", "VENDEDOR", 1300000, "87654");
        assertEquals(exito, true);
    }

    @Test
    public void testEliminarEmpleado() {
        EmpleadoCRUD crud=new EmpleadoCRUD();
        boolean exito=crud.eliminarEmpleado("87654");
        assertEquals(exito, true);
    }

    @Test
    public void testLeerCedula() {
    }

    @Test
    public void testInicarSesion() {
    }

    @Test
    public void testBuscarEmpleado() {
    }
    
}

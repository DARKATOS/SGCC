/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoras;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Conexion;
import modelos.Empleado;
import modelos.EmpleadoCRUD;
import modelos.GastoCRUD;

/**
 *
 * @author Jorge Alejandro
 */
@WebServlet(name = "ControladoraAdministracionEmpleados", urlPatterns = {"/ControladoraAdministracionEmpleados"})
public class ControladoraAdministracionEmpleados extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("operacion");
        Conexion c = new Conexion();
        if ("iniciarSesion".equals(operacion)) {
        }
        else if("leerEmpleados".equals(operacion))
        {
            EmpleadoCRUD crud=new EmpleadoCRUD();
            LinkedList<Empleado> empleados= crud.leerEmpleados();
            Gson json = new Gson();
            String resultado = json.toJson(empleados);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("nuevoEmpleado".equals(operacion))
        {
            String nombre=request.getParameter("nombre");
            String cedula=request.getParameter("cedula");
            String correo=request.getParameter("correo");
            String cargo=request.getParameter("cargo");
            int salarioBasico=Integer.parseInt(request.getParameter("salarioBasico"));
            String contrasena=request.getParameter("contrasena");
            EmpleadoCRUD crud = new EmpleadoCRUD();
            boolean resultado = crud.nuevoEmpleado(nombre,cedula,correo,cargo,salarioBasico,contrasena);
            String mensaje="";
            if (resultado)
            {
                mensaje="Se creo el nuevo empleado con exito";
            }
            else
            {
                mensaje="Error en la creacion del empleado";
            }
            response.setContentType("text/plain");
            response.getWriter().write(mensaje);
        }
        else if("modificarEmpleado".equals(operacion))
        {
            String cedula=request.getParameter("cedula");
            String nombre=request.getParameter("nombre");
            String correo=request.getParameter("correo");
            String cargo=request.getParameter("cargo");
            int salarioBasico=Integer.parseInt(request.getParameter("salarioBasico"));
            String contrasena=request.getParameter("contrasena");
            EmpleadoCRUD crud = new EmpleadoCRUD();
            boolean resultado = crud.modificarEmpleado(cedula,nombre,correo,cargo,salarioBasico,contrasena);
            String mensaje="";
            if (resultado)
            {
                mensaje="Se modifico el empleado con exito";
            }
            else
            {
                mensaje="Error en la modificacion del empleado";
            }
            response.setContentType("text/plain");
            response.getWriter().write(mensaje);
        }
        else if("eliminarEmpleado".equals(operacion))
        {
            String cedula=request.getParameter("cedula");
            EmpleadoCRUD crud = new EmpleadoCRUD();
            boolean resultado = crud.eliminarEmpleado(cedula);
            String mensaje="";
            if (resultado)
            {
                mensaje="Se elimino el empleado con exito";
            }
            else
            {
                mensaje="Error en la eliminacion del empleado";
            }
            response.setContentType("text/plain");
            response.getWriter().write(mensaje);
        }
        else if("leerCedulaModificar".equals(operacion))
        {
            EmpleadoCRUD crud=new EmpleadoCRUD();
            LinkedList<Empleado> empleados= crud.leerCedula();
            Gson json = new Gson();
            String resultado = json.toJson(empleados);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("leerCedulaEliminar".equals(operacion))
        {
            EmpleadoCRUD crud=new EmpleadoCRUD();
            LinkedList<Empleado> empleados= crud.leerCedula();
            Gson json = new Gson();
            String resultado = json.toJson(empleados);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("buscarEmpleadoModificar".equals(operacion))
        {
            String cedula=request.getParameter("cedula");
            EmpleadoCRUD crud=new EmpleadoCRUD();
            System.out.println(cedula);
            Empleado empleado= crud.buscarEmpleado(cedula);
            Gson json = new Gson();
            String resultado = json.toJson(empleado);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("buscarEmpleadoEliminar".equals(operacion))
        {
            String cedula=request.getParameter("cedula");
            EmpleadoCRUD crud=new EmpleadoCRUD();
            Empleado empleado= crud.buscarEmpleado(cedula);
            Gson json = new Gson();
            String resultado = json.toJson(empleado);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

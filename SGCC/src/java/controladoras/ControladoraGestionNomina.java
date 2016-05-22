/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoras;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Empleado;
import modelos.Liquidacion;
import modelos.LiquidacionCRUD;

/**
 *
 * @author Jorge Alejandro
 */
@WebServlet(name = "ControladoraGestionNomina", urlPatterns = {"/ControladoraGestionNomina"})
public class ControladoraGestionNomina extends HttpServlet {

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
        String operacion=request.getParameter("operacion");
        
        if ("leerLiquidaciones".equals(operacion))
        {
            LiquidacionCRUD crud=new LiquidacionCRUD();
            LinkedList<Liquidacion> liquidaciones= crud.leerLiquidaciones();
            Gson json = new Gson();
            String resultado = json.toJson(liquidaciones);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("nuevaLiquidacion".equals(operacion))
        {
            String fecha=request.getParameter("fecha");
            int salarioBasico=Integer.parseInt(request.getParameter("salarioBasico"));
            int comisiones=Integer.parseInt(request.getParameter("comisiones"));
            int auxilioTransporte=77700;
            int valorHoraExtra=Integer.parseInt(request.getParameter("valorHoraExtra"));
            int numeroHorasExtra=Integer.parseInt(request.getParameter("numeroHorasExtra"));
            String empleado=request.getParameter("empleado");
            LiquidacionCRUD crud=new LiquidacionCRUD();
            boolean resultado=crud.nuevaLiquidacion(fecha, salarioBasico, comisiones, auxilioTransporte,valorHoraExtra, numeroHorasExtra,empleado);
            String mensaje="";
            if (resultado)
            {
                mensaje="Se ha registrado corrrectamente la liquidacion";
            }
            else
            {
                mensaje="Error al registrar la liquidacion";
            }
            response.setContentType("text/plain");
            response.getWriter().write(mensaje);
        }
        else if ("modificarLiquidacion".equals(operacion))
        {
            int identificador=Integer.parseInt(request.getParameter("identificador"));
            String fecha=request.getParameter("fecha");
            int salarioBasico=Integer.parseInt(request.getParameter("salarioBasico"));
            int comisiones= Integer.parseInt(request.getParameter("comisiones"));
            int valorHoraExtra= Integer.parseInt(request.getParameter("valorHoraExtra"));
            int numeroHorasExtra= Integer.parseInt(request.getParameter("numeroHorasExtra"));
            LiquidacionCRUD crud=new LiquidacionCRUD();
            boolean resultado=crud.modificarLiquidacion(identificador, fecha, salarioBasico, comisiones, valorHoraExtra, numeroHorasExtra);
            String mensaje="";
            if (resultado)
            {
                mensaje="Se ha modificado corrrectamente la liquidacion";
            }
            else
            {
                mensaje="Error al modificar la liquidacion";
            }
            response.setContentType("text/plain");
            response.getWriter().write(mensaje);
            
        }
        else if("leerIdentificadoresModificar".equals(operacion))
        {
            LiquidacionCRUD crud=new LiquidacionCRUD();
            LinkedList<Liquidacion> liquidaciones= crud.leerIdentificadoresLiquidaciones();
            Gson json = new Gson();
            String resultado = json.toJson(liquidaciones);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if ("leerIdentificadoresEliminar".equals(operacion))
        {
            LiquidacionCRUD crud=new LiquidacionCRUD();
            LinkedList<Liquidacion> liquidaciones= crud.leerIdentificadoresLiquidaciones();
            Gson json = new Gson();
            String resultado = json.toJson(liquidaciones);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("buscarLiquidacionModificar".equals(operacion))
        {
            int identificadorp=Integer.parseInt(request.getParameter("identificador"));
            LiquidacionCRUD crud=new LiquidacionCRUD();
            Liquidacion liquidacion= crud.buscarLiquidacion(identificadorp);
            Gson json = new Gson();
            String resultado = json.toJson(liquidacion);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("buscarLiquidacionEliminar".equals(operacion))
        {
            int identificadorp=Integer.parseInt(request.getParameter("identificador"));
            LiquidacionCRUD crud=new LiquidacionCRUD();
            Liquidacion liquidacion= crud.buscarLiquidacion(identificadorp);
            Gson json = new Gson();
            String resultado = json.toJson(liquidacion);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("eliminarLiquidacion".equals(operacion))
        {
            int identificadorp=Integer.parseInt(request.getParameter("identificador"));
            LiquidacionCRUD crud=new LiquidacionCRUD();
            boolean resultado=crud.eliminarLiquidacion(identificadorp);
            String mensaje="";
            if (resultado)
            {
                mensaje="Se ha eliminado corrrectamente la liquidacion";
            }
            else
            {
                mensaje="Error al eliminar la liquidacion";
            }
            response.setContentType("text/plain");
            response.getWriter().write(mensaje);
        }
        else if("leerEmpleadosNuevaLiquidacion".equals(operacion))
        {
            LiquidacionCRUD crud=new LiquidacionCRUD();
            LinkedList<Empleado> empleados= crud.leerEmpleadosLiquidacion();
            Gson json = new Gson();
            String resultado = json.toJson(empleados);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("leerSalarioBasicoCedula".equals(operacion))
        {
            String cedula=request.getParameter("empleado");
            LiquidacionCRUD crud=new LiquidacionCRUD();
            int salarioBasico= crud.leerSalarioBasicoCedula(cedula);
            String salarioBasicop=String.valueOf(salarioBasico);
            System.out.println(salarioBasicop);
            response.setContentType("text/plain");
            response.getWriter().write(salarioBasicop);
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

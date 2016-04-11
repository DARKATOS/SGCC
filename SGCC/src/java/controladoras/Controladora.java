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
import modelos.Concepto;
import modelos.ConceptoCRUD;
import modelos.Conexion;
import modelos.Fuente;
import modelos.FuenteCRUD;
import modelos.Gasto;
import modelos.GastoCRUD;
import modelos.Ingreso;
import modelos.IngresoCRUD;

/**
 *
 * @author Jorge Alejandro
 */
@WebServlet(name = "Controladora", urlPatterns = {"/Controladora"})
public class Controladora extends HttpServlet {

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
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Controladora</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Controladora at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
//        processRequest(request, response);

        String operacion = request.getParameter("operacion");
        Conexion c=new Conexion();
        if ("iniciarSesion".equals(operacion)) {
            
        }
        else if("leerIngresos".equals(operacion))
        {
            IngresoCRUD CRUD=new IngresoCRUD();
            LinkedList<Ingreso> ingresos=CRUD.leerIngresos();
            Gson json = new Gson();
            String resultado = json.toJson(ingresos);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("leerConceptosIngreso".equals(operacion))
        {
            ConceptoCRUD CRUD=new ConceptoCRUD();
            LinkedList<Concepto>conceptos=CRUD.leerConceptosIngreso();
            Gson json = new Gson();
            String resultado = json.toJson(conceptos);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("leerFuentes".equals(operacion))
        {
            FuenteCRUD CRUD = new FuenteCRUD();
            LinkedList<Fuente> fuentes = CRUD.leerFuentes();
            Gson json = new Gson();
            String resultado = json.toJson(fuentes);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("nuevoIngreso".equals(operacion))
        {
            String fecha=request.getParameter("fecha");
            String empresa=request.getParameter("empresa");
            int concepto=Integer.parseInt(request.getParameter("concepto"));
            int valorunitario=Integer.parseInt(request.getParameter("valorunitario"));
            int cantidad=Integer.parseInt(request.getParameter("cantidad"));
            int valortotal=Integer.parseInt(request.getParameter("valortotal"));
            int fuente=Integer.parseInt(request.getParameter("fuente"));
            //Problema con el usuario: Tenemos que saber como son las sesiones en java web para obtener su identificador.
            int usuario=1;
            String idsoporte=request.getParameter("idsoporte");
            String soporte=request.getParameter("soporte");
            IngresoCRUD CRUD=new IngresoCRUD();
            String resultado=CRUD.nuevoIngreso(fecha, empresa, concepto, valorunitario, cantidad, valortotal, fuente, idsoporte, soporte, usuario);
            response.setContentType("text/plain");
            response.getWriter().write(resultado);
        }
        else if("buscarIngreso".equals(operacion))
        {
            int identificador=Integer.parseInt(request.getParameter("identificador"));
            IngresoCRUD CRUD=new IngresoCRUD();
            Ingreso ingreso=CRUD.buscarIngreso(identificador);
            Gson json = new Gson();
            String resultado = json.toJson(ingreso);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("modificarIngreso".equals(operacion))
        {
            int identificador=Integer.parseInt(request.getParameter("identificador"));
            String fecha=request.getParameter("fecha");
            String empresa=request.getParameter("empresa");
            int concepto=Integer.parseInt(request.getParameter("concepto"));
            int valorunitario=Integer.parseInt(request.getParameter("valorunitario"));
            int cantidad=Integer.parseInt(request.getParameter("cantidad"));
            int valortotal=Integer.parseInt(request.getParameter("valortotal"));
            int fuente=Integer.parseInt(request.getParameter("fuente"));
            //Problema con el usuario: Tenemos que saber como son las sesiones en java web para obtener su identificador.
            int usuario=1;
            String idsoporte=request.getParameter("idsoporte");
            String soporte=request.getParameter("soporte");
            IngresoCRUD CRUD=new IngresoCRUD();
            String resultado=CRUD.modificarIngreso(identificador,fecha, empresa, concepto, valorunitario, cantidad, valortotal, fuente, idsoporte, soporte, usuario);
            response.setContentType("text/plain");
            response.getWriter().write(resultado);
        }
        else if("eliminarIngreso".equals(operacion))
        {
            int identificador=Integer.parseInt(request.getParameter("identificador"));
            System.out.println("Entre aqui");
            IngresoCRUD CRUD=new IngresoCRUD();
            String resultado=CRUD.eliminarIngreso(identificador);
            response.setContentType("text/plain");
            response.getWriter().write(resultado);
        }
        else if ("leerGastos".equals(operacion))
        {
            GastoCRUD gasto = new GastoCRUD();
            LinkedList<Gasto> gastos = gasto.leerGastos();
            Gson json = new Gson();
            String resultado = json.toJson(gastos);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if ("leerConceptosGasto".equals(operacion))
        {
            ConceptoCRUD CRUD=new ConceptoCRUD();
            LinkedList<Concepto>conceptos=CRUD.leerConceptosGasto();
            Gson json = new Gson();
            String resultado = json.toJson(conceptos);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if ("nuevoGasto".equals(operacion)) {
            String fecha = request.getParameter("fecha");
            String empresa = request.getParameter("empresa");
            int concepto = Integer.parseInt(request.getParameter("concepto"));
            int valortotal = Integer.parseInt(request.getParameter("valortotal"));
            int fuente = Integer.parseInt(request.getParameter("fuente"));
            int usuario = 1;
            String idsoporte = request.getParameter("idsoporte");
            String soporte = request.getParameter("soporte");
            GastoCRUD gastocrud = new GastoCRUD();
            String resultado = gastocrud.nuevoGasto(fecha, empresa, concepto, valortotal, fuente, usuario, idsoporte, soporte);
            response.setContentType("text/plain");
            response.getWriter().write(resultado);
        }
        else if("buscarGasto".equals(operacion))
        {
            int identificador=Integer.parseInt(request.getParameter("identificador"));
            GastoCRUD CRUD=new GastoCRUD();
            Gasto gasto=CRUD.buscarGasto(identificador);
            Gson json = new Gson();
            String resultado = json.toJson(gasto);
            response.setContentType("application/json");
            response.getWriter().write(resultado);
        }
        else if("modificarGasto".equals(operacion))
        {
            int identificador=Integer.parseInt(request.getParameter("identificador"));
            String fecha=request.getParameter("fecha");
            String empresa=request.getParameter("empresa");
            int concepto=Integer.parseInt(request.getParameter("concepto"));
            int valortotal=Integer.parseInt(request.getParameter("valortotal"));
            int fuente=Integer.parseInt(request.getParameter("fuente"));
            //Problema con el usuario: Tenemos que saber como son las sesiones en java web para obtener su identificador.
            int usuario=1;
            String idsoporte=request.getParameter("idsoporte");
            String soporte=request.getParameter("soporte");
            GastoCRUD CRUD=new GastoCRUD();
            String resultado=CRUD.modificarGasto(identificador, fecha, empresa, valortotal, concepto, fuente, usuario);
            response.setContentType("text/plain");
            response.getWriter().write(resultado);
        }
        else if("eliminarGasto".equals(operacion)){
            GastoCRUD gasto= new GastoCRUD();
            int idgasto=Integer.parseInt(request.getParameter("identificador"));
            String mensaje=gasto.eliminarGasto(idgasto);
            response.setContentType("text/plain");
            response.getWriter().write(mensaje);
        }
        c.desconectar();
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

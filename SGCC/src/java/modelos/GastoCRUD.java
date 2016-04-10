/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;

/**
 *
 * @author Jorge Alejandro
 */
public class GastoCRUD {

    public GastoCRUD() {
    }

    public LinkedList<Gasto> leerGastos() {
        LinkedList<Gasto> gastos = new LinkedList<>();
        try {
            Conexion.fop = Conexion.conexion.prepareCall("call LEER_GASTOS()");
            ResultSet resultado = Conexion.fop.executeQuery();
            while (resultado.next()) {
                int identificador = resultado.getInt("IDENTIFICADOR");
                String fecha = resultado.getDate("FECHA").toString();
                String empresa = resultado.getString("EMPRESA");
                int valortotal = resultado.getInt("VALORTOTAL");
                int idconcepto = resultado.getInt("IDCONCEPTO");
                Conexion.fop = Conexion.conexion.prepareCall("{?=call NOMBRE_CONCEPTO_GASTO(?)}");
                Conexion.fop.registerOutParameter(1, Types.VARCHAR);
                Conexion.fop.setInt(2, idconcepto);
                Conexion.fop.execute();
                String nombreconcepto = Conexion.fop.getString(1);
                Concepto concepto = new Concepto(idconcepto, nombreconcepto);

                int idfuente = resultado.getInt("IDFUENTE");
                Conexion.fop = Conexion.conexion.prepareCall("{?=call NOMBRE_FUENTE(?)}");
                Conexion.fop.registerOutParameter(1, Types.VARCHAR);
                Conexion.fop.setInt(2, idfuente);
                Conexion.fop.execute();
                String nombrefuente = Conexion.fop.getString(1);
                Fuente fuente = new Fuente(idfuente, nombrefuente);
                Usuario usuario = new Usuario(resultado.getInt("IDUSUARIO"));
                //LinkedList<Soporte> soportes = soportesDeIngreso(identificador);
                Gasto gasto = new Gasto(usuario, identificador, fecha, empresa, concepto, valortotal, fuente, null);
                gastos.add(gasto);
            }
            return gastos;
        } catch (SQLException ex) {
            return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class Conexion {

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Connection con;
    Statement smt;
    ResultSet rs;

    public Connection ConectarBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/shoes", "root", "");
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println("Error en la conexion -> " + error.getMessage());
        }
        return con;
    }

    public void Conectar() {
        try {
            Class.forName("com.mysql.jbdc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/shoes", "root", "");
        } catch (ClassNotFoundException | SQLException error) {
            System.out.println("Error al desconectar la base de datos " + error.getMessage());
        }
    }

    public boolean siExiste(String consulta) {
        boolean existeRegistro = false;
        Conectar();
        try (PreparedStatement ps = con.prepareStatement(consulta)) {
            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getRow() > 0) {
                    existeRegistro = true;

            }
                }

        } catch (SQLException e) {
            System.out.println("Error en la consulta " + e.getMessage());

        }
        return existeRegistro;
    }

    public ResultSet busqueda(String consulta) {
        conectar();
        try {
            smt = con.createStatement();
            rs = smt.executeQuery(consulta);
        } catch (SQLException e) {
            System.out.println("Error en la consulta" + e.getMessage());
        }
        return rs;
    }

    public int Insertar(String consulta ) {
        int resultado = 0;
        conectar();
        try {
            smt = con.createStatement();
            resultado = smt.executeUpdate(consulta);
        } catch (SQLException e) {
            System.out.println("Error en la consulta "
                    + e.getMessage());
        }
        Desconectar();
        return resultado;
    }

    private void conectar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Desconectar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
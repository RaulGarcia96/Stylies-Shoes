/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Alumno
 */
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Producto {

    private String codigo;
    private String nombre;
    private String descripcion;
    private String cveCategoria;
    private int cantidad;
    private double precioC;
    private double precioV;
    private String cveProveedor;

    private ResultSet rs;

    private String consulta;

    Connection conn;
    Statement st;

    public Producto() throws SQLException { //constructor
        conn = Conexion.getConnection();
        st = conn.createStatement();
    }

    public int buscarProducto(String cod) {
        int ban = 0;

        consulta = "SELECT * From categoria WHERE codigo=" + cod;

        /* if(conn.siExiste(consulta)){
                   consulta = "SELECT nombre, descripcion, categoria, proveedor,precio_venta, precio_compra,cantidad "+
                           "FROM categoria" +
                           "WHERE codigo=" + cod;
         */
        try {
            rs = st.executeQuery(consulta);

            if (rs.next()) {
                nombre = rs.getString("nombre");
                descripcion=rs.getString("descripcion");
                cveCategoria=rs.getString("categoria");
                precioC=rs.getDouble("precio_compra");
                precioV=rs.getDouble("precio_venta");
                cveProveedor=rs.getString("proveedor");
               
                ban = 1;
                  }

            

        } catch (SQLException e) {
            System.out.println("Error: "
                    + e.getMessage());
        }
        return ban;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String cod) {
        codigo = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        nombre = nom;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String desc) {
        descripcion = desc;
    }

    public String getCveCategoria() {
        return cveCategoria;
    }

    public void setCveCategoria(String cveCat) {
        cveCategoria = cveCat;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cant) {
        cantidad = cant;
    }

    public double getPrecioC() {
        return precioC;
    }

    public void setPrecioC(double preC) {
        precioC = preC;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double preV) {
        precioV = preV;
    }

    public String getCveProveedor() {
        return cveProveedor;
    }

    public void setCveProveedor(String cveProd) {
        cveProveedor = cveProd;
    }

}

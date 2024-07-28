
package com.mycompany.transacciones_mariadb.mariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author WilderL
 */
public class ConexionCliente {

    public ResultSet consulta(Connection conexion) throws SQLException{
        String sql = "SELECT C.*, T.Numero FROM Cliente C "
                + "INNER JOIN Telefono T ON C.ID_Cliente=T.Cliente_ID_Cliente "
                + "ORDER BY C.ID_Cliente";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        
        return stmt.executeQuery();
    }
    
    public ResultSet getIdCliente(Connection conexion, String nombre, 
            String apellido) throws SQLException{
        String sql = "SELECT id FROM Cliente WHERE Nombre=?, Apellido=?";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        
        return stmt.executeQuery();
    }
    
    public boolean insertar(Connection conexion, String nombre, String apellido,
            String direccion) throws SQLException{
        String sql = "INSERT INTO Cliente (Nombre, Apellido, Direccion) "
                + "VALUES (?, ?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, nombre);
        stmt.setString(2, apellido);
        stmt.setString(3, direccion);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }

}


package com.mycompany.transacciones_mariadb.mariaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author WilderL
 */
public class ConexionTelefono {
    public boolean insertar(Connection conexion, String numero, String idCliente
            ) throws SQLException{
        String sql = "INSERT INTO Telefono (Numero, Cliente_ID_Cliente) "
                + "VALUES (?, ?)";
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, numero);
        stmt.setString(2, idCliente);
        // ejecutar la consulta
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    }
}

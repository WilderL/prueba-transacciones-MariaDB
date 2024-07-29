
package com.mycompany.transacciones_mariadb;

import com.mycompany.transacciones_mariadb.gui.Formulario;
import com.mycompany.transacciones_mariadb.mariaDB.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WilderL
 */
public class Transacciones_MariaDB {

    public static void main(String[] args) {
        try {
            Conexion conexionDB = new Conexion();
            Connection conexion = conexionDB.obtenerConexion();
            Formulario window = new Formulario(conexion);
            window.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Transacciones_MariaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

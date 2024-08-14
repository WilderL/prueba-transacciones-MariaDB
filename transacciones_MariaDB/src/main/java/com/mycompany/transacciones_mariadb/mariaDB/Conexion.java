
package com.mycompany.transacciones_mariadb.mariaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author WilderL
 */
public class Conexion {
    private static Connection conexion;
    private final static String USER = "root";
    private final static String PASSWORD = "";
    private final static String URL = "jdbc:mariadb://localhost:3306/Transaccion?serverTimezone=UTC";
    
    // Método para obtener la conexión a la base de datos
    public Connection obtenerConexion() {
        if (conexion == null) {
            try {
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión establecida correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return conexion;
    }

    // Método para cerrar la conexión a la base de datos
    public void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
    
    // Método para iniciar una transacción
    public boolean iniciarTransaccion(Connection conexion) {
        try {
            conexion.setAutoCommit(false);
            System.out.println("Transacción iniciada.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al iniciar la transacción: " + e.getMessage());
            return false;
        }
    }

    // Método para hacer commit de una transacción
    public boolean commitTransaccion(Connection conexion) {
        try {
            conexion.commit();
            conexion.setAutoCommit(true);
            System.out.println("Transacción realizada con éxito.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al hacer commit de la transacción: " + e.getMessage());
            return false;
        }
    }

    // Método para hacer rollback de una transacción
    public boolean rollbackTransaccion(Connection conexion) {
        try {
            conexion.rollback();
            conexion.setAutoCommit(true);
            System.out.println("Rollback realizado.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al hacer rollback de la transacción: " + e.getMessage());
            return false;
        }
    }
    
    // Método para establecer el nivel de aislamiento
    /**
     * Método para establecer el nivel de aislameinto de una coneción.
     * 1 -> read uncomitted
     * 2 -> read committed 
     * 3 -> reapetable read (default)
     * 4 -> Serializable
     * 
     * @param conexion Coneción a la base de datos que se esta utilizando.
     * @param nivel Modificador de nivel de aislamiento mediante un numero.
     * @return Un booleano si se puedo cambiar el nivel de aislamiento.
     */
    private boolean establecerNivelAislamiento(Connection conexion, int nivel) {
        try {
            conexion.setTransactionIsolation(nivel);
            System.out.println("Nivel de aislamiento establecido a: " + nivel);
            return true;
        } catch (SQLException e) {
            System.out.println("Error al establecer el nivel de aislamiento: " + e.getMessage());
            return false;
        }
    }

    // read uncomitted
    public boolean establecerReadUncommitted(Connection conexion) {
        return establecerNivelAislamiento(conexion, Connection.TRANSACTION_READ_UNCOMMITTED);
    }

    // read committed 
    public boolean establecerReadCommitted(Connection conexion) {
        return establecerNivelAislamiento(conexion, Connection.TRANSACTION_READ_COMMITTED);
    }

    // reapetable read (default)
    public boolean establecerRepeatableRead(Connection conexion) {
        return establecerNivelAislamiento(conexion, Connection.TRANSACTION_REPEATABLE_READ);
    }
    
    // Serializable
    public boolean establecerSerializable(Connection conexion) {
        return establecerNivelAislamiento(conexion, Connection.TRANSACTION_SERIALIZABLE);
    }
}

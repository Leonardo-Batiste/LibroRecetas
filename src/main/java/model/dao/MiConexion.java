
package model.dao;
import java.sql.*;
import model.entity.*;

public class MiConexion {
    private String urlDB = "jdbc:mariadb://localhost:3306/libro_recetas";
    private String usuario = "root";
    private String contraseña = "";
    
    public java.sql.Connection getConexion() throws SQLException {
        return DriverManager.getConnection(urlDB, usuario, contraseña);
    }
}

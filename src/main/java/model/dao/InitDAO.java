
package model.dao;

import java.sql.*;
import model.entity.*;


public class InitDAO {
    String urlServer = "jdbc:mariadb://3306";
    String usuario = "root";
    String contraseña = "";
        
    public void crearDB() throws MyException {
        String consultaCrearTabla = "create database if not exists libro_recetas";
        try (Connection con = DriverManager.getConnection(urlServer, usuario, contraseña)) {
            Statement stat = con.createStatement();
            stat.execute(consultaCrearTabla);
            
        } catch (SQLException sqlException){
            throw new MyException("Error al crear la base de datos libro_recetas | " + sqlException.getMessage());
        }
    }
    
    public void crearTablas() throws MyException {
        String consultaCrearTablaRecetas = "create table if not exists recetas("
                + "id_receta integer primary key auto_increment,"
                + "nombre text not null,"
                + "categoria integer not null)";
        String consultacrearTablaIngredientes = "create table if not exists ingredientes("
                + "id_ingrediente integer primary key auto_increment,"
                + "nombre text not null)";
        String consultaCrearTablaPasos = "create table if not exists pasos("
                + "id_paso integer primary key auto_increment,"
                + "id_receta integer,"
                + "orden integer not null,"
                + "descripcion text not null,"
                + "foreign key (id_receta) references recetas (id_receta) on delete cascade)";
        String consultaCrearReceta_ingrediente = "create table if not exists receta_ingrediente("
                + "id_receta integer,"
                + "id_ingrediente integer,"
                + "foreign key (id_receta) references recetas (id_receta) on delete cascade,"
                + "foreign key (id_ingrediente) references ingredientes (id_ingrediente) on delete cascade)";
        
        try (Connection con = DriverManager.getConnection(urlServer, usuario, contraseña)) {
            Statement crearTablas = con.createStatement();
            
            crearTablas.execute(consultaCrearTablaRecetas);
            crearTablas.execute(consultacrearTablaIngredientes);
            crearTablas.execute(consultaCrearTablaPasos);
            crearTablas.execute(consultaCrearReceta_ingrediente);
            
        } catch (SQLException sqlException) {
            throw new MyException("Error al crear tablas | " + sqlException.getMessage());
        }
        
    }
}

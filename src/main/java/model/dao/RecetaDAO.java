
package model.dao;

import java.sql.*;
import model.entity.*;
import model.dao.*;

public class RecetaDAO {
    MiConexion conexionDB = new MiConexion();
    private int id_receta = 0;
    private int id_ingrediente = 0;
    
    public void introducirReceta(Receta recetaIntroducida, Ingrediente ingredienteIntroducido, Paso pasoIntroducido, 
            Receta_ingrediente recetaIngredienteIntroducido) throws MyException {
        try (Connection con = conexionDB.getConexion()) {
            
            String consultaRecetas = "insert into recetas (id_receta, nombre, categoria)" + "values (?,?,?)";
            try (PreparedStatement statReceta = con.prepareStatement(consultaRecetas, id_receta)){
                statReceta.setInt(1, recetaIntroducida.getId_receta());
                statReceta.setString(2, recetaIntroducida.getNombre());
                statReceta.setInt(3, recetaIntroducida.getCategoria());
                statReceta.executeUpdate();
            }
            
            String consultaIngredientes = "insert into ingredientes (id_ingrediente, nombre)" + "values (?,?)";
            try (PreparedStatement statIngrediente = con.prepareStatement(consultaIngredientes, id_ingrediente)){
                statIngrediente.setInt(1, ingredienteIntroducido.getIdIngrediente());
                statIngrediente.setString(2, ingredienteIntroducido.getNombre());
                statIngrediente.executeUpdate();
            }
            
            String consultaPasos = "insert into pasos (id_paso, id_receta, orden, descripcion)" + "values (?,?,?,?)";
            try (PreparedStatement statPasos = con.prepareStatement(consultaPasos)){
                statPasos.setInt(1, pasoIntroducido.getIdPaso());
                statPasos.setInt(2, pasoIntroducido.getIdReceta());
                statPasos.setInt(3, pasoIntroducido.getOrden());
                statPasos.setString(4, pasoIntroducido.getDescripcion());
                statPasos.executeUpdate();
            }
            
            String consultaReceta_ingredientes = "insert into receta_ingrediente (id_receta, id_ingrediente)" + "values (?,?)";
            try (PreparedStatement consultaReceta_ingrediente = con.prepareStatement(consultaReceta_ingredientes)){
                consultaReceta_ingrediente.setInt(1, recetaIngredienteIntroducido.getIdReceta());
                consultaReceta_ingrediente.setInt(2, recetaIngredienteIntroducido.getIdIngrediente());
                consultaReceta_ingrediente.executeUpdate();
            }
            
        } catch (SQLException sqlException) {
            throw new MyException("Error al introducir receta en db | " + sqlException.getMessage());
        }
    }
}

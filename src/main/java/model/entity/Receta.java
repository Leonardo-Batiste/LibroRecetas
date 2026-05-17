
package model.entity;


public class Receta {
    private int id_receta;
    private String nombre;
    private int categoria;
    
    public Receta(int idRecetaIntroducida, String nombreIntroducido, int categoriaIntroducida) {
        this.id_receta = idRecetaIntroducida;
        this.nombre = nombreIntroducido;
        this.categoria = categoriaIntroducida;
    }

    public int getId_receta() {
        return id_receta;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }
    
    
}

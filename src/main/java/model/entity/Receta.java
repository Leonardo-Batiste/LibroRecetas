
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
}

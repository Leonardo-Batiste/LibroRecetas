
package model.entity;


public class Receta_ingrediente {
    private int idReceta;
    private int idIngrediente;
    private float cantidad;
    
    public Receta_ingrediente(int idRecetaIntroducido, int idIngredienteIntroducido, float cantidadIntroducida){
        this.idReceta = idRecetaIntroducido;
        this.idIngrediente = idIngredienteIntroducido;
        this.cantidad = cantidadIntroducida;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public float getCantidad() {
        return cantidad;
    }
    
    
}

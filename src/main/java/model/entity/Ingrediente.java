
package model.entity;


public class Ingrediente {
    private int idIngrediente;
    private String  nombre;
    
    public Ingrediente(int idIngredienteIntroducido, String nombreIntroducido){
        this.idIngrediente = idIngredienteIntroducido;
        this.nombre = nombreIntroducido;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}

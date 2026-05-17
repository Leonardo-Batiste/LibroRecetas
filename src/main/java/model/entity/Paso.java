
package model.entity;


public class Paso {
    private int idPaso;
    private int idReceta;
    private int orden;
    private String descripcion;
    
    public Paso(int idPasoIntroducido, int idRecetaIntroducida, int ordenIntroducida, String descripcionIntroducida){
        this.idPaso = idPasoIntroducido;
        this.idReceta = idRecetaIntroducida;
        this.orden = ordenIntroducida;
        this.descripcion = descripcionIntroducida;
    }

    public int getIdPaso() {
        return idPaso;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public int getOrden() {
        return orden;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}

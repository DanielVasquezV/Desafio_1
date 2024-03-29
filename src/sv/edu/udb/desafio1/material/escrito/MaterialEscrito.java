package sv.edu.udb.desafio1.material.escrito;

import sv.edu.udb.desafio1.material.Material;

import java.util.HashMap;

public class MaterialEscrito extends Material {
    private String editorial;

    //Constructor de la clase
    public MaterialEscrito(String codigoIdentificacion, String titulo, int unidadesDisponibles, String editorial) {
        super(codigoIdentificacion, titulo, unidadesDisponibles);
        this.editorial = editorial;
    }

    //Setter y Getter
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public String getEditorial() {
        return editorial;
    }

    public String toString() {
        return "Escritos{" +
                "codigoIdentificacion='" + getCodigoIdentificacion() + '\'' +
                "titulo='" + getTitulo() + '\'' +
                ", unidadesDisponibles=" + getUnidadesDisponibles() + '\'' +
                ", editorial='" + editorial + '\'' +
                '}';
    }

}

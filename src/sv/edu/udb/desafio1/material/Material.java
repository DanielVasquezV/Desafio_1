package sv.edu.udb.desafio1.material;

import java.util.Random;

public class Material {
    private String codigoIdentificacion;
    private String titulo;
    private int unidadesDisponibles;

    //Constructor de la clase
    public Material(String codigoIdentificacion, String titulo, int unidadesDisponibles) {
        this.codigoIdentificacion = codigoIdentificacion;
        this.titulo = titulo;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    //Setter y Getter
    public String getCodigoIdentificacion() {
        return codigoIdentificacion;
    }

    public void setCodigoIdentificacion(String codigoIdentificacion) {
        this.codigoIdentificacion = codigoIdentificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

}

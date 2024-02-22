package sv.edu.udb.desafio1.material.escrito;

import sv.edu.udb.desafio1.material.audiovisual.MaterialAudioVisual;

import java.util.HashMap;

public class Revista extends MaterialEscrito {
    private String periodicidad;
    private String fechaPublicacion;

    //Constructor de la clase
    public Revista(String codigoIdentificacion, String titulo, int unidadesDisponibles, String editorial, String periodicidad, String fechaPublicacion) {
        super(codigoIdentificacion, titulo, unidadesDisponibles, editorial);
        this.periodicidad = periodicidad;
        this.fechaPublicacion = fechaPublicacion;
    }

    // Setter y Getter
    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String toString() {
        return "Revista{" +
                "codigoIdentificacion='" + getCodigoIdentificacion() + '\'' +
                "titulo='" + getTitulo() + '\'' +
                ", unidadesDisponibles=" + getUnidadesDisponibles() + '\'' +
                ", periodicidad='" + periodicidad + '\'' +
                ", fechaPublicacion='" + fechaPublicacion + '\'' +
                '}';
    }

    public class RevistasMediateca{
        public HashMap<Integer, Revista> revistas;

        public RevistasMediateca(){
            this.revistas = new HashMap<>();
        }
        public void addMaterial(Revista revista ){
            revistas.put(revistas.size()+1, revista);
        }
    }
}


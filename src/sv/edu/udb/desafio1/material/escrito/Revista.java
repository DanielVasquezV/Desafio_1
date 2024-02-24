package sv.edu.udb.desafio1.material.escrito;

public class Revista extends MaterialEscrito {
    private String periodicidad;
    private String fechaPublicacion;

    //Constructor de la clase
    public Revista(String codigoIdentificacion, String titulo, String editorial,  String periodicidad, String fechaPublicacion, int unidadesDisponibles) {
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
        return
                "Código: " + getCodigoIdentificacion() + ',' +
                " Titulo: " + getTitulo() + ',' +
                " Editorial: " + getEditorial() + ',' +
                " Unidades disponibles: " + getUnidadesDisponibles() + ',' +
                " Periodicidad: " + periodicidad + ',' +
                " Fecha de publicación: " + fechaPublicacion + ',';
    }

}


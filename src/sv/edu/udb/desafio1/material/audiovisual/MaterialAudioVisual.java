package sv.edu.udb.desafio1.material.audiovisual;
import sv.edu.udb.desafio1.material.Material;

public class MaterialAudioVisual extends Material {
    private String duracion;
    private String genero;

    //Constructor de la clase
    public MaterialAudioVisual(String codigoIdentificacion, String titulo, int unidadesDisponibles, String duracion, String genero) {
        super(codigoIdentificacion, titulo, unidadesDisponibles);
        this.duracion = duracion;
        this.genero = genero;
    }

    // Setter y Getter
    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String toString() {
        return "AudioVisual{" +
                "codigoIdentificacionMav='" + getCodigoIdentificacion() + '\'' +
                "tituloMav='" + getTitulo() + '\'' +
                ", unidadesDisponiblesMav=" + getUnidadesDisponibles() + '\'' +
                ", duracionMav='" + duracion + '\'' +
                ", generoMav='" + genero + '\'' +
                '}';
    }

}
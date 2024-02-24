package sv.edu.udb.desafio1.material.audiovisual;
import java.util.HashMap;


public class CdAudio extends MaterialAudioVisual {
    private String artista;
    private int numeroCanciones;

    //Constructor de la clase
    public CdAudio(String codigoIdentificacion, String titulo, String artista,  String genero, String duracion,  int numeroCanciones, int unidadesDisponibles){
        super(codigoIdentificacion, titulo, unidadesDisponibles, duracion, genero);
        this.artista = artista;
        this.numeroCanciones = numeroCanciones;
    }

    // Setter y Getter
    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public String toString() {
        return
                "Código: " + getCodigoIdentificacion() + ',' +
                " Titulo: " + getTitulo() + ',' +
                " unidadesDisponiblesCd: " + getUnidadesDisponibles()+ ',' +
                " Duración: " + getDuracion()  + ',' +
                " Género: " + getGenero() + ',' +
                " Artista: " + artista + ',' +
                " Número de canciones: " + numeroCanciones + ',';
    }

}


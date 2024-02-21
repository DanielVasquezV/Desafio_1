package sv.edu.udb.desafio1.material.audiovisual;

public class CdAudio extends MaterialAudioVisual {
    private String artista;
    private int numeroCanciones;

    //Constructor de la clase
    public CdAudio(String codigoIdentificacion, String titulo, int unidadesDisponibles, String duracion, String genero, String artista, int numeroCanciones){
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
}


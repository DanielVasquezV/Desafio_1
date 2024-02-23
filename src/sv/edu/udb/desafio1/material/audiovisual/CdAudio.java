package sv.edu.udb.desafio1.material.audiovisual;
import java.util.HashMap;


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

    public String toString() {
        return "CdAudio{" +
                "codigoIdentificacionCd='" + getCodigoIdentificacion() + '\'' +
                "tituloCd='" + getTitulo() + '\'' +
                ", unidadesDisponiblesCd=" + getUnidadesDisponibles() +
                ", duracionCd='" + getDuracion()  + '\'' +
                ", generoCd='" + getGenero() + '\'' +
                ", artistaCd=" + artista + '\'' +
                ", numeroCancionesCd=" + numeroCanciones + '\'' +
                '}';
    }

    public class CdMediateca{
         public HashMap<Integer, CdAudio> cdAudios;

         public CdMediateca(){
             this.cdAudios = new HashMap<>();
         }
         public void addCds(CdAudio cdAudio){
             cdAudios.put(cdAudios.size()+1, cdAudio);
         }
    }
}


package sv.edu.udb.desafio1.material.audiovisual;
import java.util.HashMap;

public class Dvd extends MaterialAudioVisual {
    private String director;

    //Constructor de la clase
    public Dvd(String codigoIdentificacion, String titulo, int unidadesDisponibles, String duracion, String genero, String director){
        super(codigoIdentificacion, titulo, unidadesDisponibles, duracion, genero);
        this.director = director;
    }

    //Setter y Getter
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String toString() {
        return "Dvd{" +
                "codigoIdentificacion='" + getCodigoIdentificacion() + '\'' +
                "titulo='" + getTitulo() + '\'' +
                ", unidadesDisponibles=" + getUnidadesDisponibles() + '\'' +
                ", duracion='" + getDuracion()  + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", director='" + director + '\'' +
                '}';
    }

    public class DvdMediateca{
        public HashMap<Integer, Dvd> dvds;
        public  DvdMediateca(){
            this.dvds = new HashMap<>();
        }
        public void addDvds(Dvd dvd ){
            dvds.put(dvds.size()+1, dvd);
        }
    }
}

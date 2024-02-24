    package sv.edu.udb.desafio1.material.audiovisual;


    public class Dvd extends MaterialAudioVisual {
        private String director;

        //Constructor de la clase
        public Dvd(String codigoIdentificacion, String titulo, String director, String duracion,  String genero, int unidadesDisponibles ){
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
            return
                    "codigoIndentificacionDvd: " + getCodigoIdentificacion() + ',' +
                    " tituloDvd: " + getTitulo() + ',' +
                    " unidadesDisponiblesDvd: " + getUnidadesDisponibles() + ',' +
                    " duracionDvd: " + getDuracion()  + ',' +
                    " géneroDvd: " + getGenero() + ',' +
                    " directorDvd: " + director ;
        }
    }


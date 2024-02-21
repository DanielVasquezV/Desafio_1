package sv.edu.udb.desafio1.material.escrito;
import javax.swing.*;
import java.util.HashMap;

public class Libro extends MaterialEscrito {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private String editorial;
    private String ISBN;
    private int anioPublicacion;
    private int unidadesDisponibles;

    public Libro(String titulo, String autor, int numeroPaginas, String editorial, String ISBN, int anioPublicacion,
                 int unidadesDisponibles){
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.anioPublicacion = anioPublicacion;
        this.unidadesDisponibles = unidadesDisponibles;
    }
     //seter y getter
     public String getTitulo() {
         return titulo;
     }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", editorial='" + editorial + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", anioPublicacion=" + anioPublicacion +
                ", unidadesDisponibles=" + unidadesDisponibles +
                '}';
    }

    class Mediateca {
        private HashMap<Integer, Libro> libros;

        public Mediateca(){
            this.libros = new HashMap<>();
        }
        public void addBooks(Libro libro){
            libros.put(libros.size() +1, libro);
            JOptionPane.showMessageDialog(null, "Libro agregado correctamente.");
        }
        }
    }
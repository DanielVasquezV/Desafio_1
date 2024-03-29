package sv.edu.udb.desafio1.material.escrito;

public class Libro extends MaterialEscrito {
    private String autor;
    private int numeroPaginas;
    private int ISBN;
    private int anioPublicacion;

    //Constructor de la clase
    public Libro(String codigoIdentificacion, String titulo, String autor, int numeroPaginas, String editorial, int ISBN, int anioPublicacion, int unidadesDisponibles){
        super(codigoIdentificacion, titulo, unidadesDisponibles, editorial);
        this.ISBN = ISBN;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.anioPublicacion = anioPublicacion;
    }

    //seter y getter
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

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }


    public String toString() {
        return
                "Código: " + getCodigoIdentificacion() + ',' +
                " titulo: " + getTitulo() + ',' +
                " autor: " + autor  +
                " numerPaginas: " + numeroPaginas + ',' +
                " editorial: " + getEditorial() + ',' +
                " ISBN: " + ISBN + ',' +
                " anioPublicación: " + anioPublicacion  + ',' +
                " unidadesDisponibles: " + getUnidadesDisponibles();
    }
}
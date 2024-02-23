package sv.edu.udb.desafio1;

import sv.edu.udb.desafio1.material.escrito.Libro;

import javax.swing.*;
import java.util.HashMap;

public  class Mediateca {
    public HashMap<String, Libro> libros;

    public Mediateca(){
        this.libros = new HashMap<>();
    }
    public void addBooks(Libro libro) {
        libros.put(libro.getCodigoIdentificacion(), libro);
    }
    public void removeBook(String codigoIdentificacion) {
        if (libros.containsKey(codigoIdentificacion)) {
            Libro libroBorrar = libros.remove(codigoIdentificacion);
            JOptionPane.showMessageDialog(null, "Libro eliminado correctamente:\n" + libroBorrar.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Libro con código " + codigoIdentificacion + " no encontrado.");
        }
    }

}

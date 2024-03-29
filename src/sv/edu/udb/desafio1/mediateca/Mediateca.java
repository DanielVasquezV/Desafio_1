package sv.edu.udb.desafio1.mediateca;
//import de package´s
import sv.edu.udb.desafio1.material.escrito.Libro;


//Librerias de java
import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public  class Mediateca {
    public HashMap<String, Libro> libros;

    public Mediateca(){
        this.libros = new HashMap<>();
    }
    public void addBooks(Libro libro) {
        libros.put(libro.getCodigoIdentificacion(), libro);
    }

    public void updateBooks(String codigoIdentificacion, Libro nuevoLibro) {
        if (libros.containsKey(codigoIdentificacion)) {
            libros.put(codigoIdentificacion, nuevoLibro);
            JOptionPane.showMessageDialog(null, "Libro actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El libro con código de identificación " + codigoIdentificacion + " no se encuentra en la mediateca.");
        }
    }

    public void removeBook(String codigoIdentificacion) {
        if (libros.containsKey(codigoIdentificacion)) {
            Libro libroBorrar = libros.remove(codigoIdentificacion);
            JOptionPane.showMessageDialog(null, "Libro eliminado correctamente:\n" + libroBorrar.toString());
            guardarLibroTxt("libros.txt");
        } else {
            JOptionPane.showMessageDialog(null, "Libro con código " + codigoIdentificacion + " no encontrado.");
        }
    }
    public void searchBook(String codigoIdentificacion){
        if (libros.containsKey(codigoIdentificacion)){
            JOptionPane.showMessageDialog(null, "Libro encontrado: "+libros.get(codigoIdentificacion));
        } else {
            JOptionPane.showMessageDialog(null, "Libro con código " + codigoIdentificacion + " no encontrado.");
        }
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay CDs en la mediateca.");
        } else {
            StringBuilder listaCds = new StringBuilder("Lista de CDs en la mediateca:\n");
            for (Libro lb : libros.values()) {
                listaCds.append(lb.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaCds.toString());
        }
    }

            public void guardarLibroTxt (String nombreArchivo){
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
                    for (Map.Entry<String, Libro> entry : libros.entrySet()) {
                        String linea = entry.getValue().toString();
                        writer.write(linea);
                        writer.newLine();
                    }
                    JOptionPane.showMessageDialog(null, "Datos guardados/actualizados correctamente en " + nombreArchivo);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar en el archivo: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }


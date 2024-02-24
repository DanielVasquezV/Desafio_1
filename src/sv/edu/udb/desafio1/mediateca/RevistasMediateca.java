package sv.edu.udb.desafio1.mediateca;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import sv.edu.udb.desafio1.material.audiovisual.Dvd;
import sv.edu.udb.desafio1.material.escrito.Revista;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class RevistasMediateca {
    public HashMap<String, Revista> revistas;

    public RevistasMediateca(){
        this.revistas = new HashMap<>();
    }
    public void addRevista(Revista revista ){
        revistas.put(revista.getCodigoIdentificacion(), revista);
    }
    public void removeRevista(String codigoIdentificacion) {
        if (revistas.containsKey(codigoIdentificacion)) {
            Revista revistaBorrar = revistas.remove(codigoIdentificacion);
            JOptionPane.showMessageDialog(null, "Revista eliminada correctamente:\n" + revistaBorrar.toString());
            guardarRevistaTxt("revistas.txt");
        } else {
            JOptionPane.showMessageDialog(null, "Revista con código " + codigoIdentificacion + " no encontrada");
        }
    }
    public void searchRevista(String codigoIdentificacion){
        if (revistas.containsKey(codigoIdentificacion)){
            JOptionPane.showMessageDialog(null, "Revista encontrada: "+revistas.get(codigoIdentificacion));
        } else {
            JOptionPane.showMessageDialog(null, "Revista con código " + codigoIdentificacion + " no encontrado.");
        }
    }

    public void guardarRevistaTxt(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Map.Entry<String, Revista> entry : revistas.entrySet()) {
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
package sv.edu.udb.desafio1.mediateca;
import sv.edu.udb.desafio1.material.audiovisual.Dvd;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DvdMediateca {
    public HashMap<String, Dvd> dvds;

    public DvdMediateca() {
        this.dvds = new HashMap<>();
    }

    public void addDvds(Dvd dvd) {
        dvds.put(dvd.getCodigoIdentificacion(), dvd);
    }

    public void updateDvd(String codigoIdentificacion, Dvd nuevoDvd){
        if (dvds.containsKey(codigoIdentificacion)) {
            dvds.put(codigoIdentificacion, nuevoDvd);
            JOptionPane.showMessageDialog(null, "Dvd actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Dvd con código de identificación " + codigoIdentificacion + " no se encuentra en la mediateca.");
        }
    }

    public void removeDvd(String codigoIdentificacion) {
        if (dvds.containsKey(codigoIdentificacion)) {
            Dvd dvdBorrar = dvds.remove(codigoIdentificacion);
            JOptionPane.showMessageDialog(null, "DVD eliminado correctamente:\n" + dvdBorrar.toString());
            guardarDvdTxt("DVDs.txt");
        } else {
            JOptionPane.showMessageDialog(null, "DVD con código " + codigoIdentificacion + " no encontrado.");
        }
    }
    public void searchDvd(String codigoIdentificacion){
        if (dvds.containsKey(codigoIdentificacion)){
            JOptionPane.showMessageDialog(null, "DVD encontrado: "+dvds.get(codigoIdentificacion));
        } else {
            JOptionPane.showMessageDialog(null, "DVD con código " + codigoIdentificacion + " no encontrado.");
        }
    }
    public void listarDvd() {
        if (dvds.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay CDs en la mediateca.");
        } else {
            StringBuilder listaCds = new StringBuilder("Lista de CDs en la mediateca:\n");
            for (Dvd dvd : dvds.values()) {
                listaCds.append(dvd.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaCds.toString());
        }
    }

    public void guardarDvdTxt(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Map.Entry<String, Dvd> entry : dvds.entrySet()) {
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

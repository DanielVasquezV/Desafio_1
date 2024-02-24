package sv.edu.udb.desafio1.mediateca;
import sv.edu.udb.desafio1.material.audiovisual.CdAudio;
import sv.edu.udb.desafio1.material.audiovisual.Dvd;
import sv.edu.udb.desafio1.material.escrito.Libro;

import javax.swing.*;
import java.util.HashMap;

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
}

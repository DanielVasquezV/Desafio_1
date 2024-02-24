package sv.edu.udb.desafio1.mediateca;
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
}

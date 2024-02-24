package sv.edu.udb.desafio1.mediateca;

import sv.edu.udb.desafio1.material.audiovisual.Dvd;
import sv.edu.udb.desafio1.material.escrito.Revista;

import javax.swing.*;
import java.util.HashMap;

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
}
package sv.edu.udb.desafio1.mediateca;
import sv.edu.udb.desafio1.material.audiovisual.CdAudio;
import sv.edu.udb.desafio1.material.audiovisual.Dvd;

import javax.swing.*;
import java.util.HashMap;


public class CdMediateca {
    public HashMap<String, CdAudio> cdAudios;

    public CdMediateca(){
        this.cdAudios = new HashMap<>();
    }
    public void addCds(CdAudio cdAudio){
        cdAudios.put(cdAudio.getCodigoIdentificacion(), cdAudio);
    }
    public void updateCd(String codigoIdentificacion, CdAudio nuevoCd){
        if (cdAudios.containsKey(codigoIdentificacion)) {
            cdAudios.put(codigoIdentificacion, nuevoCd);
            JOptionPane.showMessageDialog(null, "CD actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "CD con código de identificación " + codigoIdentificacion + " no se encuentra en la mediateca.");
        }
    }

    public void removeCd(String codigoIdentificacion) {
        if (cdAudios.containsKey(codigoIdentificacion)) {
            CdAudio cdBorrar = cdAudios.remove(codigoIdentificacion);
            JOptionPane.showMessageDialog(null, "CD eliminado correctamente:\n" + cdBorrar.toString());
        } else {
            JOptionPane.showMessageDialog(null, "CD con código " + codigoIdentificacion + " no encontrado.");
        }
    }
    public void searchCd(String codigoIdentificacion){
        if (cdAudios.containsKey(codigoIdentificacion)){
            JOptionPane.showMessageDialog(null, "CD encontrado: "+cdAudios.get(codigoIdentificacion));
        } else {
            JOptionPane.showMessageDialog(null, "CD con código " + codigoIdentificacion + " no encontrado.");
        }
    }
    public void listarCds() {
        if (cdAudios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay CDs en la mediateca.");
        } else {
            StringBuilder listaCds = new StringBuilder("Lista de CDs en la mediateca:\n");
            for (CdAudio cd : cdAudios.values()) {
                listaCds.append(cd.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, listaCds.toString());
        }
    }
}

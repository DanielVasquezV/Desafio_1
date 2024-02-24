package sv.edu.udb.desafio1.mediateca;
import sv.edu.udb.desafio1.material.audiovisual.CdAudio;

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
}

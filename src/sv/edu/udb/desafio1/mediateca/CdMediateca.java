package sv.edu.udb.desafio1.mediateca;
import sv.edu.udb.desafio1.material.audiovisual.CdAudio;
import sv.edu.udb.desafio1.material.escrito.Revista;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
            guardarCdTxt("CDs.txt");
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
    public void guardarCdTxt(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Map.Entry<String, CdAudio> entry : cdAudios.entrySet()) {
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

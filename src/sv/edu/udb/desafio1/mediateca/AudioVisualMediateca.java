package sv.edu.udb.desafio1.mediateca;

import sv.edu.udb.desafio1.material.audiovisual.MaterialAudioVisual;

import java.util.HashMap;

public class AudioVisualMediateca {
    public HashMap<Integer, MaterialAudioVisual> materialesAudiovisuales;

    public AudioVisualMediateca(){
        this.materialesAudiovisuales = new HashMap<>();
    }
    public void addMaterial(MaterialAudioVisual materialAudioVisual ){
        materialesAudiovisuales.put(materialesAudiovisuales.size()+1, materialAudioVisual);
    }
}

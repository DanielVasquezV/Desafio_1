package sv.edu.udb.desafio1;
import sv.edu.udb.desafio1.material.audiovisual.CdAudio;
import java.util.HashMap;


public class CdMediateca {
    public HashMap<Integer, CdAudio> cdAudios;

    public CdMediateca(){
        this.cdAudios = new HashMap<>();
    }
    public void addCds(CdAudio cdAudio){
        cdAudios.put(cdAudios.size()+1, cdAudio);
    }
}

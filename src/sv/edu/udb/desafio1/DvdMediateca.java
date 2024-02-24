package sv.edu.udb.desafio1;
import sv.edu.udb.desafio1.material.audiovisual.Dvd;

 import java.util.HashMap;

public class DvdMediateca {
    public HashMap<Integer, Dvd> dvds;

    public DvdMediateca() {
        this.dvds = new HashMap<>();
    }

    public void addDvds(Dvd dvd) {
        dvds.put(dvds.size() + 1, dvd);
    }
}

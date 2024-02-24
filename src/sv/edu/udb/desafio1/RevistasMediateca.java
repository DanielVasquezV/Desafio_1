package sv.edu.udb.desafio1;

import sv.edu.udb.desafio1.material.escrito.Revista;

import java.util.HashMap;

public class RevistasMediateca {
    public HashMap<Integer, Revista> revistas;

    public RevistasMediateca(){
        this.revistas = new HashMap<>();
    }
    public void addRevista(Revista revista ){
        revistas.put(revistas.size()+1, revista);
    }
}

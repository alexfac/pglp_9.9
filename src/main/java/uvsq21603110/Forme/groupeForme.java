package uvsq21603110.Forme;

import java.util.ArrayList;
import java.util.Collections;

public class groupeForme extends Forme{
    private ArrayList<Forme> listforme;

    public groupeForme(String nom){
        super(nom);
        listforme = new ArrayList<>();
    }

    public void addForme(Forme forme){
        this.listforme.add(forme);
    }

    public void move(double x, double y){
        for (Forme forme : this.listforme){
            forme.move(x,y);
        }
    }

    public void show(){
        for(Forme forme : this.listforme){
            forme.show();
        }
    }

    public ArrayList<Forme> GetList(){
        return (ArrayList<Forme>) Collections.unmodifiableList(this.listforme);
    }
}

package uvsq21603110.Command;

import uvsq21603110.Forme.Forme;

import java.awt.*;
import java.util.Scanner;
import uvsq21603110.Forme.*;
import uvsq21603110.Forme.Point;

public class DrawingTui {

    private Scanner scan;
    private groupeForme groupeForme;

    public DrawingTui() {
        this.groupeForme = new groupeForme("test");
        this.scan = new Scanner(System.in);
    }
    public Command nextCommand(){
        // POur test
        Carre c = new Carre("c", new Point(10,10), 10);
        this.groupeForme.addForme(c);
        //
        Command command = null;
        String in = this.scan.nextLine();
        try{
            if (in.contains("move")){
                String nForme = in.substring(in.indexOf("(") + 1, in.lastIndexOf(",("));
                double x = Double.parseDouble(in.substring(in.lastIndexOf("(")+1, in.lastIndexOf(',')));
                double y = Double.parseDouble(in.substring(in.lastIndexOf(",")+1, in.lastIndexOf("))")));
                for (Forme forme : groupeForme.getListforme()){
                    if (forme.getName().contains(nForme)){
                        forme.show();
                        command = new CommandMove(forme, x, y);
                    }
                }
            } else if (in.contains("quit")){
                command = new Commandquit();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return command;
    }

    public void show(){
        for (Forme forme : groupeForme.getListforme()){
            forme.show();
        }
    }
}

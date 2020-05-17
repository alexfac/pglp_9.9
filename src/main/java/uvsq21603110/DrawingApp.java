package uvsq21603110;

import uvsq21603110.Command.Command;
import uvsq21603110.Command.DrawingTui;

public class DrawingApp {


    public void run(){

        DrawingTui dt = new DrawingTui();
        Command command;
        System.out.println("EXEMPLE DE COMMANDE ");
        System.out.println(" c=carre((0,0),0) \n" +
                " t=triangle((0,0),(0,0),(0,0))\n " +
                "ce=cercle((0,0),0)\n " +
                "r=rectangle((0,0),10,10)");
        System.out.println(" delete(nomForme)");
        System.out.println(" move(nomForme,(1,1))");
        System.out.println(" moveall(1,1)");
        System.out.println(" quit");
        System.out.println("---------------------------------------------------");
        while (true){
            command = dt.nextCommand();
            try{
                command.execute();
                dt.show();
            } catch (Exception e){
                //System.out.println("Commande invalide");
            }
        }
    }
}

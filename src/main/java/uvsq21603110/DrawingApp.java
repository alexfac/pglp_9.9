package uvsq21603110;

import uvsq21603110.Command.Command;
import uvsq21603110.Command.DrawingTui;

public class DrawingApp {


    public void run(){

        DrawingTui dt = new DrawingTui();
        Command command;
        while (true){
            command = dt.nextCommand();
            try{
                command.execute();
                dt.show();
            } catch (Exception e){
                System.out.println(e);
            }
        }
    }
}

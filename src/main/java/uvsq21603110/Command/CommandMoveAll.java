package uvsq21603110.Command;

import uvsq21603110.Forme.groupeForme;

public class CommandMoveAll implements Command{

    private groupeForme gf;
    private double x;
    private double y;

    public CommandMoveAll(groupeForme gf, double x, double y){
        this.gf = gf;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        this.gf.move(x,y);
    }
}

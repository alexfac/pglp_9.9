package uvsq21603110.Command;

import static java.lang.System.exit;

public class Commandquit implements Command{

    public Commandquit(){}

    @Override
    public void execute() {
        exit(0);
    }
}

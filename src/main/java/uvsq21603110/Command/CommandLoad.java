package uvsq21603110.Command;

import uvsq21603110.DAO.DAOFactory;

public class CommandLoad implements Command{

    private String name;
    private DrawingTui dt;

    public CommandLoad(String name, DrawingTui dt){
        this.name = name;
        this.dt = dt;
    }

    @Override
    public void execute() {
        this.dt.setGroupeForme(DAOFactory.getDAOGroupe().find(this.name));
    }
}

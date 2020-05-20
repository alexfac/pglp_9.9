package uvsq21603110.Command;

import uvsq21603110.DAO.DAOFactory;
import uvsq21603110.Forme.groupeForme;

public class CommandSave implements Command{

    private groupeForme gf;

    public CommandSave(groupeForme gf){
        this.gf = gf;
    }

    @Override
    public void execute() {
        DAOFactory.getDAOGroupe().create(this.gf);
    }
}

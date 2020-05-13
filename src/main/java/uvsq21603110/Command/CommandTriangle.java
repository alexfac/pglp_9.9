package uvsq21603110.Command;

import uvsq21603110.Forme.Point;
import uvsq21603110.Forme.Triangle;
import uvsq21603110.Forme.groupeForme;

public class CommandTriangle extends CommandGroupe {

  private String name;
  private Point point;
  private Point point1;
  private Point point2;

  public CommandTriangle(groupeForme groupeForme, String name, Point point, Point point1, Point point2) {
    super(groupeForme);
    this.name = name;
    this.point = point;
    this.point1 = point1;
    this.point2 = point2;
  }

  @Override
  public void execute() {
    super.gf.addForme(new Triangle(name, point, point1, point2));
  }
}

package uvsq21603110.Forme;

public abstract class Forme {

  private String name;

  public Forme(String name) {
    this.name = name;
  }

  public abstract void move(double x, double y);

  public abstract void show();
}

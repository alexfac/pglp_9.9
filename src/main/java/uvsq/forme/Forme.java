package uvsq.forme;

public abstract class Forme {

  public String getName() {
    return name;
  }

  private String name;

  public Forme(String name) {
    this.name = name;
  }

  public abstract void move(double x, double y);

  public abstract void show();
}

package uvsq21603110.Forme;

import static org.junit.Assert.*;
import org.junit.Test;

public class FormeTest {
  @Test
  public void testRectangle() {
    Point p = new Point(1, 1);
    Rectangle r = new Rectangle("R1", p, 10, 5);
    r.show();
    r.move(1, 1);
    assertEquals(r.P.getX(), 2, 0);
    assertEquals(r.P.getY(), 2, 0);
    r.show();
  }
  @Test
  public void testCarre() {
    Point p = new Point(1, 1);
    Carre c = new Carre("R1", p, 10);
    c.show();
    c.move(1, 1);
    assertEquals(c.HG.getX(), 2, 0);
    assertEquals(c.HG.getY(), 2, 0);
    c.show();
  }
}

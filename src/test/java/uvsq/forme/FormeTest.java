package uvsq.forme;

import static org.junit.Assert.*;
import org.junit.Test;

public class FormeTest {
  @Test
  public void testRectangle() {
    Point p = new Point(1, 1);
    Rectangle r = new Rectangle("R1", p, 10, 5);
    r.show();
    r.move(1, 1);
    assertEquals(r.hg.getX(), 2, 0);
    assertEquals(r.hg.getY(), 2, 0);
    r.show();
  }

  @Test
  public void testCarre() {
    Point p = new Point(1, 1);
    Carre c = new Carre("R1", p, 10);
    c.show();
    c.move(1, 1);
    assertEquals(c.hg.getX(), 2, 0);
    assertEquals(c.hg.getY(), 2, 0);
    c.show();
  }

  @Test
  public void testCercle() {
    Point p = new Point(1, 1);
    Cercle c = new Cercle("c1", p, 10);
    c.show();
    c.move(1, 1);
    assertEquals(c.centre.getX(), 2, 0);
    assertEquals(c.centre.getY(), 2, 0);
    c.show();
  }

  @Test
  public void testTriangle() {
    Point p = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Point p3 = new Point(0, 0);
    Triangle t = new Triangle("t1", p, p2, p3);
    t.show();
    t.move(1, 1);
    assertEquals(t.p1.getX(), 2, 0);
    assertEquals(t.p1.getY(), 2, 0);
    assertEquals(t.p2.getX(), 3, 0);
    assertEquals(t.p2.getY(), 3, 0);
    assertEquals(t.p3.getX(), 1, 0);
    assertEquals(t.p3.getY(), 1, 0);
    t.show();
  }

  @Test
  public void testGroupe() {
    Groupeforme g = new Groupeforme("1");
    Point p = new Point(1, 1);
    Cercle c = new Cercle("c1", p, 10);
    p = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Point p3 = new Point(0, 0);
    Triangle t = new Triangle("t1", p, p2, p3);

    g.addForme(t);
    g.addForme(c);
    g.show();
    g.move(2, 2);
    g.show();
  }
}

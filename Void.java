import java.awt.*;

class Void implements Figure {

    public double perimeter() {
        return 0.0;
    }

    public double area() {
        return 0.0;
    }

    public Figure add(R2Point p) {
        Convex.KOL++;
        Convex.c = new R2Point(p.getX(), p.getY());
        return new Point(p);
    }

    public void draw(Graphics2D g)
    {

    }
}

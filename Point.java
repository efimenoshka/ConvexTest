import java.awt.*;

class Point implements Figure {

    private R2Point p;

    public Point(R2Point p) {
        this.p = p;
    }

    public double perimeter() {
        return 0.0;
    }

    public double area() {
        return 0.0;
    }

    public Figure add(R2Point q) {
        if (!R2Point.equal(p, q)) {
            Convex.KOL++;
            Convex.c = new R2Point((p.getX()+q.getX())/2, (p.getY()+q.getY())/2);
            return new Segment(p, q);
        }
        else return this;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(Color.RED);
        g.fillOval((int)p.getX(), (int)p.getY(), 5, 5);
    }

}
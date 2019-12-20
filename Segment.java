import java.awt.*;

class Segment implements Figure {
    private R2Point p, q;

    public Segment(R2Point p, R2Point q) {
        this.p = p;
        this.q = q;
    }

    public double perimeter() {
        return 2.0 * R2Point.dist(p, q);
    }

    public double area() {
        return 0.0;
    }

    public Figure add(R2Point r) {
        if (R2Point.isTriangle(p, q, r)) {
            Convex.KOL++;
            Convex.c = new R2Point((p.getX()+q.getX()+r.getX())/3, (p.getY()+q.getY()+r.getY())/3);
            return new Polygon(p, q, r);
        }
        if (q.inside(p, r)) {
            q = r;
            Convex.c = new R2Point((p.getX()-q.getX())/2, (p.getY()-q.getY())/2);
        }
        if (p.inside(r, q)) {
            p = r;
            Convex.c = new R2Point((p.getX()-q.getX())/2, (p.getY()-q.getY())/2);
        }
        return this;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawLine((int)p.getX(), (int)p.getY(), (int)q.getX(), (int)q.getY());
        g.setColor(Color.RED);
        g.fillOval((int)Convex.c.getX(), (int)Convex.c.getY(), 5, 5);
    }
}

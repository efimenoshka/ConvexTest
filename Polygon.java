import java.awt.*;

class Polygon extends Deq implements Figure {

    private double s, p;

    private void grow(R2Point a, R2Point b, R2Point t) {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Polygon(R2Point a, R2Point b, R2Point c) {
        pushFront(b);

        if (b.light(a, c)) {
            pushFront(a);
            pushBack(c);
        } else {
            pushFront(c);
            pushBack(a);
        }
        p = R2Point.dist(a, b) + R2Point.dist(b, c)
                + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }

    public double perimeter() {
        return p;
    }

    public double area() {
        return s;
    }

    public Figure add(R2Point t) {
        int i; int k=0;
// Ищем освещенные ребра, просматривая их одно за другим.
        for (i = length(); i > 0 && !t.light(back(), front()); i--) {
            pushBack(popFront());
        }
// УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
// либо освещенных ребер нет совсем.
        if (i > 0) {
            R2Point x;
            grow(back(), front(), t);
// Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront()) {
                Convex.c = new R2Point((Convex.c.getX()*Convex.KOL-x.getX())/--Convex.KOL,(Convex.c.getY()*++Convex.KOL-x.getY())/--Convex.KOL);
                grow(x, front(), t);
            }
            pushFront(x);
// Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack()){
                Convex.c = new R2Point((Convex.c.getX()*Convex.KOL-x.getX())/--Convex.KOL,(Convex.c.getY()*++Convex.KOL-x.getY())/--Convex.KOL);
                grow(back(), x, t);
            }
            pushBack(x);
// Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            Convex.c = new R2Point((Convex.c.getX()*Convex.KOL+t.getX())/++Convex.KOL,(Convex.c.getY()*--Convex.KOL+t.getY())/++Convex.KOL);
            pushFront(t);
        }
        return this;
    }

    public void draw(Graphics2D g) {
        for (int i=0; i < length(); i++)
        {
            g.drawLine((int)front().getX(), (int)front().getY(), (int)back().getX(), (int)back().getY());
            pushBack(popFront());
        }
        g.setColor(Color.RED);
        g.fillOval((int)Convex.c.getX(), (int)Convex.c.getY(), 5, 5);
    }
}
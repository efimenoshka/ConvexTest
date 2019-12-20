import java.awt.*;

class Convex {
    private Figure fig;

    public static R2Point c = new R2Point(0,0);
    public static int KOL = 0;

    public Convex() {
        fig = new Void();
    }

    public void add(R2Point p) {
        fig = fig.add(p);
    }

    public double area() {
        return fig.area();
    }

    public double perimeter() {
        return fig.perimeter();
    }

    public void draw(Graphics2D g) {
        fig.draw(g);
    }


}
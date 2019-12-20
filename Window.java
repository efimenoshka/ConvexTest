import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Convex convex;
    public Window (Convex c){
        convex = c;
        setSize (1000,1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g2){

        Graphics2D g = (Graphics2D) g2;
        g.setColor(Color.WHITE);
        g.clearRect(0,0, getWidth(),getHeight());

        g.translate(getWidth()/2,getHeight()/2);
        g.setColor(Color.BLACK);
        g.drawLine(-getWidth()/2,0,getWidth()/2,0);
        g.drawLine(0,-getHeight()/2,0,getHeight()/2);
        convex.draw(g);
    }

    public void paint() {
        paint(getGraphics());
    }







}

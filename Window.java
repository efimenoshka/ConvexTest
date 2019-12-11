import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window (){
        this.setSize (1000,1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g){

        g.setColor(Color.WHITE);
        g.clearRect(0,0, getWidth(),getHeight());

        //super.paintComponents(g);

        g.setColor(new Color (0, 0, 0, 254));
        g.translate(getWidth()/2,getHeight()/2);

        g.drawLine(0-getWidth()/2,0,getWidth()/2,0);
        g.drawLine(0,0-getHeight()/2,0,getHeight()/2);


    }








}

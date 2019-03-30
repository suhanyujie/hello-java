package deskBall;

import javax.swing.*;
import java.awt.*;

public class BallGame extends JFrame {

    Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
    Image desk = Toolkit.getDefaultToolkit().getImage("images/table.jpg");
    double x1 = 100;
    double y1 = 100;
    boolean right = true;

    public void paint(Graphics g){
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x1,(int)y1,null);
        if (right) {
            x1 = x1 + 10;
        } else {
            x1 = x1 - 10;
        }
        if (x1 > 856-40-30) {
            right = false;
        }
        if (x1 < 40) {
            right = true;
        }
    }

    public void launchFrame (){
        setSize(856,500);
        setLocation(50,50);
        setVisible(true);
        while (true) {
            repaint();
            try {
                Thread.sleep(40);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(){
        System.out.println("this is samuel");
        BallGame game = new BallGame();
        game.launchFrame();
    }
}

package JAVA.personal.otherprojects.perlinnoise;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class move extends JPanel {
    BufferedImage img;
    Timer timer;
    int size=200;
    int scale=20;
    int ox=0;
    int oy=0;

    public move(){
        timer=new Timer(16, e -> {
            makeimg();
            repaint();
        });
        timer.start();
    }
    public void makeimg(){
        img=new BufferedImage(size,size,BufferedImage.TYPE_INT_RGB);
        double[][] a=perlinnoise.map(ox,oy,scale,size,1234);
        for (int x=0;x<size;x++){
            for (int y=0;y<size;y++){
                double n=a[x][y];
                img.setRGB(x,y,perlinnoise.colortone(n));
            }
        }
        ox+=1;
        oy+=1;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My Game :D");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new move());
            frame.setSize(600, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
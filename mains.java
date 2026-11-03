package JAVA.personal.otherprojects.perlinnoise;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

public class mains {
    public static void main()throws IOException{
        int size=200;
        int scale=20;
        BufferedImage img=new BufferedImage(size,size,BufferedImage.TYPE_INT_RGB);
        double[][] a=perlinnoise.map(scale,size,1234);
        for (int x=0;x<size;x++){
            for (int y=0;y<size;y++){
                double n=a[x][y];
                int grey=(int)(128+n*127);
                grey = Math.max(0, Math.min(255, grey));
                int rgb = (grey << 16) | (grey << 8) | grey;
                img.setRGB(x, y, rgb);
            }
        }
        ImageIO.write(img,"png",new File("heightmap.png"));
        System.out.println("Heightmap generated!");
    }
}

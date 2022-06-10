import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
    int width, height;
    BufferedImage bi;
    Graphics2D ig2;

    public Image(int w, int h) {
        width = w; height = h;

        bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        ig2 = bi.createGraphics();
    }

    public void drawDot(int x, int y, double c) {
        ig2.setBackground(Color.white);
        Color color = Color.RED;

        if (c >= 1) {color = Color.GREEN;}
        if (c >= 2) {color = Color.BLUE;}

        ig2.setColor(color);
        ig2.fillOval(x - 3, y - 3, 6, 6);
    }

    public void save(String fp) throws IOException {
        ImageIO.write(bi, "png", new File(fp));
    }
}

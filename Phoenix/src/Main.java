import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Image wi = new Image(500, 500);

        SpiralData sd = new SpiralData(500, 3);

        for (int i = 0; i < sd.X.m.length; i ++) {
            int x = (int) ((sd.X.m[i][0]) * 250) + 250;
            int y = (int) ((sd.X.m[i][1]) * 250) + 250;
            double c = sd.y.v[i];
            wi.drawDot(x, y, c);
        }
        wi.save("C:\\Git\\Phoenix\\out.png");
    }
}

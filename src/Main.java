import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        SpiralData sd = new SpiralData(100, 3);
        LayerDense dense1 = new LayerDense(2, 3);

        Utils.Vector inputs = new Utils.Vector(5);
        inputs.v = new double[]{0, 2, -1, 3.3, 0};

        Utils.Vector output = Activation.ReLU.forward(inputs);
        System.out.println(Arrays.toString(output.v));

        dense1.forward(sd.X);
    }
}

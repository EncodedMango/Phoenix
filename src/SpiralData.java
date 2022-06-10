import java.util.Random;

public class SpiralData {
    Matrix X;
    Vector y;

    public SpiralData(int samples, int classes) {
        X = new Matrix(2, samples * classes);
        y = new Vector(samples * classes);

        for (int class_number = 0; class_number < classes; class_number ++) {
            Range ix = new Range(samples * class_number, samples * (class_number + 1));
            Vector r = new Linspace(0.0, 1, samples).n;
            Vector t = new Linspace(class_number * 4, (class_number + 1) * 4, samples).n.addVector(getGaussian(samples).mulDouble(0.2));
            Matrix c = Concat(r.mulVector(t.mulDouble((2.5)).sin()), r.mulVector(t.mulDouble((2.5)).cos()));
            if (samples >= 0) System.arraycopy(c.m, 0, X.m, ix.min, samples);
            for (int i = 0; i < samples; i ++) {
                y.v[i + ix.min] = class_number;
            }
        }
    }

    public Matrix Concat(Vector a, Vector b) {
        Matrix n = new Matrix(2, a.v.length);
        for (int i = 0; i < a.v.length; i ++) {
            n.m[i] = new double[]{a.v[i], b.v[i]};
        }
        return n;
    }

    public Vector getGaussian(int samples) {
        Vector v = new Vector(samples);
        for (int i = 0; i < samples; i ++) {
            double r = new Random().nextGaussian();
            v.v[i] = r;
        }
        return v;
    }
}

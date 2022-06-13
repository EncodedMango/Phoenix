import java.util.Random;

class Linspace {
    private double current;
    private final double end;
    private final double step;
    Utils.Vector n;
    public Linspace(double start, double end, int samples) {
        this.current = start;
        this.end = end;
        this.step = (end - start) / samples;

        n = new Utils.Vector(samples);
        for (int i = 0; i < samples; i ++) {
            if (hasNext()) {n.v[i] = getNextFloat();}
        }
    }

    public boolean hasNext() {
        return current < (end + step / 2); //MAY stop floating point error
    }
    public double getNextFloat() {
        current += step;
        return current;
    }
}

public class SpiralData {
    Utils.Matrix X;
    Utils.Vector y;

    public SpiralData(int samples, int classes) {
        X = new Utils.Matrix(0, 2);
        y = new Utils.Vector(samples * classes);

        for (int class_number = 0; class_number < classes; class_number ++) {
            Utils.Range ix = new Utils.Range(samples * class_number, samples * (class_number + 1));
            Utils.Vector r = new Linspace(0.0, 1, samples).n;
            Utils.Vector t = new Linspace(class_number * 4, (class_number + 1) * 4, samples).n.addVector(getGaussian(samples).mulDouble(0.2));
            Utils.Matrix c = Concat(r.mulVector(t.mulDouble((2.5)).sin()), r.mulVector(t.mulDouble((2.5)).cos()));

            for (int i = 0; i < samples; i ++) {
                X.insertRow(c.m[i]);
                y.v[i + ix.min] = class_number;
            }
        }
    }

    public Utils.Matrix Concat(Utils.Vector a, Utils.Vector b) {
        Utils.Matrix n = new Utils.Matrix(a.v.length, 2);
        for (int i = 0; i < a.v.length; i ++) {
            n.m[i] = new double[]{a.v[i], b.v[i]};
        }
        return n;
    }

    public Utils.Vector getGaussian(int samples) {
        Utils.Vector v = new Utils.Vector(samples);
        for (int i = 0; i < samples; i ++) {
            double r = new Random().nextGaussian();
            v.v[i] = r;
        }
        return v;
    }
}

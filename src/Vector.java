public class Vector {
    double[] v;

    public void setElement(Range range, double element) {
        for (int i = range.min; i < range.max; i ++) {
            v[i] = element;
        }
    }

    public Vector sin() {
        Vector a = new Vector(v.length);
        for (int i = 0; i < v.length; i ++) {
            a.v[i] = Math.sin(v[i]);
        }
        return a;
    }

    public Vector cos() {
        Vector a = new Vector(v.length);
        for (int i = 0; i < v.length; i ++) {
            a.v[i] = Math.cos(v[i]);
        }
        return a;
    }

    public Vector addVector(Vector other) {
        Vector a = new Vector(v.length);
        for (int i = 0; i < v.length; i ++) {
            a.v[i] = v[i] + other.v[i];
        }
        return a;
    }

    public Vector mulVector(Vector other) {
        Vector a = new Vector(v.length);
        for (int i = 0; i < v.length; i ++) {
            a.v[i] = v[i] * other.v[i];
        }
        return a;
    }

    public Vector mulDouble(double other) {
        Vector a = new Vector(v.length);
        for (int i = 0; i < v.length; i ++) {
            a.v[i] = v[i] * other;
        }
        return a;
    }

    public Vector(int s) {
        v = new double[s];

        for (int i = 0; i < s; i ++) {
            v[i] = 0f;
        }
    }
}

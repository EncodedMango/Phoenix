public class Linspace {
    private double current;
    private final double end;
    private final double step;
    Vector n;
    public Linspace(double start, double end, int samples) {
        this.current = start;
        this.end = end;
        this.step = (end - start) / samples;

        n = new Vector(samples);
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

public class LayerDense {
    Utils.Matrix weights;
    Utils.Matrix biases;

    Utils.Matrix output;

    public LayerDense(int inputs, int neurons) {
        weights = new Utils.Matrix(inputs, neurons);
        biases = new Utils.Matrix(1, neurons);
        weights.randomize();
    }

    public void forward(Utils.Matrix inputs) {
        output = inputs.dot(weights).add(biases);
    }
}

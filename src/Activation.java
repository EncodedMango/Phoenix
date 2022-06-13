public class Activation {
    static class ReLU {
        public static Utils.Vector forward(Utils.Vector input) {
            Utils.Vector output = new Utils.Vector(input.v.length);
            for (int i = 0; i < output.v.length; i ++) {
                if (input.v[i] < 0) {
                    output.v[i] = 0;
                } else {
                    output.v[i] = input.v[i];
                }
            }
            return output;
        }
    }
}

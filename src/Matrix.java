public class Matrix {
    int rows;
    int columns;
    double[][] m;

    public void print() {
        for (double[] doubles : m) { //this equals to the row in our matrix.
            for (double aDouble : doubles) { //this equals to the column in each row.
                System.out.print(aDouble + " ");
            }
            System.out.println(); //change line on console as row comes to end in the matrix.
        }
    }

    public Matrix(int r, int c) {
        rows = r;
        columns = c;
        m = new double[c][r];

        for (int i = 0; i < r; i ++) {
            for (int j = 0; j < c; c ++) {
                m[j][i] = 0f;
            }
        }
    }


}

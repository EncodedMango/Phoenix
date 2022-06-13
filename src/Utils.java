import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Utils {
    public static class Matrix {
        int rows;
        int columns;

        double[][] m;

        public void print() {
            for (double[] doubles : m) {
                for (double aDouble : doubles) {
                    System.out.print(aDouble + " ");
                }
                System.out.println();
            }
        }

        public Matrix add(Matrix other) {
            Matrix mat = new Matrix(rows, columns);
            mat.m = m;

            if (other.columns == rows) {
                for (int i = 0; i < columns; i ++) {
                    for (int j = 0; j < rows; j ++) {
                        mat.m[j][i] += other.m[j][i];
                    }
                }
            }
            return mat;
        }

        public Matrix dot(Matrix other) {
            Matrix mat = new Matrix(rows, other.columns);

            if(columns != other.rows){
                System.out.println("Matrices cannot be multiplied");
                System.out.print("m: ");
                System.out.print(rows);
                System.out.print(" ");
                System.out.println(columns);
                System.out.print("other.m: ");
                System.out.print(other.rows);
                System.out.print(" ");
                System.out.println(other.columns);
            } else {
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < other.columns; j++) {
                        for (int k = 0; k < other.rows; k++) {
                            mat.m[i][j] += m[i][k] * other.m[k][j];
                        }
                    }
                }
            }
            return mat;
        }

        public void insertRow(double[] row) {
            Matrix mat = new Matrix(rows + 1, columns);
            if (rows >= 0) System.arraycopy(m, 0, mat.m, 0, rows);
            mat.m[rows] = row;
            m = mat.m;
            rows ++;
        }

        public void randomize() {
            for (int i = 0; i < columns; i ++) {
                for (int j = 0; j < rows; j ++) {
                    m[j][i] = 0.01 * new Random().nextGaussian();
                }
            }
        }

        public Matrix(int r, int c) {
            rows = r;
            columns = c;

            m = new double[r][c];

            for (int i = 0; i < c; i ++) {
                for (int j = 0; j < r; j ++) {
                    m[j][i] = 0;
                }
            }
        }
    }

    public static class Vector {
        double[] v;

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

    public static class Range {
        int min;
        int max;

        public Range(int n, int m) {
            min = n;
            max = m;
        }
    }

    public static class Image {
        int width, height;
        BufferedImage bi;
        Graphics2D ig2;

        public Image(int w, int h) {
            width = w; height = h;

            bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            ig2 = bi.createGraphics();

            ig2.setColor(Color.WHITE);
            ig2.fillRect(0, 0, width, height);
        }

        public void drawDot(int x, int y, double c) {
            Color color = Color.RED;

            if (c >= 1) {color = Color.GREEN;}
            if (c >= 2) {color = Color.BLUE;}
            if (c >= 3) {color = Color.GRAY;}
            if (c >= 4) {color = Color.YELLOW;}
            if (c >= 5) {color = Color.CYAN;}
            if (c >= 6) {color = Color.MAGENTA;}

            ig2.setColor(color);
            ig2.fillOval(x - 3, y - 3, 6, 6);
        }

        public void drawSpiralData(SpiralData sd) {
            for (int i = 0; i < sd.X.m.length; i ++) {
                int x = (int) ((sd.X.m[i][0]) * (width / 2)) + (width / 2);
                int y = (int) ((sd.X.m[i][1]) * (height / 2)) + (height / 2);
                double c = sd.y.v[i];
                drawDot(x, y, c);
            }
        }

        public void save(String fp) throws IOException {
            ImageIO.write(bi, "png", new File(fp));
        }
    }
}

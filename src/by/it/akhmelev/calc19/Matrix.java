package by.it.akhmelev.calc19;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(String strValue) {
    }

    public Matrix(Matrix matrix) {
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "value=" + Arrays.toString(value) +
                '}';
    }
}

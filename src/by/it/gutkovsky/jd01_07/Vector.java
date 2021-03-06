package by.it.gutkovsky.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    Vector(String strVector) {
        //{1.0, 2.0, 3.0}
        String strVector1 = strVector.replace("{", "");
        String strVector2 = strVector1.replace("}", "");
        String[] strVectorArrayTemp = strVector2.split(",");
        double[] strVectorArray = new double[strVectorArrayTemp.length];

        for (int i = 0; i < strVectorArrayTemp.length; i++) {
            strVectorArray[i] = Double.parseDouble(strVectorArrayTemp[i].trim());
        }
        this.value = Arrays.copyOf(strVectorArray, strVectorArray.length);

    }

    @Override
    public String toString() {
        // вывод {1.0, 2.0, 4.0}

        if (value == null)
            return "null";
        int iMax = value.length - 1;
        if (iMax == -1)
            return "{}";

        StringBuilder b = new StringBuilder();
        b.append('{');
        for (int i = 0; ; i++) {
            b.append(value[i]);
            if (i == iMax) return b.append('}').toString();
            else b.append(", ");
        }

    }
}

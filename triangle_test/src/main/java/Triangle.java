import exception.ExceptionArgumentTriangle;

import java.text.DecimalFormat;

public class Triangle {


    public static void main(String[] args) throws ExceptionArgumentTriangle {


        System.out.println(areaTriangle(2, 4, 7));

    }

    public static double areaTriangle(int a, int b, int c) throws ExceptionArgumentTriangle {
        if (a + b < c || b + c < a || c + a < b) {
            throw new ExceptionArgumentTriangle("Одна из сторон аргемента больше сумму 2 других аргументов");
        }
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new ExceptionArgumentTriangle("Введите корректные данные");
        }

        double s = (double) (a + b + c) / 2;
        return Double.parseDouble(new DecimalFormat("#.######").format(Math.sqrt(s * (s - a) * (s - b) * (s - c))));
    }
}
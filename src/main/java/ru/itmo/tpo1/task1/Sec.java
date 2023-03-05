package ru.itmo.tpo1.task1;

/**
 * Class for calculating a sec(x) functions;
 * sec(x) = 1 / cos(x)
 */
public class Sec {

    /**
     * Calc sec(x)
     *
     * @param x arg
     * @return sec(x)
     */
    public static double sec(double x) {
        if (x % (Math.PI / 2) == 0 && x % Math.PI != 0)
            throw new IllegalArgumentException("x cannot be Pi/2, 3*Pi/2 etc.");

        double PI2 = Math.PI * 2;

        if (x >= 0) {
            while (x > PI2) {
                x -= PI2;
            }
        } else {
            while (x < PI2) {
                x += PI2;
            }
        }




        return 1.0 / calcCos(x);
    }

    /**
     * Calc cos(x)
     *
     * @param x arg
     * @return cos(x)
     */
    private static double calcCos(double x) {
        double result = 1;
        int countOfCalculating = 13;
        int sign = -1;
        for (int i = 1; i < countOfCalculating; i++) {
            result += sign * (Math.pow(x, 2 * i) / factorial(2 * i));
            sign *= -1;
        }
        return result;
    }

    /**
     * Calc a factorial
     *
     * @param i arg
     * @return factorial(i)
     */
    private static double factorial(int i) {
        long fact = 1;
        for (int j = 2; j <= i; j++) {
            fact = fact * j;
        }
        return fact;
    }
}

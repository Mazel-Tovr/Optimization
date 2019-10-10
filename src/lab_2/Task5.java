package lab_2;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.ThreadLocalRandom;

//Исследуйте точки перегиба функции f(x)=x4−14x3+60x2−70x.
public class Task5 {

    private static double secondDerivative(double x) {
        return 12 * Math.pow(x, 2) - 84 * x + 120;
    }

    private static void examineRange(int left, int right) {
        int randomX = ThreadLocalRandom.current().nextInt(left, right + 1);//Берем рандомное значение в приделах данной границы

        if (secondDerivative(randomX) > 0) {
            System.out.println("Функция вогнута");
        } else {
            System.out.println("Функция выпукла");
        }
    }

    public static void main(String[] args) {
        System.out.println("Исследование точек перегиба");
        System.out.println("Функция f(x)=x4−14x3+60x2−70x:");
        System.out.println("Вычисляем f''(x)=0, точки перегиба:");
        //Интервал
        int x1 = 2;
        int x2 = 5;
        System.out.println("x1=" + x1 + " x2=" + x2);

        System.out.println("В интервале от -Infinity : 2");
        examineRange(Integer.MIN_VALUE, 2);
        System.out.println("В интервале от 2 : 5");
        examineRange(2, 5);
        System.out.println("В интервале от 5 : +Infinity");
        examineRange(5, Integer.MAX_VALUE - 1);

    }

/*
    private double Function(double x) {
        return Math.pow(x, 4) - 14d * Math.pow(x, 3) + 60d * Math.pow(x, 2) - 70d * x;
    }

    protected double firstDerivative(double x) {
        return 4 * Math.pow(x, 3) - 42d * Math.pow(x, 2) + 120d * x - 70d;
    }

    protected double secondDerivative(double x) {
        return 12 * (Math.pow(x, 2) - 7 * x + 10);
    }

 */
}

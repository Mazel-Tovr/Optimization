package practice_2;

import javafx.scene.Scene;

import java.util.Scanner;

public class Cone
{
    public void Optimum()
    {
        Scanner scanner = new Scanner(System.in);
        //конус
        System.out.println("Высота конуса - ");
        double H = scanner.nextDouble();
        System.out.println("Радиус конуса - ");
        double R = scanner.nextDouble();
        //цилиндр
        double h = H/3;
        System.out.println("Высота цилиндр - " +h);
        double r = R*2 / 3;
        System.out.println("Радиус цилиндр - "+r);
        double OS = Math.PI * r * r * h;
        System.out.println("Объем цилиндра - "+OS);
        double OK = Math.PI * R * R * (H / 3);
        System.out.println("Объем конуса - "+OK);
        double N = OS / OK;
        System.out.println("Соотношение объемов - "+N);
    }
    public void NOptimum()
    {
        Scanner scanner = new Scanner(System.in);
        //конус
        System.out.println("Высота конуса - ");
        double H = scanner.nextDouble();
        System.out.println("Радиус конуса - ");
        double R = scanner.nextDouble();
        //цилиндр
        System.out.println("Радиус цилиндра - ");
        double r = scanner.nextDouble();
        double h = H / R * (R - r);
        System.out.println("Высота цилиндр - " + h);
        double OS = Math.PI * r * r * h;
        System.out.println("Объем цилиндра - " + OS);
        double OK = Math.PI * R * R * (H / 3);
        System.out.println("Объем конуса - " + OK);
        double N = OS / OK;
        System.out.println("Соотношение объемов - " + N);



    }
}

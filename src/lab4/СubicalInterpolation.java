package lab4;

import java.sql.SQLOutput;
import java.util.Scanner;

public class СubicalInterpolation
{

    double CC = 0;
    double GO = 0;
    double TT = 0;
    private double Z;
    double[] X;
    double[] P;
    double[] Q;
    double[] D;
    double[] G;
    int N;//Если ничего не будет работать то +1
    public void search()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число переменных");
         N = scanner.nextInt();
         X = new double[N+1];
         P = new double[N+1];
         Q = new double[N+1];
         D = new double[N+1];
         G = new double[N+1];
        System.out.println("Начальная точка");
        for (int i = 1; i <N+1 ; i++)
        {
            X[i] = scanner.nextDouble();
        }
        System.out.println("Направление D");
        for (int i = 1; i <N+1 ; i++)
        {
            D[i]= scanner.nextDouble();
        }
        System.out.println("Задайте точность Е");
        double E = scanner.nextDouble();
        System.out.println("Предпологаемое занчение минимум");
        double FM = scanner.nextDouble();
        System.out.println("Текущие Значение");
        for (int i = 1; i <N+1; i++)
        {
             P[i]=X[i];
            System.out.println("x\t"+i +"\t"+X[i]);
        }
        function5000();
        System.out.println("Итерация "+CC+ "Значение "+Z);
        double FP = Z;
        function6000();
        double G1 = GO;
        double GP = 0;
        for (int i = 0; i < N ; i++) {

        }

    }

    private void function5000()
    {
        Z=0;
        Z=100*Math.pow((X[2]-X[1]*X[1]),2);
        Z= Z +Math.pow((1-X[1]),2);
        TT = TT+1;
    }
    private void function6000()
    {
        GO = 0;
        G[1] = -400*X[1]*(X[2]-X[1]*X[1]);
        G[1] =G[1]-2*(1-X[1]);
        G[2] = 200*(X[2]-X[1]*X[1]);
        for (int i = 0; i < N; i++)
        {
            GO=GO+G[i]*G[i];
        }
        GO = Math.sqrt(GO);
    }
}

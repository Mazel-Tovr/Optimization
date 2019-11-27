package lab6;

import java.util.Scanner;

public class SteepestDescent
{




    void search()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Метод наискорейщего спуска");
        System.out.println("Функция Z=F(X1,X2,...,XN) вычисляется в строке 2000");
        System.out.println("Частные производные G(1),G(2),...G(N) Вычисляются в строке 3000");
        System.out.println("Введите число переменных");
        int N = in.nextInt() + 1;
        double[] X,Y,G,D = new double[N];
        double[] L,FF = new double[4];
    }
}

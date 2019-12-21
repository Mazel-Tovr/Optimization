using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7
{
    class Hooke_Jeeves
    {
        static int N;
        static double Z;
        static double[] X;

        void function2000()
        {
            // Z = Math.Pow(X[1] - 2, 2) + Math.Pow(X[2] - 5, 2) + Math.Pow(X[3] + 2, 4);
            if (X[1] >= 0 && X[2] >= 0 && X[1] + X[2] >= 4) //Как по учебнику тут нужно задать проверку 
            {
                Z = 3 * Math.Pow(X[1], 2) + 4 * X[1] * X[2] + 5 * Math.Pow(X[2], 2);
            }
            else
            {
                Z = int.MaxValue;
            }
        }
         
        public void search() 
        {
            Console.WriteLine("Метод Хука-Дживса");
            Console.WriteLine("Введите число переменных");
            N = int.Parse(Console.ReadLine()) + 1;
            X = new double[N];
            double [] B = new double[N];
            double[] Y = new double[N];
            double[] P = new double[N];  
            Console.WriteLine("Введите начальную точку x1,x2,...xn");
            for (int i = 1; i < N; i++)
            {
                X[i] = double.Parse(Console.ReadLine());
            } 
            Console.WriteLine("Введите длину шага");
            double H = double.Parse(Console.ReadLine());
            double K = H;
            double FE = 0;
            for (int i = 1; i < N; i++)
            {
                Y[i] = X[i];
                P[i] = X[i];
                B[i] = X[i];
            } 
            function2000();
            double FI = Z; 
            Console.WriteLine("Начальное значение функции: " + Z);
            for (int i = 1; i <N; i++)
            {
                Console.WriteLine(X[i]);
            }
            double PS = 0;
            double BS = 1;
            int J = 1;
            double FB = FI;
        l200: 
            X[J] = Y[J] + K;
            function2000();
            if (Z < FI) goto l280;
            X[J] = Y[J] - K;
            function2000();
            if (Z < FI) goto l280;
            X[J] = Y[J];
            goto l290;

        l280: 
            Y[J] = X[J];
        l290:
            function2000();
            FI = Z;
            Console.WriteLine("Исследующий поиск " + Z);
            for (int i = 1; i < N; i++)
            {
                Console.WriteLine(X[i]);
            }
            if (J + 1 == N) goto l360; 
            J = J + 1;
            goto l200;
        l360:
            if (FI<FB - 1e-8) goto l540;
            if (PS == 1 && BS == 0) goto l420;
            goto l490;
        l420:
            for (int i = 1; i < N; i++)
            {
                P[i] = B[i];
                Y[i] = B[i];
                X[i] = B[i];
            }
            function2000();
            BS = 1;
            PS = 0;
            FI = Z;
            FB = Z;
            Console.WriteLine("Замена базисной точки " + Z);
            for (int i = 1; i < N; i++)
            {
                Console.WriteLine(X[i]);
            }
            J = 1;
            goto l200;
        l490:
            K = K / 10;
            Console.WriteLine("Уменьшить длину шага");
            if(K< 1e-08) goto l700;
            J = 1;
            goto l200;
        l540:
            for (int i = 1; i < N; i++)
            {
                P[i] = 2 * Y[i] - B[i];
                B[i] = Y[i];
                X[i] = P[i];
                Y[i] = X[i];
            }
            function2000();
            FB = FI;
            PS = 1;
            BS = 0;
            FI = Z;
            Console.WriteLine("Поиск по образцу " + Z);
            for (int i = 1; i < N; i++)
            {
                Console.WriteLine(X[i]);
            }
            J = 1;
            goto l200;
        l700:
            Console.WriteLine("Минимум найден");
            for (int i = 1; i < N; i++)
            {
                Console.WriteLine("X" + i+"=" + P[i]);
            }
            Console.WriteLine("Минимум функции равен " + FB);
        }
    }
}  

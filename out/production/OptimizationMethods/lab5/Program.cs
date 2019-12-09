using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab5
{
    class Program
    {
        static void Main(string[] args)
        {
            nelderMeadMethod();
            Console.ReadKey();
        }


        static float[] X;
        static float Z;
        static int TEV = 0;
        static float[] F;


        static void nelderMeadMethod()
        {
            Console.WriteLine("Симплексный метод Нелдера-Мида");
            Console.WriteLine("Функция Z=F(X1,X2,...,XN) вычисляется в строке 5000");
            Console.WriteLine("Введите число переменных");
            int N = int.Parse(Console.ReadLine());
            Console.WriteLine("Начальное приближение");
            float[,] S = new float[N + 1, N];
            for (int J = 0; J < N; J++)
            {
                S[0, J] = float.Parse(Console.ReadLine());
            }
            Console.WriteLine("Введите длину шага");
            float K = float.Parse(Console.ReadLine());

            for (int i = 1; i < N + 1; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (j == i - 1)
                    {
                        S[i, j] = S[0, j] + K;
                        continue;
                    }
                    S[i, j] = S[0, j];
                }
            }
            Console.WriteLine("Введите Alfa,Beta,Gamma");
            float AL = float.Parse(Console.ReadLine());
            float BE = float.Parse(Console.ReadLine());
            float GA = float.Parse(Console.ReadLine());
            X = new float[N];
            float[] XH = new float[N];
            float[] XG = new float[N];
            float[] XL = new float[N];
            float[] XO = new float[N];
            float[] XR = new float[N];
            float[] XC = new float[N];
            float[] XE = new float[N];
            F = new float[N + 1];

            for (int i = 0; i < N + 1; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    X[j] = S[i, j];
                }
                function();
                F[i] = Z;
            }

            S620:
            int H = 0, L = 0;
            double FH = -1E+20, FL = 1E+20;
            for (int i = 0; i < N + 1; i++)
            {
                if (F[i] > FH)
                {
                    FH = F[i];
                    H = i;
                }
                if (F[i] < FL)
                {
                    FL = F[i];
                    L = i;
                }
            }

            double FG = -1E+20;
            int G = 0;
            for (int i = 0; i < N + 1; i++)
            {
                if (i == H)
                    continue;
                if (F[i] > FG)
                {
                    FG = F[i];
                    G = i;
                }
            }
            for (int j = 0; j < N; j++)
            {
                XO[j] = 0;
                for (int i = 0; i < N + 1; i++)
                {
                    if (i == H)
                        continue;
                    XO[j] = XO[j] + S[i, j];
                }

                XO[j] = XO[j] / N;
                XH[j] = S[H, j];
                XG[j] = S[G, j];
                XL[j] = S[L, j];
            }
            for (int j = 0; j < N; j++)
            {
                X[j] = XO[j];
            }
            function();
            float FO = Z;
            Console.WriteLine("Вычислите центр тяжести в строке 1120");

            for (int j = 0; j < N; j++)
            {
                XR[j] = XO[j] + AL * (XO[j] - XH[j]);
                X[j] = XR[j];
            }
            function();
            float FR = Z;
            Console.WriteLine("Выполните отражение в строке 1220" + Z);

            if (FR < FL)
                goto S1300;
            if (FR > FG)
                goto S1600;
            goto S1520;
            S1300:
            for (int j = 0; j < N; j++)
            {
                XE[j] = GA * XR[j] + (1 - GA) * XO[j];
                X[j] = XE[j];
            }
            function();
            float FE = Z;
            if (FE < FL)
                goto S1440;
            goto S1520;
            S1440:
            for (int j = 0; j < N; j++)
            {
                S[H, j] = XE[j];
            }
            F[H] = FE;
            Console.WriteLine("Выполните растяжение в строке 1480 " + Z);

            goto S2060;

            S1520:
            for (int j = 0; j < N; j++)
            {
                S[H, j] = XR[j];
            }
            F[H] = FR;
            Console.WriteLine("Выполните отражение в строке 1560");

            goto S2060;

            S1600:
            if (FR > FH)
                goto S1700;
            for (int j = 0; j < N; j++)
            {
                XH[j] = XR[j];
            }
            F[H] = FR;

            S1700:
            for (int j = 0; j < N; j++)
            {
                XC[j] = BE * XH[j] + (1 - BE) * XO[j];
                X[j] = XC[j];
            }
            function();
            float FC = Z;
            if (FC > FH)
                goto S1920;
            for (int j = 0; j < N; j++)
            {
                S[H, j] = XC[j];
            }
            F[H] = FC;
            Console.WriteLine("Выполните сжатие в строке 1880 " + Z);

            goto S2060;

            S1920:
            for (int i = 0; i < N + 1; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    S[i, j] = (S[i, j] + XL[j]) / 2;
                    X[j] = S[i, j];
                }
                function();
                F[i] = Z;
            }
            Console.WriteLine("Выполните редукцию в строке 2040");

            goto S2060;

            S2060:
            float S1 = 0, S2 = 0;
            for (int i = 0; i < F.Length; i++)
            {
                S1 = S1 + F[i];
                S2 = S2 + F[i] * F[i];
            }
            float SIG = S2 - S1 * S1 / F.Length;
            SIG = SIG / F.Length;
            if (SIG < 1E-10)
                goto S2220;
            else
                goto S620;
            S2220:
            Console.WriteLine("Минимум найден в точке ");
            for (int J = 0; J < N; J++)
            {
                Console.Write("X " + (J + 1) + " = " + XL[J]);
            }
            Console.WriteLine();
            Console.WriteLine("Значение минимума функции = " + F[L]);
            Console.WriteLine("Количество вычислений функции = " + TEV);
        }

        static void function()
        {
            TEV = TEV + 1;
            //  Z = (float)(Math.Pow(Math.Pow(X[0], 2) + X[1] - 11, 2) + Math.Pow(X[0] + Math.Pow(X[1], 2) - 7, 2));
              Z = (float)(Math.Pow(1 - X[1], 2) + 100 * Math.Pow(X[1] - Math.Pow(X[0], 2), 2));

            // TEV = TEV + 1;
            //Z = (float)(100 * Math.Pow(X[1] - Math.Pow(X[0], 2), 2) + Math.Pow(1 - X[0], 2));

            //TEV = TEV + 1;
            //Z = (float)(Math.Pow(Math.Pow(X[0], 2) + X[1] - 11, 2) + Math.Pow(X[0] + Math.Pow(X[1], 2) - 7, 2));

        }
    }
}

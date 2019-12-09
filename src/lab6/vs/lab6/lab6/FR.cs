
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using static System.Math;
using static System.Console;

namespace lab6
{
    class FR
    {

        int N,TV,SV,K;
        double[] X, Y, P, Q, D, G;
        double Z,GO,FP,G1,GK,GP,QX,HH,BB,GQ,G2,G3,FQ;
        void Search()
        {
            WriteLine("Минимизация методом Флетчера - Ривса");
            WriteLine("Введите число переменных");
            N = int.Parse(ReadLine())+1;
            X = new double[N];
            Y = new double[N];
            P = new double[N];
            Q = new double[N];
            D = new double[N];
            G = new double[N];
            WriteLine("Введите начальную точку");
            for (int i = 1; i < N; i++)
            {
                WriteLine($"X {i} ");
                X[i] = double.Parse(ReadLine());
            }
            SV = 1;TV = 0;
            WriteLine("Текущие значение ");
            for (int i = 1; i < N; i++)
            {
                P[i] = X[i];
                WriteLine($"X{i} = {X[i]}");
            }
            function5000();
            FP = Z;
            WriteLine($"Z = {Z}");
            function6000();
            G1 = GO;
            GK = GO;

            for (int i = 1; i < N; i++)
            {
                D[i] = -G[i];
            }
            K = 1;
    S600:   GP = 0;
            for (int i = 1; i < N; i++)
            {
                GP = GP + G[i] * D[i];
            }
            if (GP <= 0) goto S680;
            QX = Abs(2 * FP / GP);
            if (QX > 1) QX = 1;
            for (int i = 1; i < N; i++)
            {
                X[i] = P[i] - QX * D[i];
                P[i] = X[i];
            }
            function5000();
            FP = Z;
            WriteLine("Нестаблиьность?");
            function6000();
            G1 = GO;
            goto S600;
      S680: QX = Abs(2 * FP / GP);
            if (QX > 1) QX = 1;
            HH = QX;
      S700: BB = HH;
            for (int i = 1; i < N; i++)
            {
                Q[i] = P[i] - BB * D[i];
                X[i] = Q[i];
            }
            function5000();
            FQ = Z;
            function6000();
            G2 = GO;
            GQ = 0;
            for (int i = 1; i < N; i++)
            {
                GQ = GQ + G[i] * D[i];
            }
            if (GQ > 0 || FQ > FP) goto S860;
            HH = 2 * HH;
            for (int i = 1; i < N; i++)
            {

            }
        }

      void function5000()
        {
            Z = 100 * Pow((X[2] - X[1] * X[1]), 2);
            Z = Z + Pow(1 - X[1], 2);
            TV++;
        }
        void function6000()
        {
            GO = 0;
            G[1] = -400 * X[1] * (X[2] - X[1] * X[1]);
            G[1] = G[1] - 2 * (1 - X[1]);
            G[2] = 200 * (X[2] - X[1] * X[1]);
            for (int i = 1; i < N; i++)
            {
                GO = GO + G[i] * G[i];
            }
            GO = Sqrt(GO);
        }

    }
}
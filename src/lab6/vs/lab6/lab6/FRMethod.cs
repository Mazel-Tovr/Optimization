
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using static System.Math;
using static System.Console;

namespace lab6
{
    class FRMethod
    {
        static void Main(string[] args)
        {
    
            FRMethod l = new FRMethod();
            l.search();
            ReadLine();
        }

        int N,TV,SV,K,DV=0;
        double[] X, Y, P, Q, D, G;
        double Z, GO, FP, G1, GK, GP, QX, HH, BB, GQ, G2, G3, FQ, ZZ, WW, DD, GR, W, FR, AK;
        public void search()
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
    S550:
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
      S680:
            QX = Abs(2 * FP / GP);
            if (QX > 1) QX = 1;
            HH = QX;
      S710:
            BB = HH;
            for (int i = 1; i < N; i++)
            {
                Q[i] = P[i] + BB * D[i];
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
                P[i] = Q[i];
            }
            FP = FQ;
            GP = GQ;
            G1 = G2;
            goto S710;
     S860:
            ZZ = 3 * (FP - FQ) / HH;
            ZZ = ZZ + GP + GQ;
            WW = ZZ * ZZ - GP * GQ;
            if (WW < 0) WW = 0;
            W = Sqrt(WW);
            DD = HH * (1 - (GQ + W - ZZ) / (GQ - GP + 2 * W));
            for (int i = 1; i < N; i++)
            {
                X[i] = P[i] + DD * D[i];
            }
            function5000();
            FR = Z;
            function6000();
            G3 = GO;
            GR = 0;
            for (int i = 1; i < N; i++)
            {
                GR = GR + G[i] * D[i];
            }
            if (Z <= FP && Z <= FQ) goto S1100;
            if (GR > 0) goto S1020;
            HH = HH - DD;
            for (int i = 1; i < N; i++)
            {
                P[i] = X[i];
            }
            FP = Z;
            GP = GR;
            goto S860;
      S1020:
            HH = DD;
            for (int i = 1; i < N; i++)
            {
                Q[i] = X[i];
            }
            FQ = Z;
            GQ = GR;
            goto S860;
    S1100:
            if (G3 < 0.000001) goto S1300;
            if (K == N) goto S1250;
            K++;
            AK = G3 * G3 / (GK * GK);
            for (int i = 1; i < N; i++)
            {
                D[i] = -G[i] + AK * D[i];
                P[i] = X[i];
            }
            WriteLine($"Новое направление поиска {(DV+1)}");
            DV++;
            FP = Z;
            G1 = GO;
            GK = GO;
            for (int i = 1; i < N; i++)
            {
                WriteLine($"X{i} = {X[i]}");
            }
            WriteLine("Z = " + Z);
            goto S600;
   S1250:
            WriteLine("Restart");
            SV++;DV++;
            WriteLine($"Итерация {SV} поиска {DV}");
            goto S550;
            S1300:
            WriteLine("Минимум найден");
            for (int i = 1; i < N; i++)
            {
                WriteLine($"X{i} = {X[i]}");
            }
            WriteLine("Минимум функции равен "+Z);
            WriteLine("Количество вычислений функции равно" + TV);

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
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Console;
using static System.Math;

namespace lab6
{
    class Program
    {
        static void Main(string[] args)
        {
            Program l = new Program();
            l.search();
            ReadLine();
        }

        double Z;
        int TT = 0;
        double[] X, P, Q, R, D, G, U, V, Y, M;
        double GO;
        int N;
        void search()
        {
            WriteLine("Минимизация методом ДФП");

            WriteLine("Введите число переменных");

            N = int.Parse(ReadLine())+1;
            X = new double[N];
            P = new double[N];
            Q = new double[N];
            R = new double[N];
            D = new double[N];
            G = new double[N];
            U = new double[N];
            V = new double[N];
            Y = new double[N];
            M = new double[N];
            double[,] H = new double[N,N];
            double CC = 0;
            double GP, QX, HH, BB,ZZ,WW,W,DD,GR,KK,DK,WK,FP,G1, FQ,G2,GQ;
            for (int i = 1; i < N; i++)
            {
                for (int j = 1; j < N; j++)
                {
                    H[i, j] = 0;
                }
                H[i, i] = 1;
            }
            TT = 0;
            WriteLine("Введите начальную точку");
            for (int i = 1; i < N; i++)
            {
                WriteLine($"X {i} ");
                X[i] = double.Parse(ReadLine());

            }

            WriteLine("Текущие значение ");
    S400: for (int i = 1; i < N; i++)
            {
                P[i] = X[i];
                Y[i] = X[i];
                WriteLine($"X{i} = {X[i]}");
            }
            function5000();
            WriteLine($"Итерация {CC} Значение {Z}");
             FP = Z;
            function6000();
             G1 = GO;
            for (int i = 1; i < N; i++)
            {
                U[i] = G[i];
                D[i] = 0;
                for (int j = 1; j < N; j++)
                {
                    D[i] = D[i] - H[i, j] * G[j];
                }
            }
      S600: GP = 0;
            for (int i = 1; i < N; i++)
            {
                GP = GP + G[i] * D[i];
            }
            if (GP < 0) goto S680;
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
            for (int i = 1; i <N; i++)
            {
                Q[i] = P[i] + BB * D[i];
                X[i] = Q[i];
            }
            function5000();
            FQ = Z;
            function6000();
            G2 = GO;
            GQ = 0;//770
            for (int i = 1; i < N; i++)
            {
                GQ = GQ + G[i] * D[i];
            }
            if (GQ > 0 || FQ > FP) goto S830;
            HH = 2 * HH;
            goto S700;
      S830: ZZ = 3 * (FP - FQ) / HH;
            ZZ = ZZ + GP + GQ;
            WW = ZZ * ZZ - GP * GQ;
            if (WW < 0) WW = 0;
            W = Sqrt(WW);
            DD = HH * (1 - (GQ + W - ZZ)) / (GQ - GP + 2 * W);
            for (int i = 1; i < N; i++)
            {
                X[i] = P[i] + DD * D[i];//870
            }
            function5000();
            double FR = Z;
            function6000();
            double G3 = GO;
            GR = 0;
            for (int i = 1; i < N; i++)
            {
                GR = GR + G[i] * G[i] * D[i];
            }
            if (Z <= FP && Z <= FQ) goto S1100;
            if (GR > 0) goto S990;
            HH = HH - DD;
            for (int i = 1; i < N; i++)
            {
                P[i] = X[i];
            }
            FP = Z;
            GP = GR;
            G1 = GO;
            goto S830;
      S990: HH = DD;
            for (int i = 1; i < N; i++)
            {
                Q[i] = X[i];
            }
     S1100:
            KK = 0;
            WK = 0;
            DK = 0;
            for (int i = 1; i < N; i++)
            {
                U[i] = G[i] - U[i];
                V[i] = X[i] - Y[i];//1120
            }
            for (int i = 1; i < N; i++)
            {
                M[i] = 0;
                for (int j = 1; j < N; j++)
                {
                    M[i] = M[i] + H[i, j] * U[j];
                }
                KK = KK + M[i] * U[i];
                WK = WK + V[i] * U[i];
                DK = DK + V[i] * V[i];
            }
            if (KK == 0 || WK == 0) goto S1260;
            for (int i = 1; i < N; i++)
            {
                for (int j = 1; j < N; j++)
                {
                    H[i, j] = H[i, j] - M[i] * M[j] / KK + V[i] * V[j] / WK;
                }
            }
            S1260: CC = CC + 1;
            if (Sqrt(DK) < 0.00005 || G3 < 0.00001) goto S1300;
            else goto S400;
     S1300: WriteLine("Минимум найден");
            WriteLine($"Koличество итераций = {CC} Значение минимума = {Z}");
            for (int i = 1; i < N; i++)
            {
                WriteLine($"X{i} = {X[i]}");
            }
        }

        void function5000()
        {
            Z = 0;
            Z = Pow(X[1] + 10 * X[2],2) + 5 * Pow(X[3] - X[4], 2);
            Z = Z + Pow(X[2] - 2 * X[3], 4) + 10 * Pow(X[1] - X[4], 4);
            TT = TT+1;
        }
         void function6000()
        {
            GO = 0;
            G[1] = 2 * (X[1] + 10 * X[2]) + 40 * Pow(X[1] - X[4], 3);
            G[1] = 20 * (X[1] + 10 * X[2]) + 4 * Pow(X[2] - 2*X[3], 3);
            G[3] = 10 * (X[3] - X[4]) - 8 * Pow(X[2] - 2 * X[3], 3);
            G[4] = -10 * (X[3] - X[4]) - 40 * Pow(X[1] - X[4], 3);
            for (int i = 1; i < N; i++)
            {
                GO = GO + G[i] * G[i];
            }
            GO = Sqrt(GO);
        }

    }
}

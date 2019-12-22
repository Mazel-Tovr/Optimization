using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7
{
    class Box
    {
        static void Main(string[] args)
        {
            FAndM fAnd = new FAndM();
            Hooke_Jeeves hj = new Hooke_Jeeves();
            Box b = new Box();
            b.search();
            Console.ReadKey();
        }

        double[] X, Y, L, U, XC, XQ, XR, XH, F, G, IC, EC;
        double Z, PP, X1, F1, FM, A, FR, S1, S2, D, DM, SD;
        int M, N,K,FE, IM,EC1,IC1;

        double[] array = new double[]{ 0, 20, 0, 11, 0, 42 };
        void search()
        {
            FE = 0;
            Console.WriteLine("Введите количество ограничений");
            M = int.Parse(Console.ReadLine())+1;
            Console.WriteLine("Введите количество переменных");
            N = int.Parse(Console.ReadLine())+1;
            X = new double[N]; Y = new double[N]; L = new double[N]; U = new double[N]; XC = new double[N]; XQ = new double[N]; XR = new double[N]; XH = new double[N];
            K = 2 * N;
            PP = 0;
            double[,] C = new double[K,N];
            F = new double[K];G = new double[M];IC = new double[M];EC = new double[2 * N];
            Console.WriteLine("Введите начальное значения");
            for (int i = 1; i < N; i++)
            {
                X[i] = double.Parse(Console.ReadLine());
                C[1, i] = X[i];
                XC[i] = X[i];
            }

            for (int i = 1,k = 0, j = 1; i < N; i++)
            {
                //Read
                L[i] = array[k];
                U[i] = array[j];
                k = +2;
                j = +2;
            }

            Console.WriteLine("Введите X");
            X1 = double.Parse(Console.ReadLine());

        S640:
            int I = 1;
            function5000();
            F[1] = Z;
        S600:   
            I++;
            for (int j = 1; j < N; j++)
            {
                C[I, j] = L[j] + new Random().NextDouble() * (U[j] - L[j]);
                X[j] = C[I, j];
            }

            IM = 1;//
            function6000();
            if (IC1 == 1) goto S720;
            for (int i = 1; i < N; i++)
            {
                XC[i] = ((I - 1) * XC[i] + C[I, i]) / I;
            }
            goto S760;
        S720:
            for (int i = 1; i < N; i++)
            {
                C[I, i] = (C[I, i] + XC[i]) / 2;
                X[i] = C[I, i];
            }
            goto S640;
        S760:
            function5000();
            F[I] = Z;
            if (I < K) goto S600;
            //IN PORGRESS 
            for (int j = 1; j < K-1; j++)
            {
                for (int i = j+1; i < K -1; i++)//I mb bolbwaya
                {
                    if (F[j] <= F[i]) break;
                    F1 = F[j];
                    F[j] = F[i];
                    F[i] = F1;
                    for (int l = 1; l < N; l++)
                    {
                        Y[l] = C[j, l];
                        C[j, l] = C[i, l];
                        C[i, l] = Y[l];
                    }
                }
            }
            FM = F[1];

            Console.WriteLine("Первая точка");
            Console.WriteLine("Минимальное знафение = "+F[1]);
            Console.WriteLine("Минимальная точка");
            for (int l = 1; l < N; l++)
            {
                Console.WriteLine("X"+l+" "+C[1,l]);
            }
            Console.WriteLine("");
            A = 1.3;
   S1190:
            for (int l = 1; l < N; l++)//1200
            {
                XH[l] = C[K, l];
                XQ[l] = (K * XC[l] - XH[l]) / (K - 1);
            }

            for (int l = 1; l < N; l++)
            {
                XR[l] = (1 + A) * XQ[l] - A * XH[l];
                X[l] = XR[l];
            }
   S1490:
            IM = 0;
            function6000();

            if (EC1 == 0 && IC1 == 0) goto S2000;
            if (EC1 == 0) goto S1800;


            for (int j = 1; j < N; j++)
            {
                if (EC[j] == 1) XR[j] = L[j] + 0.00001;
                X[j] = XR[j];

                if (EC[j + N] == 1) XR[j] = U[j] - 0.00001;
                X[j] = XR[j];
            }
   S1800:
            if (IC1 == 0) goto S2000;
            for (int l = 1; l < N; l++)
            {
                XR[l] = (XR[l] + XQ[l]) / 2;
                X[l] = XR[l];
            }
            goto S1490;

   S2000:
            function5000();
            FR = Z;

            if (FR < F[K]) goto S2400;
            for (int l = 1; l < N; l++)
            {
                XR[l] = (XR[l] + XQ[l]) / 2;
                X[l] = XR[l];
            }
            goto S1490;
   S2400:
            F[K] = FR;
            for (int l = 1; l < N; l++)
            {
                XC[l] = K * XC[l] - C[K, l] + XR[l];
                XC[l] = XC[l] / K;
                C[K, l] = XR[l];
            }

            for (int j = 1; j < K-1; j++)
            {
                for (int i = j+1; i < K; i++)
                {
                    if (F[j] <= F[i]) break;
                    F1 = F[j];
                    F[j] = F[i];
                    F[i] = F1;
                    for (int l = 1; l < N; l++)
                    {
                        Y[l] = C[j, l];
                        C[j, l] = C[i, l];
                        C[i, l] = Y[l];
                    }
                }
            }

            if (F[1] < FM) PP = 1;

            if (PP == 0) goto S1190;

            S1 = 0;S2 = 0;

            for (int i = 1; i < K; i++)
            {
                S1 = S1 + F[i];
                S2 = S2 + F[i] * F[i];
            }
            SD = S2 - S1 * S1 / K;
            SD = SD / K;

            DM = 0;

            for (int i = 1; i < K-1; i++)
            {
                for (int j = i+1; j < K; j++)
                { 
                    D=0;
                    for (int l = 1; l < N; l++)
                    {
                        D = D + (C[i, l] - Math.Pow(C[j, l], 2));
                    }
                    D = Math.Sqrt(D);
                    if (D > DM) DM = 0;
                }
            }

            if (PP == 0) goto S3790;
            Console.WriteLine("Новая точка в строке 3500");
            Console.WriteLine("Минимальное значение = "+F[1]);
            Console.WriteLine("Точка минимума");

            for (int l = 1; l < N; l++)
            {
                Console.WriteLine("X"+l+" "+C[1,l]);
            }
            Console.WriteLine("");
            FM = F[1];
            PP = 0;
   S3790:
            if (SD > 0.000001 && DM > 0.0001) goto S1190;
            Console.WriteLine("Минимум найден");
            Console.WriteLine("Точка минимума");
            for (int l = 1; l < N; l++)
            {
                Console.WriteLine("X" + l + " " + C[1, l]);
            }
            Console.WriteLine("Минимум функции"+F[1]);
            Console.WriteLine("Количество вычислений функций"+ FE);

        }
        void function5000()
        {
            Z = -X[1] * X[2] * X[3] + 3300;
            FE++;
        }

        //Тут должна быть ху*ня с ЕС и IC
        void function6000()
        {
            for (int i = 1; i < 2*N; i++)
            {
                EC[i] = 0;
            }
            EC1 = 0;
            for (int i = 1; i < M; i++)
            {
                IC[i] = 0;
            }
            IC1 = 0;
            if (IM != 1)
            {
                for (int i = 1; i < N; i++)
                {
                    if (X[i] < L[i]) EC[i] = 1; EC1 = 1;
                    if (X[i] < U[i]) EC[N+i] = 1;EC1 = 1; //chego bleat?

                }
            }
            G[1] = X[1] + 2 * X[2] + 2 * X[3];
            if (G[1] > 72) IC[1] = 1;IC1 = 1;
        }
    }
}

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
            hj.search();
            Console.ReadKey();
        }

        double[] X, Y, L, U, XC, XQ, XR, XH,F,G,IC,EC;
        double Z, PP,X1;
        int M, N,K,FE, IM,EC1,IC1;

        void search()
        {
            FE = 0;
            Console.WriteLine("Введите количество ограничений");
            M = int.Parse(Console.ReadLine());
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

            for (int i = 1; i < N; i++)
            {
                //Read
                //L[i] U[i]
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

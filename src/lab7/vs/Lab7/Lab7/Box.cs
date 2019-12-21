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

        double[] X, Y, L, LK, XC, XQ, XR, XH,F,G,IC,EC;
        double  PP;
        int M, N,K;

        void search()
        {
            Console.WriteLine("Введите количество ограничений");
            M = int.Parse(Console.ReadLine());
            Console.WriteLine("Введите количество переменных");
            N = int.Parse(Console.ReadLine())+1;
            X = new double[N]; Y = new double[N]; L = new double[N]; LK = new double[N]; XC = new double[N]; XQ = new double[N]; XR = new double[N]; XH = new double[N];
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








        }

    }
}

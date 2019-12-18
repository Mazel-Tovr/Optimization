using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7
{
    class FAndM
    {

        double[] X, P, Y, U, G, CG, D, V, R, Q, M, C, IC;
        double[,] H;
        int M1, N, S;
        double T, B, R1, CC,KK,WK,DK, GO,FR,Z1,Z2,GR, Z, FP, G1, FF, GP,L,HH,FQ,G2,GQ,WW,ZZ,W,DD;

public void search()
        {
            Console.WriteLine("Введите количество переменных");
            N = int.Parse(Console.ReadLine()) + 1;
            Console.WriteLine("Введите количество ограничений");
            M1 = int.Parse(Console.ReadLine()) + 1;
            X = new double[N]; P = new double[N]; Y = new double[N]; U = new double[N]; G = new double[N]; CG = new double[N]; D = new double[N]; V = new double[N]; R = new double[N]; Q = new double[N]; M = new double[N]; C = new double[M1]; IC = new double[M1];
            H = new double[N,N];
            Console.WriteLine("Введите начальную точку");
            for (int i = 1; i < N; i++)
            {
                X[i] = double.Parse(Console.ReadLine());
            }
            S = 0;
            for (int i = 1; i < M1; i++)
            {
                function8000(i);
                if (C[i] < 0) S++;IC[i] = 1;//XZ
            }
            if (S > 0) Console.WriteLine("Первая точка не является допустимой ");
            T = 0;B = 0;R1 = 0;CC = 0;
            function6000();
            for (int i = 1; i < N; i++)
            {
                T = T - G[i] * CG[i];
                B = B + CG[i] * CG[i];
            }
            R1 = T / B;
            if (R1 < 0) R1 = 1;
  S410:     Console.WriteLine("R = "+R1);

            for (int i = 1; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    H[i, j] = 0;
                }
                H[i, i] = 1;
            }
            Console.WriteLine("Текущие значения");
    S500:
            for (int i = 1; i < N; i++)
            {
                P[i] = X[i];
                Y[i] = X[i];
                Console.WriteLine("X"+i +" "+X[i]);
            }
            for (int i = 1; i < M1; i++)
            {
                function8000(i);
            }
            function5000();

            Console.WriteLine("Итерация "+CC+" Значение "+Z);

            FP = Z;
            function6000();
            G1 = GO;
            FF = Z;
        S540:
            for (int i = 1; i < N; i++)
            {
                U[i] = G[i];
                D[i] = 0;
                for (int j = 0; j < N; j++)
                {
                    D[i] = D[i] - H[i, j] * G[j];
                }
            }

            GP = 0;
            for (int i = 1; i < N; i++)
            {
                GP = GP + G[i] * D[i];
            }
            if (GP > 0) Console.WriteLine("Функция возрастает");

            L = 2;
            for (int i = 1; i < N; i++)
            {
                X[i] = P[i] + L * D[i];
            }
S650:
            S = 0;

            for (int i = 1; i < M1; i++)
            {
                while (true)
                {
                    IC[i] = 0;
                    function8000(i);
                    if (C[i] > 0) break;
                    IC[i] = 1;
                    S++;
                    L = L / 1.05;
                    for (int j = 1; j < N; j++)
                    {
                        X[j] = P[j] + L * D[j];
                    }
                }

            }

            if (S > 0) goto S650;

            HH = L;
            for (int i = 1; i < N; i++)
            {
                Q[i] = P[i] + HH * D[i];
                X[i] = Q[i];
            }

            for (int i = 1; i < M1; i++)
            {
                function8000(i);
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
            if (GQ < 0 && FQ < FP)
            {
                //goto S1110;
             //goto 1125;
             //S1110:
                for (int i = 1; i < N; i++)
                {
                    for (int j = 0; j < N; j++)
                    {
                        H[i, j] = H[i, j] - D[i] * D[i] / GP;
                    }
                    P[i] = Q[i];
                    X[i] = P[i];
                    Y[i] = X[i];
                }
                FF = Z;
                FP = Z;
                G1 = GO;
                goto S540;
            }
 S1130:     //kbich enterpolaciya
            ZZ = 3 * (FP - FQ) / HH;
            ZZ = ZZ + GP + GQ;//XZ 1130
            WW = ZZ * ZZ - GP * GQ;
            if (WW < 0) WW = 0;
            W = Math.Sqrt(WW);
            DD = HH * (1 - (GQ + W - ZZ) / (GQ - GP + 2 * W));
            for (int i = 1; i < N; i++)
            {
                X[i] = P[i] + DD * D[i];
            }
            for (int i = 1; i < M1; i++)
            {
                function8000(i);
            }
            function5000();
            FR = Z;
            function6000();
            GR = 0;
            for (int i = 1; i < N; i++)
            {
                GR = GR + G[i] * D[i];
            }

            if (Z <= FP && Z <= FQ) goto S1400;
            if (GR > 0) goto S1290;
            HH = HH - DD;
            for (int i = 1; i < N; i++)
            {
                P[i] = X[i];
            }
            FP = Z;
            GP = GR;
            G1 = GO;
            goto S1130;

  S1290:
            HH = DD;
            for (int i = 1; i < N; i++)
            {
                Q[i] = X[i];
            }
            FQ = Z;
            GQ = GR;
            G2 = GO;
            goto S1130;

            S1400:
            KK = 0;
            WK = 0;
            DK = 0;

            for (int i = 1; i < N; i++)
            {
                U[i] = G[i] - U[i];
                V[i] = X[i] - Y[i];
            }
            for (int i = 1; i < N; i++)
            {
                M[i] = 0;
                for (int j = 0; j < N; j++)
                {
                    M[i] = M[i] + H[i, j] * U[j];
                }
                KK = KK + M[i] * U[i];
                WK = WK + V[i] * U[i];
            }
            if (KK == 0 || WK == 0) goto S1560;

            for (int i = 1; i < N; i++)
            {
                for (int j = 1; j < N; j++)
                {
                    H[i, j] = H[i, j] - M[i] * M[j] / KK + V[i] * V[j] / WK;
                }
            }
            S1560:
            CC++;
            if (Math.Abs((FF - Z) / FF) < 0.00001) goto S1600;

            FF = Z;
            goto S500;

            S1600:
            if (R1 * Z2 < 0.00001) goto S1800; //XZ MB Z2
            R1 = R1 / 10;
            goto S410;
            S1800:
            Console.WriteLine(" ");
            for (int i = 1; i < N; i++)
            {
                Console.WriteLine("X"+i +" = "+X[i]);
            }
            Console.WriteLine("F(X) = "+Z1);

        }


        void function8000(int i)
        {
            switch(i)
            {
                case 1:C[1] = X[3] * X[3] - X[1] * X[1] - X[2] * X[2]; break;
                case 2:C[2] = X[1] * X[1] + X[2] * X[2] + X[3] * X[3] - 4; break;
                case 3:C[3] = 5 - X[3]; break;
                case 4:C[4] = X[1]; break;
                case 5:C[5] = X[2]; break;
                case 6:C[6] = X[3]; break;
            }
        }
        void function6000()
        {
            double KA = X[1] - 1;
            double KB = X[1] - 2;
            double KC = X[1] - 3;
            G[1] = KA * KB + KB * KC + KC * KA;
            CG[1] = -(-2 * X[1] / (C[1] * C[1]) + 2 * X[1] / (C[2] * C[2]) + 1 / (C[4] * C[4]));
            G[1] = G[1] + R1 * CG[1];

            G[2] = 0;
            CG[2] = -(-2 * X[2] / (C[1] * C[1]) + 2 * X[2] / (C[2] * C[2]) + 1 / (C[5] * C[5]));
            G[2] = G[2] + R1 * CG[2];

            G[3] = 1;
            CG[3] = -(2 * X[3] / (C[1] * C[1]) + 2 * X[3] / (C[2] * C[2]) - 1 / (C[3] * C[3]));
            CG[3] = CG[3] - 1 / (C[6] * C[6]);
            G[3] = G[3] + R1 * CG[3];

            GO = 0;
            for (int i = 1; i < N; i++)
            {
                GO = GO + G[i] * G[i];
            }
            GO = Math.Sqrt(GO);
        }
        void function5000()
        {
             Z1 = (X[1] - 1) * (X[1] - 2) * (X[1] - 3) + X[3];
             Z2 = 0;
            for (int i = 1; i < M1; i++)
            {
                Z2 = Z2 + 1 / C[i];
            }
            Z = Z1 + R1 + Z2;
        }
    }
}

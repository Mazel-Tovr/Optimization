package lab6.dfp;

import java.util.Scanner;

public class DFP
{
    double Z;
    int TT = 0;
    double[] X, P, Q, R, D, G, U, V, Y, M;
    double GO;
    int N;


    public static void main(String[] args) {
            DFP dfp = new DFP();
            dfp.search();
    }


    public void search()
    {
        System.out.println("Минимизация методом ДФП \nВведите число переменных");
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        double FP, GP, QX, G1, HH, BB, FQ, G2, GQ, ZZ, WW, W, DD, FR, GR, G3, KK, DK, WK;
        int CC = 0;//CC-колво итераций
        X = new double[N];
        double[] P = new double[N], V = new double[N], Y = new double[N], M = new double[N], U = new double[N], Q = new double[N], D = new double[N]; G = new double[N];
        double[][] H = new double[N][N];
        System.out.println("Введите начальную точку");
        for (int i = 0; i < N; i++)
        {
            System.out.println("X"+i);
            X[i] = sc.nextDouble();
        }
        for (int i = 0; i < N; i++)
        {
            H[i][i] = 1;
        }
        do
        {
            for (int i = 0; i < N; i++)
            {
                P[i] = X[i]; Y[i] = X[i]; System.out.println("X"+(i + 1) +"\t"+X[i]);
            }

            function5000();
            System.out.println("Итерация "+CC+" Значение = "+Z); //420
            FP = Z; function6000(); G1 = GO;
            //Градиент запомнить в u и выбрать начальное значение d
            for (int i = 0; i < N; i++)
            {
                U[i] = G[i]; D[i] = 0;
                for (int j = 0; j < N; j++)
                {
                    D[i] = D[i] - H[i][j] * G[j];
                }
            }
            while (true)
            {
                GP = 0;
                for (int i = 0; i < N; i++) GP = GP + G[i] * D[i];//610
                if (GP < 0) break;
                // найти начальный шаг если необходимо
                // измеить направление спуска на противоположное
                QX = Math.abs(2 * FP / GP); if (QX > 1) QX = 1;
                for (int i = 0; i < N; i++)
                {
                    X[i] = P[i] - QX * D[i]; P[i] = X[i];
                }
                function5000(); FP = Z; System.out.println("Нестабильность?");
                function6000(); G1 = GO;
            }
            QX = Math.abs(2 * FP / GP); if (QX > 1) QX = 1;//680
            HH = QX;
            while (true)
            {
                //найти следующую точку Q
                BB = HH;
                for (int i = 0; i < N; i++)
                {
                    Q[i] = P[i] + BB * D[i]; X[i] = Q[i];
                }
                function5000(); FQ = Z;
                function6000(); G2 = GO;
                GQ = 0;
                for (int i = 0; i < N; i++) GQ = GQ + G[i] * D[i];
                if (GQ > 0 || FQ > FP) break; //goto 830
                HH = 2 * HH;
            }
            while (true)
            {
                ZZ = 3 * (FP - FQ) / HH; ZZ = ZZ + GP + GQ;//830
                WW = ZZ * ZZ - GP * GQ; if (WW < 0) WW = 0;
                W = Math.sqrt(WW);
                DD = HH * (1 - (GQ + W - ZZ) / (GQ - GP + 2 * W));
                for (int i = 0; i < N; i++) X[i] = P[i] + DD * D[i];//870
                function5000(); FR = Z;
                function6000(); G3 = GO;
                //найти градиент в новой точке
                GR = 0;
                for (int i = 0; i < N; i++) GR = GR + G[i] * D[i];//910
                if ((Z <= FP && Z <= FQ) || GR > 0) break; //goto 990
                HH = HH - DD;
                for (int i = 0; i < N; i++) P[i] = X[i];//970
                FP = Z; GP = GR; G1 = GO;
            }
            HH = DD;//990
            if (!(Z <= FP && Z <= FQ)) // if (Z<=FP && Z<=FQ) goto 1100
            {
                HH = DD;
                //обновить матрцу H
            }
            KK = 0; WK = 0; DK = 0;//1100
            for (int i = 0; i < N; i++)
            {
                U[i] = G[i] - U[i]; V[i] = X[i] - Y[i];
            }
            for (int i = 0; i < N; i++)
            {
                M[i] = 0;
                for (int j = 0; j < N; j++)
                {
                    M[i] = M[i] + H[i][j] * U[j];
                }
                KK = KK + M[i] * U[i]; WK = WK + V[i] * U[i];
                DK = DK + V[i] * V[i];
            }
            //1205
            if (!(KK == 0 || WK == 0))
            {
                for (int i = 0; i < N; i++)
                    for (int j = 0; j < N; j++)
                        H[i][j] = H[i][j] - M[i] * M[j] / KK + V[i] * V[j] / WK;
            }
            CC++;
            //проверка критерия завершения
        } while (!(Math.sqrt(DK) < 0.00005 || G3 < 0.00001));
        System.out.println("Минимум найден");
        System.out.println("Количество итераций="+CC+" Значение минимума= "+Z);
        for (int i = 0; i < N; i++)
            System.out.println("X"+(i + 1)+" = "+X[i]);
    }

    void function5000()
    {
        Z = 0;
        Z = Math.pow(X[0] + 10 * X[1],2) + 5 * Math.pow(X[2] - X[3], 2);
        Z = Z + Math.pow(X[1] - 2 * X[2], 4) + 10 * Math.pow(X[0] - X[3], 4);
        TT = TT+1;
    }
    void function6000()
    {
        GO = 0;
        G[0] = 2 * (X[0] + 10 * X[1]) + 40 * Math.pow(X[0] - X[3], 3);
        G[1] = 20 * (X[0] + 10 * X[1]) + 4 * Math.pow(X[1] - 2*X[2], 3);
        G[2] = 10 * (X[2] - X[3]) - 8 * Math.pow(X[1] - 2 * X[2], 3);
        G[3] = -10 * (X[2] - X[3]) - 40 * Math.pow(X[0] - X[3], 3);
        for (int i = 0; i < N; i++)
        {
            GO = GO + G[i] * G[i];
        }
        GO = Math.sqrt(GO);
    }
}

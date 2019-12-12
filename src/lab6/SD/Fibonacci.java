package lab6.SD;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci extends SubTaskAlgorithm {

    public Fibonacci(FunctionMethods func) {
        super(func);
    }

    @Override
    public double subTaskMethod(double a, double b, int n, int i) {
        int N = 0;
        int[] Fib = new int[2 * n + 1];
        Fib[0] = Fib[1] = 1;

        for (int j = 2; j <= 2 * n; j++)
            Fib[j] = Fib[j - 1] + Fib[j - 2];

        double X1, X2, F2, F4;
        int G = 0;
        double FN1 = 1, FN2 = 1, FN,
                F = (b - a) / SteepestDescent.EPS;

        while (FN1 < F)
        {
            FN = FN1 + FN2;
            FN1 = FN2;
            FN2 = FN;
            N++;
        }
        boolean bix;
        int ix = N & 1;
        if (ix == 1)
            bix = true;
        else
            bix = false;
        X1 = a + (double)Fib[N - 2] / Fib[N] * (b - a) - (bix ? -1 : 1) * SteepestDescent.EPS / Fib[N];
        X2 = a + (double)Fib[N - 1] / Fib[N] * (b - a) + (bix ? -1 : 1) * SteepestDescent.EPS / Fib[N];
        F2 = func.getPartOFFunction(X1, i);
        F4 = func.getPartOFFunction(X2, i);
        while (Math.abs(b - a) > SteepestDescent.EPS)
        {
            if (F2 >= F4)
            {
                ix = (N - G) & 1;
                if (ix == 1)
                    bix = true;
                else
                    bix = false;
                a = X1;
                X1 = X2;
                F2 = F4;
                X2 = a + (double)Fib[N - G - 1] / Fib[N - G] * (b - a) + (bix ? -1 : 1) * SteepestDescent.EPS / Fib[N - G];
                F4 = func.getPartOFFunction(X2, i);
            }
            else
            {
                ix = (N - G) & 1;
                if (ix == 1)
                    bix = true;
                else
                    bix = false;
                b = X2;
                X2 = X1;
                F4 = F2;
                X1 = a + (double)Fib[N - G - 2] / Fib[N - G] * (b - a) - (bix ? -1 : 1) * SteepestDescent.EPS / Fib[N - G];
                F2 = func.getPartOFFunction(X1, i);
            }
            G++;
        }
        return (a + b) / 2;
    }
}

package lab6.SD;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GoldenSection extends SubTaskAlgorithm {

    public GoldenSection(FunctionMethods func) {
        super(func);
    }

    @Override
    public List<Double> minimize(List<Double> x, double a, double b, int n) {
        List<Double> Result = new ArrayList<>();
        for (int i = 0; i < x.size(); i++)
            Result.add(subTaskMethod(a, b, n, i));
        return Result;
    }

    @Override
    public double subTaskMethod(double A, double B, int n, int i) {
        double T1, T2, X;
        T1 = 0.3819660113;
        T2 = 1 - T1;
        double X0, X1, X2, X3;
        X0 = A; X1 = A + T1 * (B - A);
        X2 = A + T2 * (B - A); X3 = B;
        X = X1;
        double F1, F2, I;
        F1 = func.getPartOFFunction(X, i);
        X = X2; F2 = func.getPartOFFunction(X, i);
        do
        {
            if (F1 < F2)
            {
                I = X2 - X0; X3 = X2; X2 = X1; X1 = X0 + T1 * I;
                F2 = F1; X = X1; F1 = func.getPartOFFunction(X, i);
            }
            else
            {
                I = X3 - X1; X0 = X1; X1 = X2; X2 = X0 + T2 * I;
                F1 = F2; X = X2; F2 = func.getPartOFFunction(X, i);
            }
        } while (I > 0.001);
        return X1;
    }
}

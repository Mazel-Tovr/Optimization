package lab6.SD;

import java.util.ArrayList;
import java.util.List;

public class SteepestDescent
{
    private static final int NUMBER_OF_ITERATIONS = 100000;
    private static double EPS = 1e-5;

    private static FunctionMethods func = new F1(){};

    private static List<Double> goldenSection(List<Double> x, double a, double b)
    {
        List<Double> Result = new ArrayList<>();
        for (int i = 0; i < x.size(); i++)
            Result.add(calculateGS(a, b, i));
        return Result;
    }

    private static double calculateGS(double A, double B, int i)
    {
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

//    private static List<Double> GradientF(List<Double> x) {
//        List<Double> tmp = new ArrayList<>() {};
//        tmp.add(2 * (x.get(0) - 1));
//        tmp.add(2 * (x.get(1) - 3));
//        tmp.add(8 + (x.get(2) + 5));
//        return tmp;
//    }

    private static List<Double> GradientDescent(List<Double> x0) {
        List<Double> old, cur_x = x0;
        double s;
        for (int Iterations=1; Iterations<=NUMBER_OF_ITERATIONS; Iterations++) {
            //save old value
            old = cur_x;
            cur_x = goldenSection(cur_x,-10,10);

            s=Math.abs(func.getFunc(cur_x)-func.getFunc(old));
            if (s<EPS)
                return cur_x;
        }
        return cur_x;
    }

    public static void main(String[] args) {
        List<Double> x = new ArrayList<>();
        x.add(4D);
        x.add(-1D);
        x.add(2D);
        List<Double> ans = GradientDescent(x);
        System.out.println("Value: " + func.getFunc(ans));
        System.out.println("Point: ");
        for (Double an : ans) {
            System.out.println(an);
        }

    }


}

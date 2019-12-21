package lab6.SD;

import java.util.ArrayList;
import java.util.List;

public class SubTaskAlgorithm {

    protected FunctionMethods func;

    public SubTaskAlgorithm(FunctionMethods func) {
        this.func = func;
    }

    public List<Double> minimize(List<Double> x, double a, double b, int n) {
        List<Double> Result = new ArrayList<>();
        for (int i = 0; i < x.size(); i++)
            Result.add(subTaskMethod(a, b, n , i));
        return Result;
    }

    public double subTaskMethod(double A, double B,int n, int i) {
        return 0;
    }
}

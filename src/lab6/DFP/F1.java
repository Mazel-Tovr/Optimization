package lab6.DFP;

public class F1 implements Function{

    @Override
    public double getValue(int N, double[] X, double[] fParam) {
        return Math.pow(X[0] + 10 * X[1], 2) + 5 * Math.pow(X[2] - X[3], 2) +
                Math.pow(X[1] - 2 * X[2], 4) + 10 * Math.pow(X[0] - X[3], 4);
    }
}

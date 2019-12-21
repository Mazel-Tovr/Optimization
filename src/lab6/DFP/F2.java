package lab6.DFP;

public class F2 implements Function {

    @Override
    public double getValue(int N, double[] X, double[] fParam) {
        return 2 * X[0] * X[0] + 2 * X[1] * X[1] + 2 * X[0] * X[1] + 20 * X[0] + 10 * X[1] + 10;
    }
}

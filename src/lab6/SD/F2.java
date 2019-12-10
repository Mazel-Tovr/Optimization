package lab6.SD;

import java.util.List;

public class F2 implements FunctionMethods {

    @Override
    public double getFunc(List<Double> x) {
        return Math.pow(x.get(0) - 1, 4) + Math.pow(x.get(1) - 3, 2) + 4 * Math.pow(x.get(2) + 5, 4);
    }

    @Override
    public double getPartOFFunction(double x, int i) {
        switch (i) {
            case 0:
                return Math.pow(x - 1, 4);
            case 1:
                return  Math.pow(x - 3, 2);
            case 2:
                return 4 * Math.pow(x + 5, 4);
        }
        return 0;
    }

}

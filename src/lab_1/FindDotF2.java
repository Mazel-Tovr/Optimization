package lab_1;

import lab_1.FindDot;

//  Программа поиска точек перегиба функций (Упражнение 1)
public class FindDotF2 extends FindDot {
    public FindDotF2(double epsilon, double Z) {
        super(epsilon, Z);
    }

    @Override
    protected void firstDerivative() {
        F = X * (2*X-2)+Math.pow((X-1),2);
    }

    @Override
    protected void secondDerivative() {
        D = 6 * X-4;
    }

    @Override
    protected void function() {
        FF = X * Math.pow((X-1),2);
    }
}

package lab_1;

import lab_1.FindDot;

//  Программа поиска точек перегиба функций (Упражнение 2)
public class FindDotF3 extends FindDot {
    public FindDotF3(double epsilon, double Z) {
        super(epsilon, Z);
    }

    @Override
    protected void firstDerivative() {
        F = -2 * Math.pow(X, 2) / Math.pow(Math.pow(X, 2) + 1,2) + 1/(Math.pow(X, 2)+1);
    }

    @Override
    protected void secondDerivative() {
        D =8 * Math.pow(X, 3) / Math.pow(Math.pow(X, 2) + 1, 3)-6*X/Math.pow(Math.pow(X, 2)+1,2);
    }

    @Override
    protected void function() {
        FF = X /(Math.pow(X,2)+1);
    }
}
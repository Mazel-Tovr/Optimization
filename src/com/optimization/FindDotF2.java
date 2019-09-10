package com.optimization;

//  Программа поиска точек перегиба функций (Упражнение 1)
public class FindDotF2 extends FindDot {
    public FindDotF2(double epsilon, double Z) {
        super(epsilon, Z);
    }

    @Override
    protected void firstDerivative() {
        F = X * (2*X-2)+(X-1);
    }

    @Override
    protected void secondDerivative() {
        D = 2*(3*X-2);
    }

    @Override
    protected void function() {
        FF = X * Math.pow((X-1),2);
    }
}

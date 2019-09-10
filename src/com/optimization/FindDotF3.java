package com.optimization;

//  Программа поиска точек перегиба функций (Упражнение 2)
public class FindDotF3 extends FindDot {
    public FindDotF3(double epsilon, double Z) {
        super(epsilon, Z);
    }

    @Override
    protected void firstDerivative() {
        F = -((2*Math.pow(X,2))/(Math.pow(X,2)+1))+(1/(Math.pow(X,2)+1));
    }

    @Override
    protected void secondDerivative() {
        D =2 * X *( (4*Math.pow(X,2)-3)/ ( Math.pow(1 + Math.pow(X,2),2)) );
    }

    @Override
    protected void function() {
        FF = X /(Math.pow(X,2)+1);
    }
}
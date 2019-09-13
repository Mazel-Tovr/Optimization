package com.optimization;

// Лабораторная работа №1
// Программа поиска точек перегиба функций
public class FindDot
{
    private double epsilon;
    private double Z;
    protected double X;
    protected double F,D,FF;
    public String answer;

    FindDot(double epsilon,double Z)
    {
        this.epsilon = epsilon;
        this.Z = Z;
    }

    void find()
    {
        System.out.println("Последовательность апроксимации");
        do {
            X = Z;
            firstDerivative();
            secondDerivative();
            Z = X - F / D;
            System.out.println(X +" "+ Z);
        }
        while (Math.abs(Z-X)>epsilon);
        X = Z;
        firstDerivative();
        secondDerivative();
        function();
        if(D > 0) System.out.println("Минимум равен "+FF + " в точке "+Z);
        else System.out.println("Максимум равен "+FF + " в точке "+Z);

    }

    protected void firstDerivative()
    {
        //F = -((2*Math.pow(X,2))/(Math.pow(X,2)+1))+(1/(Math.pow(X,2)+1));
        //F = X*(2*X-2)+(X-1);
        F = X - Math.cos(X);
    }
    protected void secondDerivative()
    {
        //D =2*X*( (4*Math.pow(X,2)-3)/ ( Math.pow(1 + Math.pow(X,2),2)) );
        //D = 2*(3*X-2);
        D = 1 + Math.sin(X);
    }
    protected void function()
    {
        //FF = X/(Math.pow(X,2)+1);
        //FF = X*Math.pow((X-1),2);
        FF= X * X /2-Math.sin(X);
    }

}




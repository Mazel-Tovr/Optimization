package com.optimization;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

public class Optim {
    private final double a;
    private final double b;
    private final double epsilon;

    Optim(double a, double b, double epsilon)
    {
        this.a = a;
        this.b = b;
        this.epsilon = epsilon;
    }

    private double Function(double z) { return Math.pow(z, 2)+2*z-2*Math.cos(z);}

    private double DerivativeFunction(double z) {
        return 2*(Math.cos(z)+1);
    }

    public void GetDihord() {
        double x1 = this.a;
        double x2 = this.b;

        do {
            double xn = (x1 + x2) / 2.0D;
            if (this.Function(xn) > 0.0D) {
                x2 = xn;
            } else {
                x1 = xn;
            }

            System.out.println(xn);
        } while(Math.abs(x1 - x2) > this.epsilon);

    }

    public void GetHord() {
        double xn = this.a;
        double fb = this.Function(this.b);
        double fxn = this.Function(xn);

        double prevxn;
        do {
            prevxn = xn;
            xn = this.b - (this.b - xn) * fb / (fb - fxn);
            fxn = this.Function(xn);
            System.out.println(xn);
        } while(Math.abs(xn - prevxn) > this.epsilon);

    }

    public void GetKasatelbnblx() {
        double xn = this.a;
        double fxn = this.Function(xn);
        double Defxn = this.DerivativeFunction(xn);

        double prevxn;
        do {
            prevxn = xn;
            xn -= fxn / Defxn;
            fxn = this.Function(xn);
            Defxn = this.DerivativeFunction(xn);
            System.out.println(xn);
        } while(Math.abs(xn - prevxn) > this.epsilon);

    }
}

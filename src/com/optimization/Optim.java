package com.optimization;

// Практическая работа № 1
// Методы дихотомии, хорд, касательных
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

    private double function(double z) { return Math.pow(z, 2)+2*z-2*Math.cos(z);}

    private double derivativeFunction(double z) {
        return 2*(Math.cos(z)+1);
    }

    public void getDihord() {
        double x1 = this.a;
        double x2 = this.b;

        do {
            double xn = (x1 + x2) / 2.0D;
            if (this.function(xn) > 0.0D) {
                x2 = xn;
            } else {
                x1 = xn;
            }

            System.out.println(xn);
        } while(Math.abs(x1 - x2) > this.epsilon);

    }

    public void getHord() {
        double xn = this.a;
        double fb = this.function(this.b);
        double fxn = this.function(xn);

        double prevxn;
        do {
            prevxn = xn;
            xn = this.b - (this.b - xn) * fb / (fb - fxn);
            fxn = this.function(xn);
            System.out.println(xn);
        } while(Math.abs(xn - prevxn) > this.epsilon);

    }

    public void getKasatelbnblx() {
        double xn = this.a;
        double fxn = this.function(xn);
        double Defxn = this.derivativeFunction(xn);

        double prevxn;
        do {
            prevxn = xn;
            xn -= fxn / Defxn;
            fxn = this.function(xn);
            Defxn = this.derivativeFunction(xn);
            System.out.println(xn);
        } while(Math.abs(xn - prevxn) > this.epsilon);

    }
}

package practice_1;

// Практическая работа № 1
// Методы дихотомии, хорд, касательных
public class Optim {
    private final double a;
    private final double b;
    private final double epsilon;
    private int a1=0,b1=0,c1=0;

    public Optim(double a, double b, double epsilon)
    {
        this.a = a;
        this.b = b;
        this.epsilon = epsilon;
    }

    private double function(double z) { return  z*Math.sin(1/z);//Math.pow(z, 2)+2*z-2*Math.cos(z);
    }

    private double derivativeFunction(double z) {
        return Math.sin(1/z)-(Math.cos(1/z)/z);//2*(Math.cos(z)+1);
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
        a1++;
            System.out.println(xn);
        } while(Math.abs(x1 - x2) > this.epsilon);
        System.out.println("Итераций "+a1);
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
            b1++;
        } while(Math.abs(xn - prevxn) > this.epsilon);
        System.out.println("Итераций "+b1);
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
            c1++;
        } while(Math.abs(xn - prevxn) > this.epsilon);
        System.out.println("Итераций "+c1);
    }
}

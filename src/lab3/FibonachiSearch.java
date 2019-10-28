package lab3;

public class FibonachiSearch {
    protected double epsilon;
    protected double A;
    protected double B;
    protected int N;
    protected double Z;

    protected long fibonachi(int number) {
        if (number < 0) return 0;
        if (number == 0) return 1;
        return fibonachi(number - 1) + fibonachi(number - 2);
    }

    public FibonachiSearch(double epsilon, double a, double b, int n) {
        this.epsilon = epsilon;
        A = a;
        B = b;
        N = n;

    }

    public void search() {
        double X1 = A;
        double X2 = A + ((B - A) * fibonachi(N - 1) + epsilon * Math.pow((-1), N)) / fibonachi(N);
        double X3 = B;
        double X = X2;
        getZ(X);
        double F2 = Z;
        System.out.println("Текущий интервал");
        double K = 1;
        System.out.println(X1 + " " + X2);
        double X4 = X1 - X2 + X3;
        X = X4;
        getZ(X);
        double F4 = Z;
        do {
            X4 = X1 - X2 + X3;
            X = X4;
            getZ(X);
            F4 = Z;
            if (F4 > F2) {
                if (X2 < X4) {
                    X3 = X4;
                    System.out.println(X1 + " " + X3);
                } else {
                    X1 = X4;
                    System.out.println(X1 + " " + X3);
                }
            } else if (X2 < X4) {
                X1 = X2;
                X2 = X4;
                F2 = F4;
                System.out.println(X1 + " " + X2);
            } else {
                X3 = X2;
                X2 = X4;
                F2 = F4;
                System.out.println(X1 + " " + X3);
            }
            K = K + 1;
        } while (K <= N);
        System.out.println("Конечный интервал" + X1 + " " + X3);
        System.out.println("Значение функции равно " + F2);


    }


    //Функция
    protected void getZ(double x) {
        Z = Math.pow(x, 4) - 14 * Math.pow(x, 3) + 60 * Math.pow(x, 2) - 70 * x;
        //Z = 2*Math.pow(x,2)-Math.exp(x);
    }
}

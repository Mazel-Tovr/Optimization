package lab5;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class CoordinateDescent {

        private static double f(double[] x)
        {
             return 100 * Math.pow(x[1] - Math.pow(x[0],2),2) + Math.pow(1 - x[0],2);
        }

        private static double[] coordinateDescentMethod(double[] Xo, double eps) {
                double a=-5, b=5;
                int cc = 0;
                // метод золотого сечения
                double[] Xc={0,0},Xd={0,0},x={Xo[0]+10*eps,Xo[1]+10*eps};
                while(abs(f(x) - f(Xo))>eps) {

                        x[0]=Xo[0];
                        x[1]=Xo[1];
                        for (int i = 0; i < 2; i++) {
                                a=-10;
                                b=10;
                                double c = a + (b - a) * (3 - sqrt(5)) / 2, d = a + (b - a) * (sqrt(5) - 1) / 2;
                                while (b - a >= eps*eps)
                                {
                                        cc++;
                                        Xc[0] = Xo[0];
                                        Xc[1] = Xo[1];
                                        Xd[0] = Xo[0];
                                        Xd[1] = Xo[1];
                                        Xc[i] = Xo[i] + c;
                                        Xd[i] = Xo[i] + d;
                                        if (f(Xc) <= f(Xd)) {
                                                b = d;
                                                d = c;
                                                c = a + (b - a) * (3 - sqrt(5)) / 2;
                                        } else {
                                                a = c;
                                                c = d;
                                                d = a + (b - a) * (sqrt(5) - 1) / 2;
                                        }
                                }
                                Xo[i] += (a + b) / 2;
                        }
                }
                System.out.println("Кол-во шагов "+ cc);
                return Xo;
        }

        public static void main(String[] args) {
                double x1 = 1;
                double x2 = 1;
                double[] x={x1,x2};
                double eps = 0.1;
                double[] xmin= coordinateDescentMethod(x, eps);
                System.out.println("Минимум функции:");
                System.out.println(xmin[0] +";"+xmin[1]);
        }
}

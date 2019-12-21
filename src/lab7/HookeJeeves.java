package lab7;

public class HookeJeeves {

    public static void main(String[] args) {
        new HookeJeeves().search();
    }

    void info(int k, int nextPointer, double valFx,int prevPointer, String valPrevPointer,String valNextPointer,double h){
        System.out.println("Итерация, k = " + k);
        System.out.println("Поиск по образцу:");
        System.out.printf("x%d(%s), x%d(%s)",prevPointer,valPrevPointer,nextPointer,valNextPointer);
        System.out.println();
        System.out.printf("f(%d) = %f",nextPointer,valFx);
        System.out.println();
        System.out.println("h = " + h); 
        System.out.println("e = 0.01");
    }

    double f (double x1,double x2) {
        return 3 * Math.pow(x1,2) + 4 * x1 * x2 + 5*Math.pow(x2,2);
    }

    void search() {
        double h = 1; // шаг
        int k = 0;
        double e = 0.01; // эпсилон
        double x1 = 4;
        double x2 = 3;
        double valFx = 0;

        System.out.println("Исходные значения: ");
        System.out.printf("x1(%f, %f)",x1,x2);
        System.out.println();
        System.out.println("f(x1)=" + f(x1, x2));
        System.out.println("e = 0.01");
        System.out.println("h = 1");

        while (h > e) {
            while(
                    (f(x1,x2) > f(x1+h,x2)) ||
                            (f(x1,x2) > f(x1-h,x2)) ||
                            (f(x1,x2) > f(x1,x2+h)) ||
                            (f(x1,x2) > f(x1,x2-h))
            )
            {
                // удачный поиск
                double x1_0 = x1;
                double x2_0 = x2;
                double fx = f(x1, x2);

                double f4=f(x1-h,x2);
                double f3=f(x1,x2+h);
                double f2=f(x1+h,x2);
                double f1=f(x1,x2-h);

                double min1 = Math.min(f1, f2);
                double min2 = Math.min(f3, f4);
                double min = Math.min(min1,min2);

                if (min < fx) {
                    // поиск по образцу
                    String prevX = x1 + "," + x2;
                    if (min == f4) { x1 = x1 - h; x2 = x2; valFx = f4; }
                    if (min == f3) { x1 = x1; x2 = x2 + h; valFx = f3; }
                    else if (min == f2) { x1 = x1 + h; x2 = x2; valFx = f2; }
                    else if (min == f1) { x1 = x1; x2 = x2 - h; valFx = f1; }

                    int nextPointer;
                    if (k>0) nextPointer = 3; else nextPointer = 2;

                    info(k, nextPointer, valFx, nextPointer - 1, prevX, String.valueOf(x1+x2), h);
                }
                k++;
            }

            h = h / 2;
            k++;

            System.out.println("Итерация, k = " + k);
            System.out.println("Исследующий поиск оказался безуспешным");
            System.out.println("h = " + h);
        }

        System.out.println("Результат");
        System.out.printf("Ответ: (%f, %f)",x1,x2);
        System.out.println();
        System.out.println("f(x) = " + valFx);

        }


    }



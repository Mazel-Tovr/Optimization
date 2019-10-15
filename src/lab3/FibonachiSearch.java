package lab3;

public class FibonachiSearch
{
    private double epsilon;
    private double A;
    private double B;
    private int N;
    private double Z;

 private long fibonachi(int number)
 {
     if (number < 0) return 0;
     if (number == 0) return 1;
     return fibonachi(number-1) + fibonachi(number-2);
 }

    public FibonachiSearch(double epsilon, double a, double b,int n)
    {
        this.epsilon = epsilon;
        A = a;
        B = b;
        N = n;

    }
//    void Search() {
//      double x1 = A;
//      double x2 = A + ((B-A)*fibonachi(N-1)+epsilon*Math.pow(-1,N))/fibonachi(N);
//      double x3 = B;
//      double x = x2;
//      getZ(x);
//      double F2 = Z;
//      double K = 1;
//      System.out.println(x1 +" "+x3);
//      double x4 = x1 - x2 + x3;
//      x = x4;
//      getZ(x);
//      double F4 = Z;
//      if (F4>F2) {
//          if(x2<x4) {
//              x3=x4;
//              System.out.println(x1 +" "+x3);
//          }
//      }
//      if (x2<x4) {
//          x1 = x2;
//          x2 = x4;
//          F2 = F4;
//          System.out.println(x1 +" "+x3);
//      }
//      x3 = x2;
//      x2 =x4;
//      F2 = F4;
//      System.out.println(x1 +" "+x3);
//      K++;
//      if (K<=N) {
//          x4 = x1-x2+x3;
//      }
//        System.out.println("Конечный интервал: ");
//        System.out.println(x1 +" "+x3);
//        System.out.println("Значение функции равно: " + F2);
//    }


   public void search()
    {
        double X1 = A;
        double X2 = A+((B-A)*fibonachi(N-1)+epsilon*Math.pow((-1),N))/fibonachi(N);
        double X3 = B;
        double X = X2;
        getZ(X);
        double F2 = Z;
        System.out.println("Текущий интервал");
        double K =1;
        System.out.println(X1 + " "+X2);
        double X4 = X1 - X2 +X3;
        X = X4;
        getZ(X);
        double F4 = Z;
        do
        {
         X4 = X1-X2+X3;
         X = X4;
         getZ(X);
         F4 = Z;
         if(F4>F2)
         {
             if(X2<X4)
             {
                 X3=X4;
                 System.out.println(X1+" "+X3);
             }
         }
         if(X2<X4)
         {
             X1 = X2;X2=X4;F2=F4;
             System.out.println(X1+" "+X2);
         }
         K = K+1;
        }while (K<= N);
        System.out.println("Конечный интервал"+X1 + " "+X3);
        System.out.println("Значение функции равно "+ F2);


    }


    //Функция
    void getZ(double x)
    {
        Z = 2*Math.pow(x,2)-Math.exp(x);
        //Z = x * x * x * x -14 * x * x * x + 60 * x * x -70 * x;
    }
}

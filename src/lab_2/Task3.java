package lab_2;

import org.w3c.dom.ls.LSOutput;

public class Task3
{
 /*
  Исследуйте функцию f(x)=x^(2/3)-1. Нарисуйте её график.
  Покажите, что f(x) имеет минимум при x=0.
  Чему равно значение f'(x) при x=0? Меняет ли знак f'(x),
  если x возрастает при прохождении через 0?

смерть
  */
 public static void isMinInCurrentPoint(double x)
 {
     var a = firstDerivative(x);
            if( a == 0d || Double.isInfinite(a) ||Double.isNaN(a))
            {
                System.out.println("Точка "+x +" является экстремумом");

                if(secondDerivative(x) > 0d)
                    System.out.println("Точка "+x +" является максимумом");
                else
                    System.out.println("Точка "+x +" является минимумом");
            }
            else {
                System.out.println("Точка " +x+" не является экстремумом");
            }
 }
 public static void isChangeSign(double x)
 {
     double prev = x - 1d;
     double next = x + 1d;
     if(firstDerivative(prev) < 0 && firstDerivative(next) > 0)
     {
         System.out.println("Функция в точке: "+ x +" меняет свой знак");
     }
     else
     {
         System.out.println("Знак не меняется");
     }
 }

    private static double secondDerivative(double x)
    {
        return -(2d/(9*Math.pow(x,4d/3d)));
    }

    private static double firstDerivative(double x)
    {
        return 2d/(3d * Math.pow(x,1d/3d));
    }
    private static double function(double x)
    {
        return Math.pow(x,2d/3d) - 1;
    }

}

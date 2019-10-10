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
 public static void isMinInCurrentPoint(final double x)
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
     System.out.println("Значение f'(x) при x= "+x +" Равно: "+a);
 }
 public static void isChangeSign(final double x)
 {
     double prev = x - 1d;
     double next = x + 1d;
     var a =firstDerivative(prev);
     var v =        firstDerivative(next);
     if(firstDerivative(prev) < x && firstDerivative(next) > x)
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

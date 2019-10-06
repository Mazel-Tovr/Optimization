package lab_2;

public class Task3
{
 /*
  Исследуйте функцию f(x)=x^(2/3)-1. Нарисуйте её график.
  Покажите, что f(x) имеет минимум при x=0.
  Чему равно значение f'(x) при x=0? Меняет ли знак f'(x),
  если x возрастает при прохождении через 0?

смерть
  */




    private double secondDerivative(double x)
    {
        return -(2d/(9*Math.pow(x,4d/3d)));
    }

    private double firstDerivative(double x)
    {
        return 2d/(3d * Math.pow(x,1d/3d));
    }
    private double function(double x)
    {
        return Math.pow(x,2d/3d) - 1;
    }

}

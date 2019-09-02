
public class Optim
{
    private final double a;
    private final double b;
    private final double epsilon;

    Optim(double a,double b,double epsilon)
    {
        this.a = a;
        this.b = b;
        this.epsilon = epsilon;
    }
    //Сама функция
    private double Function(double z)
    {
       //return 10 - 0.5*Math.pow(z,2)-Math.pow(2,-z); для проверки 4,461978401 у нее такой ответ должен быть
        return Math.pow(z,4)+Math.pow(z,2)+z+1;
    }
    //Производная функции
    private double DerivativeFunction(double z)
    {
        return 4*Math.pow(z,3)+ 2*z + 1;
    }

    public void GetDihord()
    {
        double x1 = a;
        double x2 = b;
        double xn;
        do
        {
             xn = (x1+x2)/2;
             if(Function(xn)>0)x2 = xn;
                 else x1 = xn;
                 System.out.println(xn);
        }
        while (Math.abs(x1 - x2)>epsilon);

    }

    //Для данной функции этот метод не катит почему-то, хотя на других фунуциях все оки доки
    public void GetHord()
    {
        double xn = a;
        double fb = Function(b);
        double fxn =Function(xn);
        double prevxn;
        do
        {
            prevxn = xn;
            System.out.println(xn);
            xn = b -((b -xn)*fb)/(fb-fxn);
            fxn =Function(xn);
            System.out.println(xn);

        } while (Math.abs(xn - prevxn)>epsilon);
    }
    //Тоже самое что и для второй функции
    public void GetKasatelbnblx()
    {
        double xn = a;
        double fxn = Function(xn);
        double Defxn = DerivativeFunction(xn);
        double prevxn;
        do
        {
            prevxn = xn;
            xn =  xn - (fxn/Defxn);
            fxn = Function(xn);
            Defxn = DerivativeFunction(xn);
            System.out.println(xn);

        }while (Math.abs(xn - prevxn)>epsilon);
    }


}

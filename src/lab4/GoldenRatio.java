package lab4;

public class GoldenRatio
{

    private double A;
    private double B;
    private double epsilon;
    private double Z;

    public GoldenRatio(double a, double b, double epsilon)
    {
        A = a;
        B = b;
        this.epsilon = epsilon;
    }
    public void search()
    {
        double T1 = 0.3819660113;
        double T2 = 1 -T1;
        double X0=A;
        double X1=A+T1*(B-A);
        double X2=A+T2*(B-A);
        double X3 = B;
        double X = X1;
        function(X);
        double F1 = Z;
        X = X2;
        function(X);
        double F2 =Z;
        System.out.println("Текущий интервал");
        double I;
        do
        {
            System.out.println(X0+"\t"+X3);
            if(F2<F1)
            {
                I=X3-X1;
                X0=X1;
                X1=X2;
                X2=X0+T2*I;
                F1=F2;
                X=X2;
                function(X);
                F2=Z;
            }
            else
            {
                I = X2 - X0;
                X3=X2;
                X2=X1;
                X1=X0+T1*I;
                F2=F1;
                X=X1;
                function(X);
                F1=Z;
            }
        }while (I>epsilon);
        System.out.println("X= "+X1+"\t"+"F(X)= "+F1);

    }

    private void function(double X)
    {
        Z = -Math.exp(-X)*Math.log(X);
    }

}

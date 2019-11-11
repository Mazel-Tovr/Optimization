package lab4;

public class QuadraticInterpolation
{
    //Nachalnoe znachenie a
    private double A;
    //Wag
    private double H;
    private double epsilon;

    private double Z;

    public QuadraticInterpolation(double a, double h, double epsilon)
    {
        A = a;
        H = h;
        this.epsilon = epsilon;
    }

    public void search()
    {
        double[] Xx = new double[5];
        double[] Ff = new double[5];
        double X;
        Xx[1] = A;
        X=Xx[1];
        function(X);
        Ff[1]=Z;
        Xx[2]=A+H;
        X = Xx[2];
        function(X);
        Ff[2] = Z;
        if (Ff[1]<Ff[2])
        {
            Xx[3]=A-H;
            X = Xx[3];
            function(X);
            Ff[3]=Z;
        }
        else
        {
            Xx[3]=A+2*H;
            X = Xx[3];
            function(X);
            Ff[3]=Z;
        }
        System.out.println("Вычисление первого аппроксимирующего минимума");
        double DN = (Xx[2]-Xx[3])*Ff[1];
        DN = DN+(Xx[3]-Xx[1])*Ff[2]+(Xx[1]-Xx[2])*Ff[3];
        double NM  = (Xx[2]*Xx[2]-Xx[3]*Xx[3])*Ff[1];
        NM = NM+(Xx[3]*Xx[3]-Xx[1]*Xx[1])*Ff[2];
        NM = NM+(Xx[1]*Xx[1]-Xx[2]*Xx[2])*Ff[3];
        Xx[4] = NM/(2*DN);
        X=Xx[4];
        function(X);
        Ff[4] = Z;
        do
        {
            for (int j = 1; j < 4 ; j++)
            {
                for (int k =j+1; k < 5; k++)
                {
                    if(Ff[j]<=Ff[k])
                    {
                        break;
                    }
                    X=Xx[j];
                    Xx[j]=Xx[k];
                    Xx[k]=X;
                    double F = Ff[j];
                    Ff[j]=Ff[k];
                    Ff[k]=F;
                }
            }
            for (int i = 1; i < 5 ; i++)
            {
                System.out.println(Xx[i]+", "+Ff[i]);
            }

            if (Math.abs(Xx[1]-Xx[2])<epsilon)
            {
                break;
            }
            int S1 = getSignum(Xx[2]-Xx[1]);//Integer.signum()
            int S2 = getSignum(Xx[3]-Xx[1]);
            int S3 = getSignum(Xx[4]-Xx[1]);
            if(S1==S2 && S1==-S3)
            {
                Xx[3]=Xx[4];
                Ff[3]=Ff[4];
            }

        }while (true);


    }

    private void function(double X)
    {
        Z = 001;
    }

   private int getSignum(double number)
   {
       if(number == 0) return 0;
       if(number > 0) return 1;
       return -1;
   }

}

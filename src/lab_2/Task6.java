package lab_2;

import java.util.HashMap;

public class Task6
{
    private double A;
    private double B;
    private double C;
    private Point point;
    HashMap<String,Double> firstDerivative= new HashMap<>();

    public Task6(Double dxdy,Double dxx,Double dyy,Point point)
    {
            firstDerivative.put("dxdy",dxdy);
            firstDerivative.put("dxx",dxx);
            firstDerivative.put("dyy",dyy);
            this.point =point;
            getABC();
    }
    private void getABC()
    {
        B = firstDerivative.get("dxdy").doubleValue();
        A = firstDerivative.get("dxx").doubleValue();
        C = firstDerivative.get("dyy").doubleValue();
    }

    public void getConclusionAboutThePresenceOfExtremes()
    {
        if(A*C - Math.pow(B,2)>0 && A<0)
            System.out.println("в точке M(" +point.getX()+","+ point.getY()+") имеется максимум");
        else if(A*C - Math.pow(B,2)>0 && A>0)
            System.out.println("в точке M(" +point.getX()+","+ point.getY()+") имеется минимум");
        else if (A*C - Math.pow(B,2)<0)
            System.out.println("в точке M(" +point.getX()+","+ point.getY()+") экстемума нет");
        else if(A*C - Math.pow(B,2) == 0 )
            System.out.println("Вопрос о наличии экстремума остается открытым");
    }

}

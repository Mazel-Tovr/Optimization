package lab3;

public class FibonachiSearchTask4 extends FibonachiSearch
{
    public FibonachiSearchTask4(double epsilon)
    {
        super(epsilon, 0, 1, 10);
    }

    @Override
    protected void getZ(double x)
    {
     Z = 2 * Math.pow(x,2)+3*Math.exp(-x);
    }
}

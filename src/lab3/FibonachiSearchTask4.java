package lab3;

public class FibonachiSearchTask4 extends FibonachiSearch
{
    public FibonachiSearchTask4()
    {
        super(0, 0, 1, 10);
    }

    @Override
    protected void getZ(double x)
    {
     Z = 2 * Math.pow(x,2)+3*Math.exp(-x);
    }
}

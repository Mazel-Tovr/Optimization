package lab_2;

public class Task4 extends lab_1.FindDot
{
    //Done
    public Task4() { super(0.0001d, 1); }

    @Override
    protected void firstDerivative()
    {
        F = Math.exp(-X) * Math.sinh(X/2d)-((Math.exp(-X)*Math.cosh(X/2))/2d);
    }

    @Override
    protected void secondDerivative()
    {
        D = (((-5*Math.sinh(X/2d))/4) + Math.cosh(X/2d)) * Math.exp(-X);
    }

    @Override
    protected void function() {
        FF = -Math.exp(-X)*Math.sinh(X/2d);
    }

}

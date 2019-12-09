package lab6;

import java.util.ArrayList;
import java.util.List;

public class SteepestDescent
{
    private int NUMBER_OF_ITERATIONS = 100000;
    private double EPS = 1e-5;

    List<Double> goldenSectionOptimize(List<Double> x,double a,double b, int n){
        List<Double> tmp = x;
        double s1;
        double s2;
        double u1;
        double u2;
        double fu1;
        double fu2;

        List<Double> GF=GradientF(x);

        s1 = (3-Math.sqrt(5D))/2;
        s2 = (Math.sqrt(5D-1)/2;
        u1 = a+s1*(b-a);
        u2 = a+s2*(b-a);

        for(int j=0;j<x.size();j++)
            tmp.set(j,x.get(j)+u1*GF.get(j));
        fu1 = f(tmp);

        for(int j=0;j<x.size();j++)
            tmp.set(j,x.get(j)+u2*GF.get(j));
        fu2 = f(tmp);

        for(int i = 1; i <= n; i++)
        {
            if( fu1<=fu2 )
            {
                b = u2;
                u2 = u1;
                fu2 = fu1;
                u1 = a+s1*(b-a);
                for(int j=0;j<x.size();j++)
                    tmp.set(j,x.get(j)+u1*GF.get(j));
                fu1 = f(tmp);
            }
            else
            {
                a = u1;
                u1 = u2;
                fu1 = fu2;
                u2 = a+s2*(b-a);
                for(int j=0;j<x.size();j++)
                    tmp.set(j,x.get(j)+u2*GF.get(j));
                fu2 = f(tmp);
            }
        }
        for(int j=0;j<x.size();j++)
            tmp.set(j,x.get(j)+u1*GF.get(j));
        fu1 = f(tmp);
        for(int j=0;j<x.size();j++)
            tmp.set(j,x.get(j)+u2*GF.get(j));
        fu2 = f(tmp);

        if (fu1<fu2)
            for(int j=0;j<x.size();j++)
                tmp.set(j,x.get(j)+u1*GF.get(j));
        else
            for(int j=0;j<x.size();j++)
                tmp.set(j,x.get(j)+u2*GF.get(j));

        return tmp;
    }

    double f (List<Double> x) {
        return 10*x.get(0)*x.get(0)+x.get(1)*x.get(1);
    }

    List<Double> GradientF(List<Double> x) {
        List<Double> tmp = new ArrayList<>() {};
        //tmp.add(-2*(1-x.get(0)) - 400 *(x.get(1)-x.get(0)*x.get(0))*x.get(0));
        //tmp.add(200*x.get(1));
        tmp.add(20*x.get(0));
        tmp.add(2*x.get(1));
        return tmp;
    }

    List<Double> GradientDescent(int N,List<Double> x0) {
        List<Double> old = new ArrayList<Double>(), cur_x = x0, gr;

        for (int Iterations=1; Iterations<=NUMBER_OF_ITERATIONS; Iterations++) {
            //save old value
            old = cur_x;
            //compute gradient
            gr = GradientF(cur_x);
            cur_x=goldenSectionOptimize(cur_x,-10,10,100);
        }
    }


}

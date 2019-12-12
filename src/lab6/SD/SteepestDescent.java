package lab6.SD;

import java.util.ArrayList;
import java.util.List;

public class SteepestDescent
{
    private static final int NUMBER_OF_ITERATIONS = 100000;
    public static double EPS =  Math.pow(10, -5);

    // F1,F2
    private static FunctionMethods func = new F1(){};

    private static SubTaskAlgorithm subTaskAlgorithm = new GoldenSection(func);


//    private static List<Double> GradientF(List<Double> x) {
//        List<Double> tmp = new ArrayList<>() {};
//        tmp.add(2 * (x.get(0) - 1));
//        tmp.add(2 * (x.get(1) - 3));
//        tmp.add(8 + (x.get(2) + 5));
//        return tmp;
//    }

    private static List<Double> GradientDescent(List<Double> x0) {
        List<Double> old, cur_x = x0;
        double s;
        for (int iterations=1; iterations <= NUMBER_OF_ITERATIONS; iterations++) {
            //save old value
            old = cur_x;
            cur_x = subTaskAlgorithm.minimize(cur_x,-10,10,100);

            s = Math.abs(func.getFunc(cur_x) - func.getFunc(old));
            if (s<EPS)
                return cur_x;
        }
        return cur_x;
    }

    public static void main(String[] args) {
        List<Double> x = new ArrayList<>();
        x.add(4D);
        x.add(-1D);
        x.add(2D);
        List<Double> ans = GradientDescent(x);
        System.out.println("Value: " + func.getFunc(ans));
        System.out.println("Point: ");
        for (Double an : ans) {
            System.out.println(an);
        }


    }


}

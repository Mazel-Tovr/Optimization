import lab3.FibonachiSearch;
import lab3.FibonachiSearchTask4;
import lab4.GoldenRation;
import lab4.QuadraticInterpolation;
import lab4.СubicalInterpolation;
import lab_1.FindDot;
import lab_1.FindDotF2;
import lab_1.FindDotF3;
import practice_1.*;
import practice_2.*;
import lab_2.*;

import java.io.IOException;

public class Main {

    static void lab1() {
        Optim op = new Optim(-0.5,1,Math.pow(10,-7));
        System.out.println("Метод дихотомии:");
        op.getDihord();
        System.out.println("Метод хорд:");
        op.getHord();
        System.out.println("Метод касательных:");
        op.getKasatelbnblx();
    }
    static void practice1() {
        System.out.println("Программа поиска точек перегиба функций:");
        
        System.out.println("\nФункция 1/2x^2 - sin(x):");
        System.out.println("---");
        FindDot fin = new FindDot(0.00001,0.5);
        //fin.find();
        System.out.println("\nФункция x*(x-1)^2:");
        System.out.println("---");
        FindDot fin2 = new FindDotF2(0.00001,0.5);
        fin2.find();
        System.out.println("---");
        FindDot fin22 = new FindDotF2(0.00001,1);
        fin22.find();
        System.out.println("\nФункция x/(x^2+1):");
        System.out.println("---");
        FindDot fin3 = new FindDotF3(0.00001,-1.4);
        fin3.find();
        System.out.println("---");
        FindDot fin33 = new FindDotF3(0.00001,0.8);
        fin33.find();
    }
    static void pratice2()
    {
        Cone con = new Cone();
        System.out.println("Optimum");
        con.Optimum();
        System.out.println("NOptimum");
        con.NOptimum();
    }
    static void lab2() {
        System.out.println("---------------------\n"+"Task 3\n"+"------------------------");
        Task3.isMinInCurrentPoint(0);
        System.out.println("---------------------\n"+"Task 4\n"+"------------------------");
        lab_2.Task4 task4 = new lab_2.Task4();
        task4.find();
        System.out.println("---------------------\n"+"Task 5\n"+"------------------------");
        Task5 task5 =new Task5();
        task5.getInfo();
        System.out.println("---------------------\n"+"Task 6\n"+"------------------------");
        Point M = new Point(0,0);
        Task6 task6 = new Task6(4d,2d,10d,M);
        task6.getConclusionAboutThePresenceOfExtremes();
        System.out.println("---------------------\n"+"Task 7\n"+"------------------------");
         int [][] hessMatrix1 = {
                {-2,2,0},
                {2,-12,20},
                {0,20,-46}
        };
        Task7and8 task7 = new Task7and8(hessMatrix1);
        task7.getConclusionAboutThePresenceOfExtremes();
        System.out.println("---------------------\n"+"Task 8\n"+"------------------------");
        int [][] hessMatrix2 = {
                {2,0,0},
                {0,2,0},
                {0,0,2}
        };
        Task7and8 task8 = new Task7and8(hessMatrix2);
        task8.getConclusionAboutThePresenceOfExtremes();
    }
   static void lab3()throws IOException
    {
       System.out.println("----------------------\n"+"-------Task 3,5--------\n"+"-------------------------");
        FibonachiSearch fibonachiSearch = new FibonachiSearch(0,0,1,10);
      //  fibonachiSearch.search();
        System.out.println("----------------------\n"+"-------Task 2,4--------\n"+"-----------------------");
        fibonachiSearch = new FibonachiSearchTask4();
        fibonachiSearch.search();
//        System.out.println("----------------------\n"+"-------Task 5--------\n"+"------------------------");
//        fibonachiSearch = new FibonachiSearchTask5();
//        fibonachiSearch.search();
    }

    static void lab4()
    {
        GoldenRation ration = new GoldenRation(0,1,0.0001);
        ration.search();
//        System.out.println("--");
//        QuadraticInterpolation quadraticInterpolation = new QuadraticInterpolation(1,0.5,0.001);
//        quadraticInterpolation.search();
//        СubicalInterpolation сubicalInterpolation = new СubicalInterpolation();
//        сubicalInterpolation.search();
    }
    public static void main(String[] args)throws IOException {
        // lab1();
        // practice1();
        // pratice2();
          // lab2(
          //  lab3();
        lab4();

    }
}

package com.optimization;

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
    static void lab2() {
        System.out.println("Программа поиска точек перегиба функций:");

        System.out.println("\nФункция 1/2x^2 - sin(x):");
        System.out.println("---");
        FindDot fin = new FindDot(0.00001,0.5);
        fin.find();
        System.out.println("\nФункция x*(x-1)^2:");
        System.out.println("---");
        FindDot fin2 = new FindDotF2(0.00001,0.5);
        fin2.find();
        System.out.println("\nФункция x/(x^2+1):");
        System.out.println("---");
        FindDot fin3 = new FindDotF3(0.00001,0.5);
        fin3.find();
    }
    public static void main(String[] args) {
        lab1();
       // lab2();
    }
}
 
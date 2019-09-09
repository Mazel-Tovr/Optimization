package com.optimization;

public class Main {

    public static void main(String[] args) {
        Optim op = new Optim(-0.5,1,0.0001);
        System.out.println("Метод дихотомии:");
         op.GetDihord();
         op.GetHord();
         op.GetKasatelbnblx();
    } 
}

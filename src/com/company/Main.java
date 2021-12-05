package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Klient> klienci= new ArrayList<>();
        List<Sklep> sklepy=new ArrayList<>();


        List<Towar> towary=new ArrayList<>();
        towary.add(new Towar("towar1",80));
        towary.add(new Towar("towar2",350));
        towary.add(new Towar("towar3",620));
        towary.add(new Towar("towar4",900));
        towary.add(new Towar("towar5",1180));
        towary.add(new Towar("towar6",1460));
        towary.add(new Towar("towar7",1740));
        towary.add(new Towar("towar8",2000));

        Sklep sklep1=new Sklep(20,towary);//Dużo towaru
        Sklep sklep2=new Sklep(15,towary);//Średnio towaru
        Sklep sklep3=new Sklep(10,towary);//Mało towaru
        sklepy.add(sklep1);
        sklepy.add(sklep2);
        sklepy.add(sklep3);


        double myG=0;
        Random r = new Random();

        for (int i=0;i<100;i++){

            int d=0;
            do{
                myG = r.nextGaussian()*20+65;
            }while (myG<20 || myG>100);


            if(myG<30){
                klienci.add(new Klient(myG,towary.get(0),getExp(r,20),getPoisson(r,15),20,15,sklepy));
            }else if(myG<40){
                klienci.add(new Klient(myG,towary.get(1),getExp(r,26),getPoisson(r,13),26,13,sklepy));
            }else if(myG<50){
                klienci.add(new Klient(myG,towary.get(2),getExp(r,32),getPoisson(r,12),32,12,sklepy));
            }else if(myG<60){
                klienci.add(new Klient(myG,towary.get(3),getExp(r,38),getPoisson(r,10),38,10,sklepy));
            }else if(myG<70){
                klienci.add(new Klient(myG,towary.get(4),getExp(r,43),getPoisson(r,9),43,9,sklepy));
            }else if(myG<80){
                klienci.add(new Klient(myG,towary.get(5),getExp(r,48),getPoisson(r,8),48,8,sklepy));
            }else if(myG<90){
                klienci.add(new Klient(myG,towary.get(6),getExp(r,54),getPoisson(r,6),54,6,sklepy));
            }else if(myG<100){
                klienci.add(new Klient(myG,towary.get(7),getExp(r,60),getPoisson(r,4),60,4,sklepy));
            }

        }

        sklep1.dostawa();
        sklep1.dostawa();
        List<Towar>temp;
        temp=sklep1.getTowar();
        for(int i=0;i<temp.size();i++){
        //    System.out.println(temp.get(i).wartosc+" - "+temp.get(i).ilosc);
        }
        System.out.println();
        System.out.println("Dostawa");
        System.out.println();
        sklep1.dostawa();
        for(int i=0;i<temp.size();i++){
        //    System.out.println(temp.get(i).wartosc+" - "+temp.get(i).ilosc);
        }

        //pętla idąca po każdym dniu
        System.out.println("Dzień 1");
        for(int dzien=0;dzien<360;dzien++){
        if(dzien%30==0){//dostawa 1 dzień miesiąca
//            sklep1.dostawa();
//            sklep3.dostawa();
//            sklep2.dostawa();
        }



        }




    }

    //Co ile dni kupuja
    static double getExp(Random rand, double lambda) {
        return -lambda*Math.log(1-rand.nextDouble());
    }


    //ilosc kupowanych
    static int getPoisson (Random rand, double lambda) {
        int k = 0;
        do {
            double l = Math.exp(-lambda);
            double p = 1.0;
            k = 0;
            do {
                k++;
                p *= rand.nextDouble();
            } while (p > l);
        }while (k-1<0);
        return k - 1;
    }

}




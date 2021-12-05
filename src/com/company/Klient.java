package com.company;

import java.util.*;

public class Klient {
double wiek;
Towar towar;
double dni;
int ilesztuk;
int lambdaDni;
int lambdaSztuki;

Map<Sklep,Integer> sklepy;




    Random r = new Random();


    Klient(double wiek, Towar towar, double exp,int ilesztuk,int lambdaDni,int lambdaSztuki,List<Sklep> sklepy) {
        this.wiek = wiek;
        this.towar = towar;
        this.dni = exp;
        this.ilesztuk = ilesztuk;
        this.lambdaDni=lambdaDni;
        this.lambdaSztuki=lambdaSztuki;


        Map<Sklep,Integer> tmp=new HashMap<>();
        for(int i=0;i<sklepy.size();i++){
            tmp.put(sklepy.get(i),5);
        }
        this.sklepy=tmp;

    }

    public int getIlesztuk() {
        return ilesztuk;
    }

    public void setIlesztuk(int ilesztuk) {
        this.ilesztuk = ilesztuk;
    }

    public double getDni() {
        return dni;
    }

    public void setDni(double exp) {
        this.dni = exp;
    }

    //Co ile dni kupuja
    double getExp(Random rand, double lambda) {
        return -lambda*Math.log(1-rand.nextDouble());
    }


    //ilosc kupowanych
    int getPoisson (Random rand, double lambda) {
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

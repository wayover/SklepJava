package com.company;

import java.util.*;

public class Klient {
int wiek;
Towar towar;
Sklep ktorySklep;
int dni;
int ilesztuk;
int lambdaDni;
int lambdaSztuki;
Map<Sklep,Integer> sklepy;
List<Sklep> listSklep;

Boolean pierwszy=true;


    Random r = new Random();


    Klient(double wiek, Towar towar,int lambdaDni,int lambdaSztuki,List<Sklep> sklepy) {
        this.wiek = (int)wiek;
        this.towar = towar;
        this.lambdaDni=lambdaDni;
        this.lambdaSztuki=lambdaSztuki;
        this.dni = (int)getExp(r,lambdaDni);
        this.ilesztuk = getPoisson(r,lambdaSztuki);
        this.listSklep=sklepy;
        int sklId= (int) ((Math.random() * (sklepy.size())));
        ktorySklep= sklepy.get(sklId);


        Map<Sklep,Integer> tmp=new HashMap<>();
        for(int i=0;i<sklepy.size();i++){
            tmp.put(sklepy.get(i),3);
        }
        this.sklepy=tmp;

    }



    public Kupowanie kup(){

        List<Double> ocena=new ArrayList<>();

        if(pierwszy==true){
            Kupowanie kup=new Kupowanie(ktorySklep,towar,getPoisson (r, lambdaSztuki),this);
            pierwszy=false;
            return kup;
        }else{

            double tmpOcena=0;
            for (Map.Entry<Sklep, Integer> sklep : sklepy.entrySet()) {
                tmpOcena=sklep.getValue()*wiek/20;//Ocena sklepu przez klienta(Jeżeli nie był ocenia go na 3). Czym starszy tym rzadziej zmienia dobrze oceniany sklep przez siebie
                tmpOcena*=sklep.getKey().getSrOcena()*10/wiek;//średnia ocena sklepu przez wszystkich. Czym młodszy tym bardziej to się liczy
                if(sklep.getKey().czyPromocja(towar)){
                    tmpOcena*=5;
                }//Jeżeli sklep ma promocje

                ocena.add(tmpOcena);
            }
            int maxOcena=0;
            for(int i=1;i<ocena.size();i++){
                if(maxOcena<ocena.get(i)){
                    ktorySklep=listSklep.get(i);//wybranie sklepu z najwyzsza ocena
                }
            }

            Kupowanie kup=new Kupowanie(ktorySklep,towar,getPoisson (r, lambdaSztuki),this);
            return kup;
        }


    }

    public void WystawOcene(int dzien){
        int ocena=0;
        int iledni=dzien-dni;
        if(iledni<2){
            ocena=5;
        }else if(iledni<5){
            ocena=4;
        }else if(iledni<10){
            ocena=3;
        }else if(iledni<15){
            ocena=2;
        }else{
            ocena=1;
        }

        ktorySklep.wystawOcene(ocena);
        sklepy.put(ktorySklep,ocena);

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

    public void setDni(int exp) {
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

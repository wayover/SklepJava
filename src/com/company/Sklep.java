package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sklep {

    float kasa=0;
    float kredyt=0;
    int ile;
    List<Double> ocena=new ArrayList<>();
    double srOcena;
    List<Kupowanie>kolejka=new ArrayList<>();


    List<Towar>towar= new ArrayList<>();
    List<Towar>ceny;
    List<Boolean>promocja=new ArrayList<>();

    Sklep(int ile,List<Towar> towar){
        this.ile=ile;
        Towar temp1;
        //System.out.println(towar.size());
        for(int i=0;i<towar.size();i++){
            temp1=new Towar(towar.get(i).nazwa,towar.get(i).wartosc);
            this.towar.add(temp1);

        }
        this.ceny=towar;
     //   this.towar=towar;
      //  this.ceny=towar;

    }

    public void sprzedaj(Kupowanie kup,int dzien){
        int idTowaru=towar.indexOf(kup.towar);
        Towar t=towar.get(idTowaru);
        if(towar.get(idTowaru).ilosc>kup.ile){
            t.ilosc-=kup.ile;
            towar.set(idTowaru,t);
            kup.klient.WystawOcene(dzien);
        }else{
            kolejka.add(kup);//Dodanie do kolejki
        }
    }


    public void dostawa(int dzien) {//TODO sprawdzic czy na pewno dobrze
        for (int i = 0; i < towar.size(); i++) {
            if (towar.get(i).ilosc > ile * 45) {
                towar.get(i).wartosc = ceny.get(i).wartosc * 1.02;
                towar.get(i).ilosc += (ile * 45);
                promocja.set(i, true);

            } else {
                towar.get(i).wartosc = ceny.get(i).wartosc * 1.2;
                towar.get(i).ilosc += (ile * 45);
                promocja.set(i, false);
            }
        }

        int g = 0;
        while (g < kolejka.size()) {
            Kupowanie k = kolejka.get(g);
            int idTowaru = towar.indexOf(k.towar);
            Towar t = towar.get(idTowaru);
            if (towar.get(idTowaru).ilosc > k.ile) {
                t.ilosc -= k.ile;
                towar.set(idTowaru, t);
                k.klient.WystawOcene(dzien);
                kolejka.remove(g);
            } else {
                g++;
            }


        }
    }


    public Boolean czyPromocja(Towar t){
        int index=towar.indexOf(t);
            return promocja.get(index);
    }

    public void wystawOcene(double oce){
        ocena.add(oce);
        srOcena=0;
        for (int i=0;i<ocena.size();i++){
            srOcena+=ocena.get(i);
        }
        srOcena=srOcena/ocena.size();
    }

    public double getSrOcena() {
        return srOcena;
    }

    public List<Towar> getTowar() {
        return towar;
    }

    public void setTowar(List<Towar> towar) {
        this.towar = towar;
    }
}

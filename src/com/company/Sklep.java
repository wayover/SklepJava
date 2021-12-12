package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sklep {

    float kasa=0;
    float kredyt=0;
    int ile;


    List<Towar>towar= new ArrayList<>();
    List<Towar>ceny= new ArrayList<>();

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


    public void dostawa(){
        for(int i=0;i<towar.size();i++) {
            if(towar.get(i).ilosc>ile * 45){
                towar.get(i).wartosc=ceny.get(i).wartosc*1.02;
                towar.get(i).ilosc+=(ile * 45);
                //System.out.println("Ceny wartosć = "+ceny.get(i).wartosc);
                //System.out.println("towar wartosć = "+towar.get(i).wartosc);
            }else {
                towar.get(i).wartosc=ceny.get(i).wartosc*1.2;
                towar.get(i).ilosc+=(ile * 45);
                //System.out.println("Ceny wartosć = "+ceny.get(i).wartosc);
                //System.out.println("towar wartosć = "+towar.get(i).wartosc);
            }
        }


    }

    public List<Towar> getTowar() {
        return towar;
    }

    public void setTowar(List<Towar> towar) {
        this.towar = towar;
    }
}

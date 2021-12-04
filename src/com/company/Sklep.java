package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sklep {

    float kasa=0;
    float kredyt=0;
    int ile;


    List<Towar>towar;
    Map<Towar,Integer> towary=new HashMap<>();

    Sklep(int ile,List<Towar> towar){
        this.ile=ile;
        this.towar=towar;

        for(int i=0;i<towar.size();i++) {
            towary.put(towar.get(i),0);
        }
    }


    public void dostawa(){
        for(int i=0;i<towar.size();i++) {
            towary.put(towar.get(i), towary.get(towar.get(i)) + (ile * 45));
        }
    }


    public void listatowarow(){
        for(int i=0;i<towary.size();i++){
            System.out.println(towar.get(i).nazwa+" - "+towary.get(towar.get(i)));
        }
    }

}

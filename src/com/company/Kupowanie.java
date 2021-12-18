package com.company;

public class Kupowanie {
    public Klient klient;
        public Sklep sklep;
        public Towar towar;
        int ile;


        public Kupowanie(){};

    public Kupowanie(Sklep sklep, Towar towar, int ile,Klient klient) {
        this.sklep = sklep;
        this.towar = towar;
        this.ile = ile;
        this.klient=klient;
    }

    public Sklep getSklep() {
        return sklep;
    }

    public void setSklep(Sklep sklep) {
        this.sklep = sklep;
    }

    public Towar getTowar() {
        return towar;
    }

    public void setTowar(Towar towar) {
        this.towar = towar;
    }

    public int getIle() {
        return ile;
    }

    public void setIle(int ile) {
        this.ile = ile;
    }
}

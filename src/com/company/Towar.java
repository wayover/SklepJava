package com.company;

public class Towar {

    String nazwa;
    double wartosc;
    int ilosc=0;

    Towar(String nazwa,double wartosc){
        this.nazwa=nazwa;
        this.wartosc=wartosc;
    }

    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(float wartosc) {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}

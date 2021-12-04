package com.company;

public class Towar {

    String nazwa;
    float wartosc;

    Towar(String nazwa,float wartosc){
        this.nazwa=nazwa;
        this.wartosc=wartosc;
    }

    public float getWartosc() {
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

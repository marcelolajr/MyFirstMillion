package com.example.marceloaguiar.myfirstmillion.Model;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public enum MonthValue {
    JANUARY("Janeiro"),
    FEBRUARY("Fevereiro"),
    MARCH("Março"),
    APRIL("Abril"),
    MAY("Maio"),
    JUNE("Junho"),
    JULY("Julho"),
    AUGUST("Agosto"),
    SEPTEMBER("Setembro"),
    OCTOBER("Outubro"),
    NOVEMBER("Novembro"),
    DECEMBER("Dezembro");

    private String mes;
    MonthValue(String mes){
        this.mes = mes;
    }

    @Override
    public String toString() {
        return this.mes;
    }
}

package com.example.marceloaguiar.myfirstmillion.Model;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public enum ReceiptCategory {
    NECESSITY (55, "Necessidade"),
    EDUCATION (10, "Educacao"),
    LONGTEERMINVESTMENT (10, "Investimentos a longo prazo"),
    SHORTTEERMINVESTMENT (10, "Investimentos a curto prazo"),
    FREEDOM (10, "Liberdade"),
    TEST (5, "Teste");

    private Integer percentage;
    private String description;

    ReceiptCategory(Integer percentage, String description) {
        this.percentage = percentage;
        this.description = description;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public String getDescription() {
        return description;
    }

    public Double getPercentageValue() {
        return this.getPercentage() * 1.0/100;
    }
}

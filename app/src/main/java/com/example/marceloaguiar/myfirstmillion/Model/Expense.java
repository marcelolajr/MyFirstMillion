package com.example.marceloaguiar.myfirstmillion.Model;

import java.text.Format;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public class Expense {
    private Double value;
    private String tag;
    private String description;

    private transient NumberFormat format;

    private Expense() {
        Locale ptBr = new Locale("pt", "BR");
        this.format = NumberFormat.getCurrencyInstance(ptBr);
    }

    public static Expense newInstance(Double i, String tag, String description) {
        return new Expense().setValue(i).setTag(tag).setDescription(description);
    }

    public Double getValue() {
        return value;
    }

    public String getValueCurrency() {
        return this.format.format(this.getValue());
    }

    public Expense setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public Expense setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Expense setDescription(String description) {
        this.description = description;
        return this;
    }
}

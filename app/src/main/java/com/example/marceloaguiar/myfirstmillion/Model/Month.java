package com.example.marceloaguiar.myfirstmillion.Model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public class Month {

    private Double value;
    private MonthValue monthValue;
    private Integer year;
    private HashMap<ReceiptCategory,Double> receiptValues;
    private HashMap<ReceiptCategory,List<Expense>> receiptExpenses;

    private transient NumberFormat format;

    private Month() {
        Locale ptBr = new Locale("pt", "BR");
        this.format = NumberFormat.getCurrencyInstance(ptBr);
        this.receiptValues = new HashMap<>();
        this.receiptExpenses = new HashMap<>();
    }

    public static Month newInstance(double value, MonthValue monthValue, int year) {
        return new Month().setValue(value).setMonthValue(monthValue).setYear(year)
                .setReceiptValues().setReceiptExpenses();
    }

    public Double getValue() {
        return value;
    }

    public Month setValue(Double value) {
        this.value = value;
        return this;
    }

    public MonthValue getMonthValue() {
        return monthValue;
    }

    public Month setMonthValue(MonthValue monthValue) {
        this.monthValue = monthValue;
        return this;
    }

    private Month setReceiptValues() {
        for (ReceiptCategory receipts:
             ReceiptCategory.values()) {
            this.receiptValues.put(receipts,receipts.getPercentageValue()*this.getValue());
        }
        return this;
    }

    private Month setReceiptExpenses() {
        for (ReceiptCategory receipts:
                ReceiptCategory.values()) {
            this.receiptExpenses.put(receipts,new ArrayList<Expense>());
        }
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Month setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getValueFormatted() {
        return this.format.format(this.getValue());
    }

    public Double getCategoryReceiptValue(ReceiptCategory necessity) {
        return this.receiptValues.get(necessity);
    }

    public List<Expense> getCategoryReceiptExpenses(ReceiptCategory necessity) {
        return this.receiptExpenses.get(necessity);
    }

    public HashMap<ReceiptCategory, Double> getReceiptValues() {
        return receiptValues;
    }
}

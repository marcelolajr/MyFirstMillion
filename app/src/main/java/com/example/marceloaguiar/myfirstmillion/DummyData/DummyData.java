package com.example.marceloaguiar.myfirstmillion.DummyData;

import com.example.marceloaguiar.myfirstmillion.Model.Month;
import com.example.marceloaguiar.myfirstmillion.Model.MonthValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public class DummyData {
    public List<Month> months;
    public DummyData() {
        this.months = new ArrayList<>();
        this.months.add(Month.newInstance(2000, MonthValue.DECEMBER,2016));
        this.months.add(Month.newInstance(2000, MonthValue.NOVEMBER,2014));
    }

}

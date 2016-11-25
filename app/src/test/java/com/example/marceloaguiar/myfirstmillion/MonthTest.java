package com.example.marceloaguiar.myfirstmillion;

import com.example.marceloaguiar.myfirstmillion.Model.Expense;
import com.example.marceloaguiar.myfirstmillion.Model.Month;
import com.example.marceloaguiar.myfirstmillion.Model.MonthValue;
import com.example.marceloaguiar.myfirstmillion.Model.ReceiptCategory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public class MonthTest {
    @Test
    public void newMonthValue(){
        Month month = Month.newInstance(2000.0, MonthValue.JANUARY,2014);
        assertEquals((Double) 2000.0, month.getValue());
    }
    @Test
    public void newMonthValueFormatted(){
        Month month = Month.newInstance(2000.0, MonthValue.JANUARY,2014);
        assertEquals("R$ 2.000,00", month.getValueFormatted());
    }
    @Test
    public void newMonthMonthValue(){
        Month month = Month.newInstance(2000.0, MonthValue.JANUARY,2014);
        assertEquals(MonthValue.JANUARY, month.getMonthValue());
    }
    @Test
    public void newMonthYear(){
        Month month = Month.newInstance(2000.0, MonthValue.JANUARY,2014);
        assertEquals((Integer) 2014, month.getYear());
    }

    @Test
    public void newMonthCategoryReceiptQuantity(){
        Month month = Month.newInstance(2000.0, MonthValue.JANUARY,2014);
        assertEquals(ReceiptCategory.values().length, month.getReceiptValues().size());
    }

    @Test
    public void newMonthCategoryReceiptValue(){
        Month month = Month.newInstance(2000.0, MonthValue.JANUARY,2014);
        assertEquals((Double) (ReceiptCategory.NECESSITY.getPercentageValue()*2000.0), month.getCategoryReceiptValue(ReceiptCategory.NECESSITY));
    }

    @Test
    public void newMonthCategoryReceiptExpenses(){
        Month month = Month.newInstance(2000.0, MonthValue.JANUARY,2014);
        assertEquals(0,month.getCategoryReceiptExpenses(ReceiptCategory.NECESSITY).size());
    }

    @Test
    public void calculateTotalBalance(){
        Month month = Month.newInstance(2000.0, MonthValue.JANUARY,2014);
        Expense expense = Expense.newInstance(20.0,"Bla","Bla2");
        month.addExpense(ReceiptCategory.NECESSITY, expense);
        assertEquals((Double) 1980.0,month.calculateTotalBalance());
    }

}

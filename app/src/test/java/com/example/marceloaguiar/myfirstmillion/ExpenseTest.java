package com.example.marceloaguiar.myfirstmillion;

import com.example.marceloaguiar.myfirstmillion.Model.Expense;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by marceloaguiar on 11/24/16.
 */

public class ExpenseTest {
    @Test
    public void newExpenseValueFormatted() {
        Expense expense = Expense.newInstance(20.0,"Energia","Conta de Energia");

        assertEquals("R$ 20,00", expense.getValueCurrency());
    }
    @Test
    public void newExpenseTag() {
        Expense expense = Expense.newInstance(20.0,"Energia","Conta de Energia");

        assertEquals("Energia", expense.getTag());
    }
    @Test
    public void newExpenseDescription() {
        Expense expense = Expense.newInstance(20.0,"Energia","Conta de Energia");

        assertEquals("Conta de Energia", expense.getDescription());
    }
    @Test
    public void newExpenseValue(){
        Expense expense = Expense.newInstance(20.0,"Energia","Conta de Energia");

        assertEquals((Double) 20.0, expense.getValue());
    }
    @Test
    public void editExpenseValue(){
        Expense expense = Expense.newInstance(20.0,"Energia","Conta de Energia");
        expense.setValue(30.0);
        assertEquals((Double) 30.0, expense.getValue());
    }

    @Test
    public void editExpenseTag(){
        Expense expense = Expense.newInstance(20.0,"Energia","Conta de Energia");
        expense.setTag("Colégio");
        assertEquals("Colégio", expense.getTag());
    }

    @Test
    public void editExpenseDescription(){
        Expense expense = Expense.newInstance(20.0,"Energia","Conta de Energia");
        expense.setDescription("Conta Atrasada");
        assertEquals("Conta Atrasada", expense.getDescription());
    }

}

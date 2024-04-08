package com.mydata.Service;

import java.util.List;
import java.util.Map;

import com.mydata.Model.Expense;

public interface ExpenseService {

	Expense saveExpense(Expense expense);
	
    public List<Expense> getDataBetweenDates(String startDate, String endDate);
    
    List<Expense>getExpenseBetweenDates(String StartDate,String EndDate);
    
    Map<String, Double> calculateDailyExpenses(String startDate, String endDate);
    
    List<Expense> getExpensesByTypeAndDate(String expenseType, String startDate, String endDate);
 }
    

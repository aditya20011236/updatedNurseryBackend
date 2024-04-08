package com.mydata.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.Model.Expense;
import com.mydata.Repository.Expancerepository;

@Service
public class Exepenseserviceimpl implements ExpenseService {
	@Autowired
	Expancerepository expancerepository;

	@Override
	public Expense saveExpense(Expense expense) {
		return expancerepository.save(expense);
	}

	@Override
	public List<Expense> getDataBetweenDates(String startDate, String endDate) {
		return expancerepository.getDataBetweenDates(startDate, endDate);
	}

	@Override
	public List<Expense> getExpenseBetweenDates(String StartDate, String EndDate) {
		return expancerepository.findByDateBetween(StartDate, EndDate);
	}

	@Override
	public Map<String, Double> calculateDailyExpenses(String startDate, String endDate) {
		List<Expense> expenses = expancerepository.findByDateBetween(startDate, endDate);
		Map<String, Double> dailyExpenses = new HashMap<>();

		for (Expense expense : expenses) {
			String date =expense.getDate();
			double amount = Double.parseDouble(expense.getGrandTotal());
			dailyExpenses.merge(date, amount, Double::sum);
		}

		return dailyExpenses;
	}

	@Override
	public List<Expense> getExpensesByTypeAndDate(String expenseType, String startDate, String endDate) {
		if (expenseType.isEmpty()) {
            return expancerepository.getDataBetweenDates(startDate, endDate);
        } else {
            return expancerepository.findByExpenseTypeAndDateBetween(expenseType, startDate, endDate);
        }
	}
}
	


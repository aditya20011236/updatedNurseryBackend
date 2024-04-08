package com.mydata.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mydata.Service.ExpenseService;
import com.mydata.Model.Expense;

@CrossOrigin
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@PostMapping
	public Expense createInvoice(@RequestBody Expense expense) {
		return expenseService.saveExpense(expense);
	}
	/*
	 * @GetMapping("/getDataBetweenDate") public List<Expense>
	 * getDataBetweenDates(@RequestParam String startDate, @RequestParam String
	 * endDate) { return expenseService.getDataBetweenDates(startDate, endDate); }
	 */
//
//	@GetMapping("/getDataBetweenDates")
//	public List<Expense> getDataBetweenDates(@RequestParam String startDate, @RequestParam String endDate) {
//		return expenseService.getDataBetweenDates(startDate, endDate);
//
//	}

	@GetMapping("/expenses/getDataBetweenDates/date")
	public List<Expense> getExpensesBetweenDates(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return expenseService.getDataBetweenDates(startDate, endDate);
	}

	@GetMapping("/getDataBetweenDates")
	public List<Expense> getDataBetweenDates(@RequestParam String startDate, @RequestParam String endDate,
			@RequestParam(required = false) String expenseType) {
		return expenseService.getExpensesByTypeAndDate(expenseType, startDate, endDate);
	}
}
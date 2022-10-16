package com.expense.service;

import java.util.List;

import com.expense.model.Expense;

public interface ExpenseService {

	List<Expense> getdate();
	
	Expense save(Expense expense);
	
	Expense getbyid(Long id);
	
	void delete(Long id);
}

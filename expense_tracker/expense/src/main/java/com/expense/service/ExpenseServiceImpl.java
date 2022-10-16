package com.expense.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expense.Repository.ExpenseRepo;
import com.expense.model.Expense;

@Service
public class ExpenseServiceImpl implements ExpenseService {

	@Autowired
	private ExpenseRepo expenseRepo;
	
	
	
	@Override
	public List<Expense> getdate() {
		return expenseRepo.findAll();
	}

	@Override
	public Expense save(Expense expense) {
		expenseRepo.save(expense);
		return expense;
	}

	@Override
	public Expense getbyid(Long id) {
		if(expenseRepo.findById(id).isPresent());
		return expenseRepo.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		Expense expo= getbyid(id);
		expenseRepo.delete(expo);
	}

}

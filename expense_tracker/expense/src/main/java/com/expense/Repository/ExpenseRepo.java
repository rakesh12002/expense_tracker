package com.expense.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expense.model.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

	
}

package com.expense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expense.model.Expense;
import com.expense.service.ExpenseService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public ResponseEntity<List<Expense>> get(){
		List<Expense> getalldata=expenseService.getdate();
		return new ResponseEntity<List<Expense>>(getalldata,HttpStatus.OK);	
	}
	
	@PostMapping("/expenses")
	public ResponseEntity<Expense> save(@RequestBody Expense expense){
		Expense adddata=expenseService.save(expense);
		return new ResponseEntity<Expense>(adddata,HttpStatus.OK);
	}
	
	@GetMapping("/expenses/{id}")
	public ResponseEntity<Expense> get(@PathVariable("id") Long id){
		Expense Expensebyid=expenseService.getbyid(id);
		return new ResponseEntity<Expense>(Expensebyid,HttpStatus.OK);
	}
	
	@DeleteMapping("/expenses/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id){
		expenseService.delete(id);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
	}
	
}

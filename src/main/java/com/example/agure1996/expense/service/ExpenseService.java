package com.example.agure1996.expense.service;

import com.example.agure1996.expense.model.Expense;
import com.example.agure1996.expense.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {


    @Autowired
    private ExpenseRepository expenseRepository;

    /**
     * Create an Expense
     */
    public Expense newExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    /**
     * Get all Expenses
     */
    public Iterable<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }


    /**
     * Get Expense by Id
     */
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    /**
     * Update Expense
     */

    public Expense updateExpense(Long id, Expense expenseDetails) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            Expense existingExpense = expense.get();
            existingExpense.setDescription(expenseDetails.getDescription());
            existingExpense.setExpenseDate(expenseDetails.getExpenseDate());
            return expenseRepository.save(existingExpense);
        }
        return null;
    }

    /**
     * Delete All Expenses
     */

    public void deleteAllExpenses() {

        expenseRepository.deleteAll();
    }

    /**
     * Delete Expense
     */
    public void deleteExpense(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) expenseRepository.deleteById(id);
    }


}

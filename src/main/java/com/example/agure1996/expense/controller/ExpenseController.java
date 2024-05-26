package com.example.agure1996.expense.controller;

import com.example.agure1996.expense.model.Expense;
import com.example.agure1996.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/expenses")
public class ExpenseController {


    private ExpenseService expenseService;


    /**
     * Post - Create Expense
     *
     * @param expense
     * @return
     */
    @PostMapping("/newExpense")
    public Expense newExpense(@RequestBody Expense expense) {
        return expenseService.newExpense(expense);
    }

    /**
     * GET all Expenses
     *
     * @return
     */
    @GetMapping("/getAllExpenses")
    public Iterable<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    /**
     * GET - Expense by ID
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Optional<Expense> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    /**
     * Update - Expense details
     *
     * @param id
     * @param expenseDetails
     * @return
     */
    @PutMapping("/{id}")
    public Expense updateExpense(@PathVariable Long id, @RequestBody Expense expenseDetails) {
        return expenseService.updateExpense(id, expenseDetails);
    }

    /**
     * Delete - Expense by id
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteExpenseById(@PathVariable long id) {
        expenseService.deleteExpense(id);

    }

    /**
     * DELETE - All Expense
     */
    @DeleteMapping("/deleteAllExpenses")
    public void deleteAllExpenses() {
        expenseService.deleteAllExpenses();
    }


}

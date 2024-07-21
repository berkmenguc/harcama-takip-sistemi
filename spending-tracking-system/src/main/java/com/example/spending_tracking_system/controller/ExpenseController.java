package com.example.spending_tracking_system.controller;

import com.example.spending_tracking_system.models.Expense;
import com.example.spending_tracking_system.models.User;
import com.example.spending_tracking_system.service.ExpenseServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    private final ExpenseServiceImpl service;
    @GetMapping("/get-all")
    public List<Expense> getAll(){
        return service.getAll();
    }
    @GetMapping("/{expenseId}")
    public Expense getById(@PathVariable("expenseId") Long expenseId){
        return service.getExpenseById(expenseId);
    }
    @GetMapping("/total/{userId}")
    public Double getTotal(@PathVariable("userId") Long userId){
        return service.getTotalByUserId(userId);
    }
    @DeleteMapping("/{expenseId}")
    public void deleteById(@PathVariable("expenseId") Long expenseId){
        service.deleteById(expenseId);
    }
    @PostMapping("/create")
    public Expense createNewExpense(@RequestBody Expense expense){
        return service.createExpense(expense);
    }
    @PutMapping("/{expenseId}")
    public Expense updateExpense(@PathVariable("expenseId") Long expenseId, @RequestBody Expense expense){
        return service.updateExpense(expenseId , expense);
    }
}

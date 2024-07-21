package com.example.spending_tracking_system.controller;

import com.example.spending_tracking_system.models.Expense;
import com.example.spending_tracking_system.models.User;
import com.example.spending_tracking_system.service.ExpenseServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
@Api(value = "Expenses Management", description = "Expense operations")

public class ExpenseController {

    private final ExpenseServiceImpl service;
    @GetMapping("/get-all")
    @ApiOperation(value = "View a list of all available expenses", response = List.class)
    public List<Expense> getAll(){
        return service.getAll();
    }
    @GetMapping("/{expenseId}")
    @ApiOperation(value = "Find Expense by id")
    public Expense getById(@PathVariable("expenseId") Long expenseId){
        return service.getExpenseById(expenseId);
    }
    @GetMapping("/total/{userId}")
    @ApiOperation(value = "Find Total Expense by id")
    public Double getTotal(@PathVariable("userId") Long userId){
        return service.getTotalByUserId(userId);
    }
    @DeleteMapping("/{expenseId}")
    @ApiOperation(value = "Delete expense by id")
    public void deleteById(@PathVariable("expenseId") Long expenseId){
        service.deleteById(expenseId);
    }
    @PostMapping("/create")
    @ApiOperation(value = "Create new expense")
    public Expense createNewExpense(@RequestBody Expense expense){
        return service.createExpense(expense);
    }
    @PutMapping("/{expenseId}")
    @ApiOperation(value = "Update expense by id")
    public Expense updateExpense(@PathVariable("expenseId") Long expenseId, @RequestBody Expense expense){
        return service.updateExpense(expenseId , expense);
    }
}

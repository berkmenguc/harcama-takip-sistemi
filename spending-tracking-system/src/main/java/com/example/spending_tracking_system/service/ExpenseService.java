package com.example.spending_tracking_system.service;

import com.example.spending_tracking_system.models.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> getAll();
    Expense getExpenseById(Long expenseId);
    void deleteById(Long expenseId);

    Expense createExpense(Expense expense);

    Expense updateExpense(Long expenseId, Expense expense);

    Double getTotalByUserId(Long userId);
}

package com.example.spending_tracking_system.service;

import com.example.spending_tracking_system.models.Expense;
import com.example.spending_tracking_system.models.User;
import com.example.spending_tracking_system.repository.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService{
    private final ExpenseRepository repository;
    @Override
    public List<Expense> getAll() {
        return repository.findAll();
    }

    @Override
    public Expense getExpenseById(Long expenseId) {
        return repository.findById(expenseId).orElse(null) ;
    }

    @Override
    public void deleteById(Long expenseId) {
        repository.deleteById(expenseId);
    }

    @Override
    public Expense createExpense(Expense expense) {
        return repository.save(expense);
    }

    @Override
    public Expense updateExpense(Long expenseId, Expense expense) {
        Optional<Expense> exp = repository.findById(expenseId);
        if(exp.isPresent()){
            Expense foundExp = exp.get();
            foundExp.setAmount(expense.getAmount());
            foundExp.setDate(expense.getDate());
            foundExp.setUser(expense.getUser());
            return  foundExp;
        } else {
            return null;
        }
    }

    @Override
    public Double getTotalByUserId(Long userId) {

        return repository.findTotalExpenseByUserId(userId);
    }

}

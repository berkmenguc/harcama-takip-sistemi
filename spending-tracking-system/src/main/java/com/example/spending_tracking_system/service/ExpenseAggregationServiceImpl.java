package com.example.spending_tracking_system.service;

import com.example.spending_tracking_system.models.Expense;
import com.example.spending_tracking_system.models.User;
import com.example.spending_tracking_system.repository.ExpenseRepository;
import com.example.spending_tracking_system.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
@AllArgsConstructor
public class ExpenseAggregationServiceImpl implements ExpenseAggregationService{

    private final UserRepository userRepository;

    private final ExpenseRepository expenseRepository;

    @Override
    public void aggregateUserExpensesDaily() {
        List<User> users = userRepository.findAll();
        LocalDate today = LocalDate.now();
        for (User user : users) {
            List<Expense> dailyExpenses = expenseRepository.findByUserAndDateBetween(user, today, today);
            double total = dailyExpenses.stream().mapToDouble(Expense::getAmount).sum();

            System.out.println("User: " + user.getUserName() + " - Daily Total: " + total);
        }
    }

    @Override
    public void aggregateUserExpensesWeekly() {
        List<User> users = userRepository.findAll();
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        LocalDate endOfWeek = today.with(TemporalAdjusters.nextOrSame(java.time.DayOfWeek.SUNDAY));
        for (User user : users) {
            List<Expense> weeklyExpenses = expenseRepository.findByUserAndDateBetween(user, startOfWeek, endOfWeek);
            double total = weeklyExpenses.stream().mapToDouble(Expense::getAmount).sum();
            System.out.println("User: " + user.getUserName() + " - Weekly Total: " + total);
        }
    }

    @Override
    public void aggregateUserExpensesMonthly() {
        List<User> users = userRepository.findAll();
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endOfMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        for (User user : users) {
            List<Expense> monthlyExpenses = expenseRepository.findByUserAndDateBetween(user, startOfMonth, endOfMonth);
            double total = monthlyExpenses.stream().mapToDouble(Expense::getAmount).sum();
            System.out.println("User: " + user.getUserName() + " - Monthly Total: " + total);
        }
    }
    }


package com.example.spending_tracking_system.service;

public interface ExpenseAggregationService {
    void aggregateUserExpensesDaily();

    void aggregateUserExpensesWeekly();

    void aggregateUserExpensesMonthly();
}

package com.example.spending_tracking_system.scheduled;

import com.example.spending_tracking_system.service.ExpenseAggregationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledOperations {
    @Autowired
    private ExpenseAggregationService expenseAggregationService;

    @Scheduled(cron = "0 0 0 * * ?") //GÜNLÜK
    public void aggregateDailyExpenses() {
        expenseAggregationService.aggregateUserExpensesDaily();
    }

    @Scheduled(cron = "0 0 0 * * MON") //HAFTALIK
    public void aggregateWeeklyExpenses() {
        expenseAggregationService.aggregateUserExpensesWeekly();
    }

    @Scheduled(cron = "0 0 0 1 * ?") //AYLIK
    public void aggregateMonthlyExpenses() {
        expenseAggregationService.aggregateUserExpensesMonthly();
    }
}

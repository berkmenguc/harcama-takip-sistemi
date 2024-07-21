package com.example.spending_tracking_system.repository;

import com.example.spending_tracking_system.models.Expense;
import com.example.spending_tracking_system.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId")
    Double findTotalExpenseByUserId(@Param("userId") Long userId);

    List<Expense> findByUserAndDateBetween(User user, LocalDate startDate, LocalDate endDate);
}

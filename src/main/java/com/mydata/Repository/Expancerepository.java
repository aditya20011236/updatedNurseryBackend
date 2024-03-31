package com.mydata.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mydata.Model.Expense;

public interface Expancerepository extends JpaRepository<Expense, Long>{
	@Query("SELECT e FROM Expense e WHERE e.date BETWEEN :startDate AND :endDate")
	 public List<Expense> getDataBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);
	
	List<Expense> findByDateBetween(String startDate, String endDate);
}

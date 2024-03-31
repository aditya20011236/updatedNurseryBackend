package com.mydata.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mydata.Model.Expense;
import com.mydata.Model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

	@Query("SELECT e FROM Invoice e WHERE e.date BETWEEN :startDate AND :endDate")
	public List<Invoice> getDataBetweenDates(@Param("startDate") String startDate, @Param("endDate") String endDate);

	List<Invoice> findByDateBetween(String startDate, String endDate);

	Invoice findTopByOrderByInvoiceNoDesc();
}

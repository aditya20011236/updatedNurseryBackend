package com.mydata.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mydata.Model.Advacebooking;

public interface AdvanceBookingRepo extends JpaRepository<Advacebooking, Long> {

	@Query("SELECT MAX(a.invoiceNumber) FROM Advacebooking a")
	Integer findMaxInvoiceNumber();

	@Query("SELECT a FROM Advacebooking a")
	List<Advacebooking> findAllAdvanceBookings();

}

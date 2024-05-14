package com.mydata.Service;

import java.util.List;
import java.util.Map;

import com.mydata.Model.Advacebooking;
import com.mydata.Model.Invoice;

public interface AdvanceBookingservice {

	Advacebooking saveInvoice(Advacebooking advacebooking);

	int getLatestInvoiceNumber();
	
	 List<Advacebooking> viewallBooking();
	 
	 public void deleteBookingbyid(Long id);
	 
	 Advacebooking getBookingById(Long id);

}

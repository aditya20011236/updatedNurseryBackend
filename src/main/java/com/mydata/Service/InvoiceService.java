package com.mydata.Service;

import java.util.List;
import java.util.Map;

import com.mydata.Model.Invoice;
import com.mydata.Model.Product;

public interface InvoiceService {
	Invoice saveInvoice(Invoice invoice);

	public List<Invoice> getDataBetweenDates(String startDate, String endDate);

	List<Invoice> getInvoicesBetweenDates(String startDate, String endDate);

	Map<String, Double> calculateDailyInvoices(String startDate, String endDate);

//    public Invoice saveInvoiceAndUpdateProducts(Invoice invoice);
//
//	public void init();

	public int getLatestInvoiceNumber();

	List<Invoice>getAllinvoices();
}

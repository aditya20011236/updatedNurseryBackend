package com.mydata.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.Model.Invoice;
import com.mydata.Model.Product;
import com.mydata.Model.Products;
import com.mydata.Repository.InvoiceRepository;
import com.mydata.Repository.ProductRepository;
import com.mydata.Repository.ProductsRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;

	private int lastInvoiceNumber = 0;

	@Override
	public Invoice saveInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	@Override
	public List<Invoice> getDataBetweenDates(String startDate, String endDate) {
		return invoiceRepository.getDataBetweenDates(startDate, endDate);
	}

	@Override
	public List<Invoice> getInvoicesBetweenDates(String startDate, String endDate) {
		return invoiceRepository.findByDateBetween(startDate, endDate);
	}

	@Override
	public Map<String, Double> calculateDailyInvoices(String startDate, String endDate) {
		List<Invoice> invoices = invoiceRepository.findByDateBetween(startDate, endDate);
		Map<String, Double> dailyInvoices = new HashMap<>();

		for (Invoice invoice : invoices) {
			String date = invoice.getDate();
			double amount = Double.parseDouble(invoice.getGrandtotal());
			dailyInvoices.merge(date, amount, Double::sum);
		}

		return dailyInvoices;

	}

	 @PostConstruct
	    public void init() {
	        // Initialize the last invoice number when the application starts
	        Invoice latestInvoice = invoiceRepository.findTopByOrderByInvoiceNoDesc();
	        if (latestInvoice != null) {
	            lastInvoiceNumber = latestInvoice.getInvoiceNo();
	        }
	    }

	    public int getNextInvoiceNumber() {
	        // Increment the last invoice number and save it to the database
	        lastInvoiceNumber++;
	        invoiceRepository.save(new Invoice(lastInvoiceNumber));
	        return lastInvoiceNumber;
	    }
	}
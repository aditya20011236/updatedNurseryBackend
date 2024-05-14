package com.mydata.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.Model.Advacebooking;
import com.mydata.Repository.AdvanceBookingRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class Advancebookingserviceimpl implements AdvanceBookingservice {

	private int lastInvoiceNumber = 0;

	@Autowired
	private AdvanceBookingRepo advanceBookingRepo;

	@Override
	public Advacebooking saveInvoice(Advacebooking advacebooking) {
		if (advacebooking.getInvoiceNumber() == null) {
			int latestInvoiceNumber = getLatestInvoiceNumber();
			long newInvoiceNumber = latestInvoiceNumber + 1;
			advacebooking.setInvoiceNumber(newInvoiceNumber);

		}
		return advanceBookingRepo.save(advacebooking);

	}

	public int getLatestInvoiceNumber() {
		Integer maxInvoiceNumber = advanceBookingRepo.findMaxInvoiceNumber();
		return maxInvoiceNumber != null ? maxInvoiceNumber : 0;
	}

	@Override
	public List<Advacebooking> viewallBooking() {
		return advanceBookingRepo.findAllAdvanceBookings();
	}

	@Override
	public void deleteBookingbyid(Long id) {
		advanceBookingRepo.deleteById(id);
		
	}
	 @Override
	    public Advacebooking getBookingById(Long id) {
	        return advanceBookingRepo.findById(id).orElse(null);
	    }

	

	
	}



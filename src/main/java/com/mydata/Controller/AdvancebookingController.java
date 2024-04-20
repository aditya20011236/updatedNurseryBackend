package com.mydata.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mydata.Model.Advacebooking;
import com.mydata.Service.AdvanceBookingservice;

@CrossOrigin
@Controller
public class AdvancebookingController {
    @Autowired
    private AdvanceBookingservice advanceBookingservice;

    @PostMapping("/saveadvanceBooking")
    public ResponseEntity<Advacebooking> createInvoice(@RequestBody Advacebooking invoice) {
        try {
            Advacebooking savedInvoice = advanceBookingservice.saveInvoice(invoice);
            return ResponseEntity.ok(savedInvoice);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/latest")
    public ResponseEntity<Integer> getLatestInvoiceNumber() {
        try {
            int latestInvoiceNo = advanceBookingservice.getLatestInvoiceNumber();
            return ResponseEntity.ok(latestInvoiceNo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1);
        }
    }

    @GetMapping("/viewalladvancebooking")
    public ResponseEntity<List<Advacebooking>> showallbooking() {
        try {
            List<Advacebooking> bookings = advanceBookingservice.viewallBooking();
            return ResponseEntity.ok(bookings);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/booking/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        try {
            advanceBookingservice.deleteBookingbyid(id);
            return ResponseEntity.ok("Booking deleted successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting booking: " + e.getMessage());
        }
    }
}

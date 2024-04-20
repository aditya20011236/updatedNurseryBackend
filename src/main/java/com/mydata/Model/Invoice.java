package com.mydata.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerName;
	private String customerAddress;
	private Long invoiceNumber;
	private String date;
	private String amountPaid;
	private String remainingAmount;
	private String paymentMode;
	private String discount;
	private String grandtotal;
	private String mobileNumber;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "invoice_id")
	private List<Product> products;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public Long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(Long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(String remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getGrandtotal() {
		return grandtotal;
	}
	public void setGrandtotal(String grandtotal) {
		this.grandtotal = grandtotal;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Invoice(Long id, String customerName, String customerAddress, Long invoiceNumber, String date,
			String amountPaid, String remainingAmount, String paymentMode, String discount, String grandtotal,
			String mobileNumber, List<Product> products) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.invoiceNumber = invoiceNumber;
		this.date = date;
		this.amountPaid = amountPaid;
		this.remainingAmount = remainingAmount;
		this.paymentMode = paymentMode;
		this.discount = discount;
		this.grandtotal = grandtotal;
		this.mobileNumber = mobileNumber;
		this.products = products;
	}
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", customerName=" + customerName + ", customerAddress=" + customerAddress
				+ ", invoiceNumber=" + invoiceNumber + ", date=" + date + ", amountPaid=" + amountPaid
				+ ", remainingAmount=" + remainingAmount + ", paymentMode=" + paymentMode + ", discount=" + discount
				+ ", grandtotal=" + grandtotal + ", mobileNumber=" + mobileNumber + ", products=" + products + "]";
	}
	
	
}
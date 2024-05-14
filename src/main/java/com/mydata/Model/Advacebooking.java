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
public class Advacebooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String customerName;
	private String customerAddress;
	private Long invoiceNumber;
	private String date;
    private String deliveryDate; 
	private String amountPaid;
	private String remainingAmount;
	private String status;
	private String paymentMode;
	private String discount;
	private String grandTotal;
	private String mobileNumber;
	private String invoiceType;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Advacebooking_id")
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
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Advacebooking(Long id, String customerName, String customerAddress, Long invoiceNumber, String date,
			String deliveryDate, String amountPaid, String remainingAmount, String status, String paymentMode,
			String discount, String grandTotal, String mobileNumber, String invoiceType, List<Product> products) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.invoiceNumber = invoiceNumber;
		this.date = date;
		this.deliveryDate = deliveryDate;
		this.amountPaid = amountPaid;
		this.remainingAmount = remainingAmount;
		this.status = status;
		this.paymentMode = paymentMode;
		this.discount = discount;
		this.grandTotal = grandTotal;
		this.mobileNumber = mobileNumber;
		this.invoiceType = invoiceType;
		this.products = products;
	}
	public Advacebooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Advacebooking [id=" + id + ", customerName=" + customerName + ", customerAddress=" + customerAddress
				+ ", invoiceNumber=" + invoiceNumber + ", date=" + date + ", deliveryDate=" + deliveryDate
				+ ", amountPaid=" + amountPaid + ", remainingAmount=" + remainingAmount + ", status=" + status
				+ ", paymentMode=" + paymentMode + ", discount=" + discount + ", grandTotal=" + grandTotal
				+ ", mobileNumber=" + mobileNumber + ", invoiceType=" + invoiceType + ", products=" + products + "]";
	}

	

}
	
package com.mydata.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Customer {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String date;
	private String customerName;
	private String customerAddress;
	private String customerPhoneNumber;
	private String deliveryDate;
	private double advancePayment;
	private double grandTotal;
	private double remainingPayment;
	private double discount;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "Customer_id")
	private List<Plant> plants;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getAdvancePayment() {
		return advancePayment;
	}

	public void setAdvancePayment(double advancePayment) {
		this.advancePayment = advancePayment;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public double getRemainingPayment() {
		return remainingPayment;
	}

	public void setRemainingPayment(double remainingPayment) {
		this.remainingPayment = remainingPayment;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public List<Plant> getPlants() {
		return plants;
	}

	public void setPlants(List<Plant> plants) {
		this.plants = plants;
	}

	public Customer(Long id, String date, String customerName, String customerAddress, String customerPhoneNumber,
			String deliveryDate, double advancePayment, double grandTotal, double remainingPayment, double discount,
			List<Plant> plants) {
		super();
		this.id = id;
		this.date = date;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhoneNumber = customerPhoneNumber;
		this.deliveryDate = deliveryDate;
		this.advancePayment = advancePayment;
		this.grandTotal = grandTotal;
		this.remainingPayment = remainingPayment;
		this.discount = discount;
		this.plants = plants;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

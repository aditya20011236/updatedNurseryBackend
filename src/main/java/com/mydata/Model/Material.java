package com.mydata.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String materialName;
    private double pricePerUnit;
    private int quantity;
    private double total;
    private String expenseDetails;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getExpenseDetails() {
		return expenseDetails;
	}
	public void setExpenseDetails(String expenseDetails) {
		this.expenseDetails = expenseDetails;
	}
	public Material(Long id, String materialName, double pricePerUnit, int quantity, double total,
			String expenseDetails) {
		super();
		this.id = id;
		this.materialName = materialName;
		this.pricePerUnit = pricePerUnit;
		this.quantity = quantity;
		this.total = total;
		this.expenseDetails = expenseDetails;
	}
	public Material() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
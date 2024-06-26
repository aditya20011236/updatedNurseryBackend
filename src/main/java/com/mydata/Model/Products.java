package com.mydata.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Products  {
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String productName;
    private Date date;
    private int availableQuantity;
    private double mfgPrice;
    private double sellingPrice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAvailableQuantity() {
		return availableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}
	public double getMfgPrice() {
		return mfgPrice;
	}
	@Override
	public String toString() {
		return "Products [id=" + id + ", productName=" + productName + ", date=" + date + ", availableQuantity="
				+ availableQuantity + ", mfgPrice=" + mfgPrice + ", sellingPrice=" + sellingPrice + "]";
	}
	public void setMfgPrice(double mfgPrice) {
		this.mfgPrice = mfgPrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public Products(Long id, String productName, Date date, int availableQuantity, double mfgPrice,
			double sellingPrice) {
		super();
		this.id = id;
		this.productName = productName;
		this.date = date;
		this.availableQuantity = availableQuantity;
		this.mfgPrice = mfgPrice;
		this.sellingPrice = sellingPrice;
	}
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

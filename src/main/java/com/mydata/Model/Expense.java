//package com.mydata.Model;
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.OneToMany;
//
//@Entity
//public class Expense {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String date;
//
//    private String grandTotal;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "expense_id")
//    private List<Material> materials;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getDate() {
//		return date;
//	}
//
//	public void setDate(String date) {
//		this.date = date;
//	}
//
//	public String getGrandTotal() {
//		return grandTotal;
//	}
//
//	public void setGrandTotal(String grandTotal) {
//		this.grandTotal = grandTotal;
//	}
//
//	public List<Material> getMaterials() {
//		return materials;
//	}
//
//	public void setMaterials(List<Material> materials) {
//		this.materials = materials;
//	}
//
//	public Expense(Long id, String date, String grandTotal, List<Material> materials) {
//		super();
//		this.id = id;
//		this.date = date;
//		this.grandTotal = grandTotal;
//		this.materials = materials;
//	}
//
//	public Expense() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public String toString() {
//		return "Expense [id=" + id + ", date=" + date + ", grandTotal=" + grandTotal + ", materials=" + materials + "]";
//	}
//
//
//}



package com.mydata.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name="Expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String expenseType;

    private String grandTotal;

    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "expense_id")
    private List<Material> materials;


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


	public String getExpenseType() {
		return expenseType;
	}


	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}


	public String getGrandTotal() {
		return grandTotal;
	}


	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}


	public List<Material> getMaterials() {
		return materials;
	}


	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}


	public Expense(Long id, String date, String expenseType, String grandTotal, List<Material> materials) {
		super();
		this.id = id;
		this.date = date;
		this.expenseType = expenseType;
		this.grandTotal = grandTotal;
		this.materials = materials;
	}


	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Expense [id=" + id + ", date=" + date + ", expenseType=" + expenseType + ", grandTotal=" + grandTotal
				+ ", materials=" + materials + "]";
	}

	
	
}

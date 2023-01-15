package com.example.demo.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="CUSTOMER_MANAGEMENT_TABLE")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custId;
	private String custName;
	private String custFirstName;
	private String custMiddleName;
	private String custLastName;
	private String custEmail;
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustFirstName() {
		return custFirstName;
	}
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}
	public String getCustMiddleName() {
		return custMiddleName;
	}
	public void setCustMiddleName(String custMiddleName) {
		this.custMiddleName = custMiddleName;
	}
	public String getCustLastName() {
		return custLastName;
	}
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custFirstName=" + custFirstName
				+ ", custMiddleName=" + custMiddleName + ", custLastName=" + custLastName + ", custEmail=" + custEmail
				+ "]";
	}
	public Customer(int custId, String custName, String custFirstName, String custMiddleName, String custLastName,
			String custEmail) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custFirstName = custFirstName;
		this.custMiddleName = custMiddleName;
		this.custLastName = custLastName;
		this.custEmail = custEmail;
	}
	public Customer() {
		super();
	}
	
	

	

	

}

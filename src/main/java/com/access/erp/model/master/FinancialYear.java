package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity	
@Table(name="M_FINANCIAL_YEAR")
public class FinancialYear {
	
	
	
	
	@Id
	@Column(name="FINANCIAL_YEAR")
	private String financialYearCode;
	
	
	@Column(name="FROM_DATE")
	private String fromDate;
	
	
	
	@Column(name="TO_DATE")
	private String toDate;


	public FinancialYear() {
		super();
		
		System.out.println("==========>  IN FINANCIAL YEAR <==============");
		
	}


	

	public String getFinancialYearCode() {
		return financialYearCode;
	}


	public void setFinancialYearCode(String financialYearCode) {
		this.financialYearCode = financialYearCode;
	}


	public String getFromDate() {
		return fromDate;
	}


	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}


	public String getToDate() {
		return toDate;
	}


	public void setToDate(String toDate) {
		this.toDate = toDate;
	}


	


	

	
	

	
}

package com.access.erp.model.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class City {
	
	@Id
	@Column(name = "CITY_CODE", length = 50)
	private int cityCode;
	
	@Column(name = "CITY_NAME", length = 50)
	private String cityName;
	
	
	@Column(name = "REGION_CODE", length = 50)
	private String regionCode;
	
	@Column(name = "DISTRICT", length = 100)
	private String district;
	
	@Column(name = "CITY_TYPE", length = 4)
	private String cityType;
	
	@Column(name = "INS_BY",length = 50)
	private String insertedBy;

	@Column(name = "INS_DATE")
	private Date insertedDate=new Date();
	
	@Column(name = "UPDATE_BY",length = 50)
	private String updateBy;

	@Column(name = "UPDATE_DATE")
	private Date updatedDate=new Date();
	
	@Column(name = "ACTIVE_YN",length = 10)
	private String activeYn;
	
	@ManyToOne
	@JoinColumn(name="STATE_CODE")
	private State state;

	public City() {
		super();
		
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCityType() {
		return cityType;
	}

	public void setCityType(String cityType) {
		this.cityType = cityType;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	

}

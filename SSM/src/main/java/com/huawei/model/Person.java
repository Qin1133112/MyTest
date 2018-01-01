package com.huawei.model;

/**
 * person 实体
 * 
 * @author Administrator
 *
 */
public class Person {

	private int id;
	private String INC_DATETIME;
	private int RANDOM_ID;
	private String RANDOM_STRING;

	public String getINC_DATETIME() {
		return INC_DATETIME;
	}

	public void setINC_DATETIME(String iNC_DATETIME) {
		INC_DATETIME = iNC_DATETIME;
	}

	public int getRANDOM_ID() {
		return RANDOM_ID;
	}

	public void setRANDOM_ID(int rANDOM_ID) {
		RANDOM_ID = rANDOM_ID;
	}

	public String getRANDOM_STRING() {
		return RANDOM_STRING;
	}

	public void setRANDOM_STRING(String rANDOM_STRING) {
		RANDOM_STRING = rANDOM_STRING;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
package com.cnic.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Product extends BaseEntity{
	private String Pro_name;
	
	public void setPro_name(String Pro_name) {
		this.Pro_name = Pro_name;
	}
	
	public String getPro_name() {
		return Pro_name;
	}

}

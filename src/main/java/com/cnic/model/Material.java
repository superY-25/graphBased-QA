package com.cnic.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Material extends BaseEntity{
	
	private String Mat_name;
	
	public void setMat_name(String Mat_name) {
		this.Mat_name = Mat_name;
	}
	
	public String getMat_name() {
		return Mat_name;
	}

}

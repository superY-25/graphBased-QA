package com.cnic.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Industry extends BaseEntity{
	
	private String Ind_name;
	
	public void setInd_name(String Ind_name) {
		this.Ind_name = Ind_name;
	}
	
	public String getInd_name() {
		return Ind_name;
	}

}

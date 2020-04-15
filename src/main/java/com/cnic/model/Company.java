package com.cnic.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Company extends BaseEntity{
	
	private String Com_code;
	
	private String Com_name;
	
	public void setCom_name(String Com_name) {
		this.Com_name = Com_name;
	}
	
	public String getCom_name() {
		return Com_name;
	}
	
	public void setCom_code(String Com_code) {
		this.Com_code = Com_code;
	}
	
	public String getCom_code() {
		return Com_code;
	}
	

}

package com.cnic.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import com.cnic.model.Company;

public interface CompanyRepository extends Neo4jRepository<Company, Long>{
	
	@Query("MATCH (n:Company) WHERE n.Com_name = {comName} RETURN n")
	List<Company> getCompanyByName(@Param("comName") String comName);

}

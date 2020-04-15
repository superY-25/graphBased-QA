package com.cnic.repository;

import com.cnic.model.Industry;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IndustryRepository extends Neo4jRepository<Industry, Long>{

	 @Query("MATCH(n:Industry) WHERE n.Ind_name = {IndName} return n")
	 List<Industry> getIndustryByName(@Param("IndName") String IndName);
}

package com.cnic.repository;

import com.cnic.model.Material;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MaterialRepository extends Neo4jRepository<Material, Long>{
	
	@Query("MATCH (n:Material) WHERE n.Mat_name = {matName} return n")
	 List<Material> getMaterialByName(@Param("matName") String matName);
}

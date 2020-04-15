package com.cnic.repository;

import com.cnic.model.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends Neo4jRepository<Product, Long>{
	
	 @Query("MATCH(n:Product) WHERE n.Pro_name = {proName} return n")
	 List<Product> getGenres(@Param("proName") String proName);
}

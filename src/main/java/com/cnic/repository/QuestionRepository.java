package com.cnic.repository;

import com.cnic.model.Company;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 基于产业链图谱的查询接口
 */
public interface QuestionRepository extends Neo4jRepository<Company, Long> {

	/**
	 * 0 对应问题模板0 == nc(公司)主营产品
	 * 
	 * @param comName 公司名称
	 * @return 主营产品
	 */
	@Query("match(n:Company)-[r:主营产品]->(p:Product) where n.Com_name={comName} return p.Pro_name")
	List<String> getProductByComName(@Param("comName") String comName);

	/**
	 * 1 对应问题模板1 == nc(公司)上游原材料
	 * 
	 * @param title 公司名称
	 * @return 上游原材料
	 */
	@Query("match(n:Company)-[r:上游原材料]->(m:Material) where n.Com_name={comName} return m.Mat_name")
	List<String> getMaterialByComName(@Param("comName") String comName);


}

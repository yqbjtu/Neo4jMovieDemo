package com.yq.repository;

import com.yq.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 */
public interface PersonRepository extends Neo4jRepository<Person, Long> , CustomizedRepository<Person> {

	Person findByfirstName(@Param("firstName") String firstName);

	Collection<Person> findByfirstNameLike(@Param("firstName") String firstName);

//	default public void myFindByfirstNameLike(@Param("firstName") String firstName) {
//		this..
//
//	}
}
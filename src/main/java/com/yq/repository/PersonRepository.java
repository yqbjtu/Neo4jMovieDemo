package com.yq.repository;

import java.util.Collection;

import com.yq.domain.Movie;
import com.yq.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

/**
 */
public interface PersonRepository extends Neo4jRepository<Person, Long> {

	Person findByfirstName(@Param("firstName") String firstName);

	Collection<Person> findByfirstNameLike(@Param("firstName") String firstName);
}
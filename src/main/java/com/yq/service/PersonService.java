package com.yq.service;

import java.util.*;

import com.yq.domain.Movie;
import com.yq.domain.Person;
import com.yq.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {

    private final static Logger LOG = LoggerFactory.getLogger(PersonService.class);

	private final PersonRepository personRepository;
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

    @Transactional(readOnly = true)
    public Person findByfirstName(String firstName) {
        Person result = personRepository.findByfirstName(firstName);
        return result;
    }

    @Transactional(readOnly = true)
    public Collection<Person> findByNameLike(String firstName) {
        Collection<Person> result = personRepository.findByfirstNameLike(firstName);
        return result;
    }


}

package ph.mramos.vcps.section04.springdatajpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ph.mramos.vcps.section03.entity.Person;
import ph.mramos.vcps.section04.springdatajpa.SampleSpringDataJpaConfig;
import ph.mramos.vcps.section04.springdatajpa.repository.PersonRepository;

@SpringJUnitConfig(classes = SampleSpringDataJpaConfig.class)
public class SampleSpringDataJpaTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	public void test_findAll() {
		List<Person> persons = personRepository.findAll();
		persons.forEach(System.out::println);
	}

	@Test
	public void test_findAll_example() {
		Person person = new Person();
		person.setFirstName("MAX");
		person.setLastName("RAMOS");
		Example<Person> example = Example.of(person, ExampleMatcher.matchingAny().withIgnoreCase());

		List<Person> persons = personRepository.findAll(example);
		persons.forEach(System.out::println);
	}

	@Test
	public void test_findAll_pageable() {
		Page<Person> page = personRepository.findAll(Pageable.ofSize(3).withPage(1));
		List<Person> persons = page.getContent();
		persons.forEach(System.out::println);

		System.out.println(page.getNumber()); // Page number. Starts with 0.
		System.out.println(page.getNumberOfElements()); // Actual number of elements in the slice.
		System.out.println(page.getSize()); // Slice size (capacity). Not the actual number of elements.
		System.out.println(page.getTotalElements()); // Overall total number of elements.
	}

	@Test
	public void test_findAll_sort() {
		List<Person> persons = personRepository.findAll(Sort.by(Direction.DESC, "firstName"));
		persons.forEach(System.out::println);
	}

	@Test
	public void test_findAllById() {
		List<Person> persons = personRepository.findAllById(Arrays.asList(1, 2));
		persons.forEach(System.out::println);
	}

	@Test
	public void test_findBy() {
		Person person = new Person();
		person.setFirstName("MAX");
		person.setLastName("RAMOS");
		Example<Person> example = Example.of(person, ExampleMatcher.matchingAny().withIgnoreCase());
		Function<FluentQuery.FetchableFluentQuery<Person>, List<Person>> function = query -> query.sortBy(Sort.by(Direction.DESC, "firstName")).all();

		List<Person> persons = personRepository.findBy(example, function);
		persons.forEach(System.out::println);

	}

	@Test
	public void test_findById() {
		Optional<Person> result = personRepository.findById(1);
		System.out.println(result.get());
	}

	@Test
	public void test_findOne() {
		Person person = new Person();
		person.setFirstName("MAX");
		Example<Person> example = Example.of(person, ExampleMatcher.matchingAny().withIgnoreCase());

		Optional<Person> result = personRepository.findOne(example); // Must have exactly one result.
		System.out.println(result.get());
	}

	@Test
	public void test_findByFirstNameIgnoreCaseAndLastNameIgnoreCaseOrderByFirstNameDesc() {
		List<Person> persons = personRepository.findByFirstNameIgnoreCaseAndLastNameIgnoreCaseOrderByFirstNameDesc("MAX", "RAMOS");
		persons.forEach(System.out::println);
	}

	@Test
	public void findFirst2ByLastNameIgnoreCaseOrderByFirstNameDesc() {
		List<Person> persons = personRepository.findFirst2ByLastNameIgnoreCaseOrderByFirstNameDesc("RAMOS");
		persons.forEach(System.out::println);
	}

	@Test
	public void findByFirstNameOrderByFirstNameDesc() {
		List<Person> persons = personRepository.findByFirstNameOrderByFirstNameDesc("%ma%");
		persons.forEach(System.out::println);
	}

}

package ph.mramos.vcps.section04.springdatajpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.TypedSort;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import ph.mramos.vcps.section03.entity.Person;
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
	public void test_findAll_example() { // When using query by example, make sure that the fields are NOT of primitive type since the matcher includes by default all non null fields in its processing.
		Person person = new Person();
		person.setFirstName("MA");
		person.setLastName("RAMOS"); // Has an issue with MySQL.
//		Example<Person> example = Example.of(person, ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.STARTING)); // Cab be ExampleMatcher.matchingAll().
//		Example<Person> example = Example.of(person, ExampleMatcher.matchingAny().withIgnoreCase().withStringMatcher(StringMatcher.EXACT));
//		Example<Person> example = Example.of(person, ExampleMatcher.matching()
//				.withMatcher("firstName", GenericPropertyMatchers.startsWith().ignoreCase()) // Property path can be nest (e.g. address.city)
//				.withMatcher("lastName", GenericPropertyMatchers.exact().ignoreCase()));
		Example<Person> example = Example.of(person, ExampleMatcher.matching()
				.withMatcher("firstName", matcher -> matcher.startsWith().ignoreCase())
				.withMatcher("lastName", matcher -> matcher.exact().ignoreCase()));

		List<Person> persons = personRepository.findAll(example);
		persons.forEach(System.out::println);
	}

	@Test
	public void test_findAll_pageable() {
		Page<Person> page = personRepository.findAll(PageRequest.of(0, 2, Sort.by(Direction.DESC, "firstName"))); // Page number is 0 based.
		List<Person> persons = page.getContent();
		persons.forEach(System.out::println);

		System.out.println(page.getNumber()); // Page number of the page. Starts with 0.
		System.out.println(page.getNumberOfElements()); // Actual number of elements in the slice.
		System.out.println(page.getSize()); // Slice size (capacity) of the page. Not the actual number of elements.
		System.out.println(page.getTotalElements()); // Overall total number of elements.
		System.out.println(page.getTotalPages()); // Total number of pages.
	}

	@Test
	public void test_findAll_sort() {
//		Sort sort = Sort.by(Direction.DESC, "firstName")
//				.and(Sort.by(Direction.DESC, "lastName"));

//		Sort sort = Sort.by("firstName").descending()
//				.and(Sort.by("lastName").descending());

		TypedSort<Person> person = Sort.sort(Person.class);
		Sort sort = person.by(Person::getFirstName).ascending()
				.and(person.by(Person::getLastName).descending());

		List<Person> persons = personRepository.findAll(sort);
		persons.forEach(System.out::println);
	}

	@Test
	public void test_findAllById() {
		List<Person> persons = personRepository.findAllById(Arrays.asList(1, 2));
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
	public void test_findFirst2ByLastNameIgnoreCaseOrderByFirstNameDesc() {
		List<Person> persons = personRepository.findFirst2ByLastNameIgnoreCaseOrderByFirstNameDesc("RAMOS");
		persons.forEach(System.out::println);
	}

	@Test
	public void test_findByFirstNameOrderByFirstNameDesc() {
		List<Person> persons = personRepository.findByFirstNameOrderByFirstNameDesc("%ma%");
		persons.forEach(System.out::println);
	}

	@Test
	public void test_count() {
		long count = personRepository.count();
		System.out.println(count);
	}

	@Test
	public void test_exists() {
		Person person = new Person();
		person.setFirstName("MAX");
		Example<Person> example = Example.of(person, ExampleMatcher.matchingAny().withIgnoreCase());

		boolean exist = personRepository.exists(example);
		System.out.println(exist);
	}

}

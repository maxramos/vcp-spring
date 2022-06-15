package ph.mramos.vcps.section04.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ph.mramos.vcps.section03.entity.Person;

//@RepositoryDefinition(domainClass = Person.class, idClass = Integer.class) // Alternative to extending Repository or one of its sub interfaces.
public interface PersonRepository extends JpaRepository<Person, Integer> {

	List<Person> findByFirstNameIgnoreCaseAndLastNameIgnoreCaseOrderByFirstNameDesc(String firstName, String lastName);

	List<Person> findFirst2ByLastNameIgnoreCaseOrderByFirstNameDesc(String lastName); // If first or top is left out then get 1 result only.

//	@Modifying // Use this annotation if query is either INSERT, UPDATE, DELETE, or DDL statements.
	@Query("SELECT p FROM Person p WHERE p.firstName LIKE :firstName") // ?1 can also be used instead of named paramater (1 based).
	List<Person> findByFirstNameOrderByFirstNameDesc(@Param("firstName") String firstName);

}

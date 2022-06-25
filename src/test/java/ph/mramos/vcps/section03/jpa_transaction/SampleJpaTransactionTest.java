package ph.mramos.vcps.section03.jpa_transaction;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import ph.mramos.vcps.section03.entity.Person;
import ph.mramos.vcps.section04.springdatajpa.repository.PersonJpaRepository;

@SpringJUnitConfig(classes = { SampleJpaTransactionConfig.class, PersonJpaRepository.class })
public class SampleJpaTransactionTest {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private PersonJpaRepository personJpaRepository;

	@Test
	public void test_query() {
		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
		List<Person> persons = query.getResultList();
		persons.forEach(System.out::println);
	}

	/**
	 * - Programmatic alternative to @Transactional is to use TransactionTemplate.
	 * - Self invocation of proxied bean methods (with @Transactional) will not honor the @Transactional config of the method being called. It will run on the transaction context of the caller method.
	 * - When using Spring AOP proxies, only public methods can be intercepted. Other access modifiers will not throw an error but transaction management will not be triggered.
	 *
	 * - Default rollback policy for regular methods is rollback on unchecked exceptions.
	 * - Default rollback policy for test methods annotated by @Transactional is rollback after completion regardless of an exception (either checked or unchecked) being thrown or not.
	 *   Use @Rollback(false) to override this default rollback policy for test methods (provided the test method is annotated by @Transactional).
	 *
	 * - If test method is NOT annotated by @Transactional and instead annotated on the regular method then it will commit by default.
	 * - Use @Rollback(true) on the test method to rollback changes even if @Transactional is annotated on the regular method.
	 *
	 * - If @Transactional is present then PlatformTransactionManager must be present as a bean otherwise an error will be thrown.
	 *
	 * - rollBackFor, rollbackForClassName, noRollBackFor, noRollbackForClassName
	 *   These attributes does not override the default exceptions/errors that cause rollback/non-rollback but instead complement/add to it.
	 */
	@Test
	@Transactional() // Be careful to import org.springframework.transaction.annotation.Transactional and NOT javax.transaction.Transactional. Those from Spring has more config attributes.
	@Rollback(false) // For test only. Not required for test methods annotated with @Transactional to rollback. Typically, will only be used if rollback is not desired (i.e. @Rollback(false)).
	public void test_transaction() {
		Person person = new Person("nikki1", "tan1", 35, Date.from(LocalDate.of(1986, 12, 25).atStartOfDay().toInstant(ZoneOffset.UTC)), 62.0, 157.48);
		em.persist(person);
		em.flush();

		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.firstName = 'nikki1'", Person.class);
		List<Person> persons = query.getResultList();
		persons.forEach(System.out::println);
	}

	/**
	 * - @Transactional on methods that use JPA to update state (e.g. insert, update, delete) is required otherwise an error will be thrown (TransactionRequiredException).
	 * - @EnableTransactionManagement is required to enable the use of @Transactional otherwise an error will be thrown (TransactionRequiredException).
	 */
	@Test
	public void test_transaction2() { // The @Transactional is on PersonJpaRepository instead of here in the test method because error scenarios does not cause rollback if @Transactional is annotated on the test method.
		Person person = new Person("nikki1", "tan1", 35, Date.from(LocalDate.of(1986, 12, 25).atStartOfDay().toInstant(ZoneOffset.UTC)), 62.0, 157.48);
		personJpaRepository.save(person);

		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.firstName = 'nikki1'", Person.class);
		List<Person> persons = query.getResultList();
		persons.forEach(System.out::println);
	}

}

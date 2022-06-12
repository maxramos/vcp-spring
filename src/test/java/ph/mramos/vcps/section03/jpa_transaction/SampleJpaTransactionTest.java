package ph.mramos.vcps.section03.jpa_transaction;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import ph.mramos.vcps.section03.entity.Person;

@SpringJUnitConfig(classes = SampleJpaTransactionConfig.class)
public class SampleJpaTransactionTest {

	@PersistenceContext
	private EntityManager em;

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
	 * - Default rollback policy for regular methods is rollback on unchecked exceptions.
	 * - Default rollback policy for test methods is rollback after completion regardless of an exception (either checked or unchecked) being thrown or not.
	 */
	@Test
	@Transactional // Be careful to import org.springframework.transaction.annotation.Transactional and NOT javax.transaction.Transactional. Those from Spring has more config attributes.
	@Rollback(false) // For test only.
	public void test_transaction() {
		Person person = new Person("nikki1", "tan1", 35, Date.from(LocalDate.of(1986, 12, 25).atStartOfDay().toInstant(ZoneOffset.UTC)), 62, 157.48);
		em.persist(person);
		em.flush();

		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.firstName = 'nikki1'", Person.class);
		List<Person> persons = query.getResultList();
		persons.forEach(System.out::println);
	}

}

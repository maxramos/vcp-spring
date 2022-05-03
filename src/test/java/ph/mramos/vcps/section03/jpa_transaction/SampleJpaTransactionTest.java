package ph.mramos.vcps.section03.jpa_transaction;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import ph.mramos.vcps.section03.jpa_transaction.entity.Person;

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

	@Test
	@Transactional
	@Rollback(false)
	public void test_transaction() {
		@SuppressWarnings("deprecation")
		Person person = new Person("nikki1", "tan1", 35, new Date(1986, 11, 25), 62, 157.48);
		em.persist(person);
		em.flush();

		TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p WHERE p.firstName = 'nikki1'", Person.class);
		List<Person> persons = query.getResultList();
		persons.forEach(System.out::println);
	}

}

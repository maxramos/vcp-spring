package ph.mramos.vcps.section04.springdatajpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ph.mramos.vcps.section03.entity.Person;

@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	private EntityManager em;

	public Person save(Person person) {
		em.persist(person);
		em.flush();

		if (person.getId() != null) {
			throw new RuntimeException();
		}

		return person;
	}

}

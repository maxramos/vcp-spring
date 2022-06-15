package ph.mramos.vcps.section04.springdatajpa.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PersonJdbcRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int updateAgeByFirstName(Integer age, String firstName) {
		int updatedRows = jdbcTemplate.update("UPDATE person SET age = ? WHERE first_name = ?", age, firstName);

		if (updatedRows > 0) {
			throw new RuntimeException();
		}

		return updatedRows;
	}

}

package ph.mramos.vcps.section03.jdbctemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import ph.mramos.vcps.section03.entity.Person;
import ph.mramos.vcps.section04.springdatajpa.repository.PersonJdbcRepository;

/**
 * query(sql, RowMapper)
 *		- Can select multiple columns.
 *		- Returns a list of complex object (i.e. generic type of RowMapper).
 *
 * queryForObject(sql, RowMapper)
 *		- Can select multiple columns.
 *		- Returns a single complex object (i.e. generic type of RowMapper).
 *
 * queryForList(sql)
 * 		- Can select multiple columns.
 * 		- Returns a list of Map<String, Object>.
 *
 * queryForMap(sql)
 * 		- Can select multiple columns.
 * 		- Returns a single Map<String, Object>.
 *
 * queryForList(sql, Class)
 * 		- Can only select a single column.
 * 		- Returns a list of simple object (e.g. String).
 *
 * queryForObject(sql, Class)
 * 		- Can only select a single column.
 * 		- Returns a single simple object (e.g. String).
 */
@SpringJUnitConfig(classes = { SampleJdbcTemplateConfig.class, PersonJdbcRepository.class })
public class SampleJdbcTemplateTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private PersonJdbcRepository personJdbcRepository;

	/**
	 * ResultSetExtractor - extracts data from result set all at once.
	 * Has a return.
	 */
	@Test
	public void test_query_resultSetExtractor() { // Fetch multiple rows.
		ResultSetExtractor<List<String>> resultSetExtractor = rs -> {
			List<String> resultList = new ArrayList<>();

			while (rs.next()) {
				String firstName = rs.getString("first_name");
				resultList.add(firstName);
			}

			return resultList;
		};

		List<String> resultList = jdbcTemplate.query("SELECT * FROM person WHERE age >= ?", resultSetExtractor, 3);

//		List<String> resultList = jdbcTemplate.query("SELECT * FROM person", new ResultSetExtractor<>() { // Can be a Function instead.
//			@Override
//			public List<String> extractData(ResultSet rs) throws SQLException {
//				List<String> resultList = new ArrayList<>();
//
//				while (rs.next()) {
//					String firstName = rs.getString("first_name");
//					resultList.add(firstName);
//				}
//
//				return resultList;
//			}
//		});

		System.out.println(resultList);
	}

	/**
	 * RowCallbackHandler - extracts data from result set one at a time.
	 * Returns nothing.
	 */
	@Test
	public void test_query_rowCallbackHandler() { // Fetch multiple rows.
		List<String> resultList = new ArrayList<>();

		RowCallbackHandler rowCallbackHandler = rs -> {
			String firstName = rs.getString("first_name");
			resultList.add(firstName);
		};

		jdbcTemplate.query("SELECT * FROM person WHERE age >= ?", rowCallbackHandler, 3);

//		jdbcTemplate.query("SELECT * FROM person", new RowCallbackHandler() { // Can be a Consumer instead.
//			@Override
//			public void processRow(ResultSet rs) throws SQLException {
//				String firstName = rs.getString("first_name");
//				resultList.add(firstName);
//			}
//		});

		System.out.println(resultList);
	}

	/**
	 * RowMapper - extracts data from result set one at a time.
	 * Returns a list.
	 */
	@Test
	public void test_query_rowMapper() { // Fetch multiple rows.
		RowMapper<Person> rowMapper = (rs, rowNum) -> {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setFirstName(rs.getString("first_name"));
			person.setLastName(rs.getString("last_name"));
			person.setAge(rs.getInt("age"));
			person.setBirthDate(rs.getDate("birth_date"));
			person.setWeight(rs.getDouble("weight"));
			person.setHeight(rs.getDouble("height"));
			return person;
		};

		List<Person> resultList = jdbcTemplate.query("SELECT * FROM person WHERE age >= ?", rowMapper, 3); // Fetch multiple columns.

//		List<String> resultList = jdbcTemplate.query("SELECT * FROM person", new RowMapper<>() { // Can be a BiFunction instead.
//			@Override
//			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return rs.getString("first_name");
//			}
//		});

		System.out.println(resultList);
	}

	@Test
	public void test_queryForList() { // Fetch multiple rows.
//		List<Map<String, Object>> results = jdbcTemplate.queryForList("SELECT * FROM person"); // Fetch multiple columns.

		List<String> resultList = jdbcTemplate.queryForList("SELECT first_name FROM person WHERE age >= ?", String.class, 3); // Fetch single column. Does not allow complex types like Entity classes, use query(sql, RowMapper) instead.

		System.out.println(resultList);
	}

	@Test
	public void test_queryForMap() { // Fetch single row.
		Map<String, Object> result = jdbcTemplate.queryForMap("SELECT * FROM person WHERE first_name = ?", "max"); // Fetch multiple columns.

		System.out.println(result);
	}

	@Test
	public void test_queryForObject_rowMapper() { // Fetch single row.
		RowMapper<Person> rowMapper = (rs, rowNum) -> {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setFirstName(rs.getString("first_name"));
			person.setLastName(rs.getString("last_name"));
			person.setAge(rs.getInt("age"));
			person.setBirthDate(rs.getDate("birth_date"));
			person.setWeight(rs.getDouble("weight"));
			person.setHeight(rs.getDouble("height"));
			return person;
		};

		Person result = jdbcTemplate.queryForObject("SELECT * FROM person WHERE first_name = ?", rowMapper, "max"); // Fetch multiple columns.

//		String result = jdbcTemplate.queryForObject("SELECT first_name FROM person WHERE age = ?", String.class, 33); // Fetch single column. Does not allow complex types like Entity classes, use queryForObject(sql, RowMapper) instead.

		System.out.println(result);
	}

	@Test
	public void test_queryForRowSet() { // Fetch multiple rows.
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM person");

		while (sqlRowSet.next()) { // Just like ResultSet processing.
			String firstName = sqlRowSet. getString("first_name");
			System.out.println(firstName);
		}
	}

	/**
	 * - Missing @Transactional on methods (both test and regular) that use JdbcTemplate to update state will not throw an error and each individual statement will effectively runs on its own transaction.
	 * - @EnableTransactionManagement is required to enable the use of @Transactional otherwise each individual statement will effectively runs on its own transaction.
	 *
	 * - If @Transactional is present then PlatformTransactionManager must be present as a bean otherwise an error will be thrown.
	 */
	@Test
	@Transactional // Be careful to import org.springframework.transaction.annotation.Transactional and NOT javax.transaction.Transactional. Those from Spring has more config attributes.
	@Rollback(false) // For test only. Not required for test methods annotated with @Transactional to rollback. Typically, will only be used if rollback is not desired (i.e. @Rollback(false)).
	public void test_update() {
		int updatedRows = jdbcTemplate.update("UPDATE person SET age = ? WHERE first_name = ?", 31, "max"); // Can be an insert, update, or delete statement.

		System.out.println(updatedRows);
	}

	@Test
	public void test_update2() {
		int updatedRows = personJdbcRepository.updateAgeByFirstName(31, "max");

		System.out.println(updatedRows);
	}

}

package ph.mramos.vcps.section03.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleJdbcTemplateConfig.class)
public class SampleJdbcTemplateTest {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * ResultSetExtractor - extracts data from result set all at once.
	 * Has a return.
	 */
	@Test
	public void test_query_resultSetExtractor() {
		List<String> firstNames = jdbcTemplate.query("SELECT * FROM person", new ResultSetExtractor<>() { // Can be a Function instead.
			@Override
			public List<String> extractData(ResultSet rs) throws SQLException {
				List<String> firstNameList = new ArrayList<>();
	
				while (rs.next()) {
					String firstName = rs.getString("first_name");
					firstNameList.add(firstName);
				}
	
				return firstNameList;
			}
		});

		System.out.println(firstNames);
	}

	/**
	 * RowCallbackHandler - extracts data from result set one at a time.
	 * Returns nothing.
	 */
	@Test
	public void test_query_rowCallbackHandler() {
		List<String> firstNameList = new ArrayList<>();

		jdbcTemplate.query("SELECT * FROM person", new RowCallbackHandler() { // Can be a Consumer instead.
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				String firstName = rs.getString("first_name");
				firstNameList.add(firstName);
			}
		});

		System.out.println(firstNameList);
	}

	/**
	 * RowMapper - extracts data from result set one at a time.
	 * Returns a list.
	 */
	@Test
	public void test_query_rowMapper() {
		List<String> firstNameList = jdbcTemplate.query("SELECT * FROM person", new RowMapper<>() { // Can be a BiFunction instead.
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString("first_name");
			}
		}); 

		System.out.println(firstNameList);
	}

	@Test
	public void test_queryForList() {
		List<Map<String, Object>> results = jdbcTemplate.queryForList("SELECT * FROM person");

		System.out.println(results);
	}

	@Test
	public void test_queryForMap() {
		Map<String, Object> results = jdbcTemplate.queryForMap("SELECT * FROM person WHERE first_name = 'max'");

		System.out.println(results);
	}

	@Test
	public void test_queryForObject_rowMapper() {
		String firstName = jdbcTemplate.queryForObject("SELECT * FROM person WHERE first_name = 'max'", (rs, rowNum) -> rs.getString("first_name"));

		System.out.println(firstName);
	}

	@Test
	public void test_queryForRowSet() {
		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM person");

		while (sqlRowSet.next()) { // Just like ResultSet processing.
			String firstName = sqlRowSet. getString("first_name");
			System.out.println(firstName);
		}
	}

	@Test
	public void test_update() {
		int updatedRows = jdbcTemplate.update("UPDATE person SET age = 33 WHERE first_name = 'max'");

		System.out.println(updatedRows);
	}

}

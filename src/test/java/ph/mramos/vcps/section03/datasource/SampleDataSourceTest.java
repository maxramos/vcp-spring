package ph.mramos.vcps.section03.datasource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = SampleDataSourceConfig.class)
public class SampleDataSourceTest {

	@Autowired
	private DataSource dataSource;

	@Test
	public void test_executeQuery() {
		Connection conn = DataSourceUtils.getConnection(dataSource);

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM person");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int age = rs.getInt("age");
				Date birthDate = rs.getDate("birth_date");
				double weight = rs.getDouble("weight");
				double height = rs.getDouble("height");
				System.out.println("id: " + id);
				System.out.println("first_name: " + firstName);
				System.out.println("last_name: " + lastName);
				System.out.println("age: " + age);
				System.out.println("birth_date: " + birthDate);
				System.out.println("weight: " + weight);
				System.out.println("height: " + height);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtils.releaseConnection(conn, dataSource);
		}
	}

}

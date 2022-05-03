package ph.mramos.vcps.section03.jpa_transaction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person {

	@Id
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private int age;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private Date bithDate;

	private double weight;

	private double height;

	public Person() {
		super();
	}

	public Person(String firstName, String lastName, int age, Date bithDate, double weight, double height) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.bithDate = bithDate;
		this.weight = weight;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public Date getBithDate() {
		return bithDate;
	}

	public double getWeight() {
		return weight;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return String.format("Person [id=%s, firstName=%s, lastName=%s, age=%s, bithDate=%s, weight=%s, height=%s]", id, firstName, lastName, age, bithDate, weight, height);
	}

}

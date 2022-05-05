package ph.mramos.vcps.section05.webmvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/matrix")
public class MatrixController {

	@GetMapping("test1/{info1}") // http://localhost:8080/vcp-spring/matrix/test1/firstName=max;lastName=ramos
	public String test1(@MatrixVariable(pathVar = "info1") Map<String, String> matrix1) { // Must be pathVar.
		System.out.println("matrix1: " + matrix1);
		return "person";
	}

	@GetMapping("test2/stat{info2}") // http://localhost:8080/vcp-spring/matrix/test2/stat;firstName=max;lastName=ramos
	public String test2(@MatrixVariable(pathVar = "info2") Map<String, String> matrix2) { // Must be pathVar.
		System.out.println("matrix2: " + matrix2);
		return "person";
	}

	@GetMapping("test3/{id}") // http://localhost:8080/vcp-spring/matrix/test3/1;firstName=max;lastName=ramos
	public String test3(@PathVariable("id") int id, @MatrixVariable Map<String, String> matrix3) { // Must have no name or pathVar.
		System.out.println("id: " + id);
		System.out.println("matrix3: " + matrix3);
		return "person";
	}

	@GetMapping("test4/{id}{info4}") // Unable to parse matrix. http://localhost:8080/vcp-spring/matrix/test4/1;firstName=max;lastName=ramos
	public String test4(@PathVariable("id") int id, @MatrixVariable(pathVar = "info4") Map<String, String> matrix4) { // Must be pathVar.
		System.out.println("id: " + id);
		System.out.println("matrix4: " + matrix4);
		return "person";
	}

	@GetMapping("test5/{id}") // http://localhost:8080/vcp-spring/matrix/test5/1;firstName=max;lastName=ramos
	public String test5(@PathVariable("id") int id, @MatrixVariable("firstName") String firstName, @MatrixVariable("lastName") String lastName) { // Must have a name.
		System.out.println("id: " + id);
		System.out.println("firstName: " + firstName);
		System.out.println("lastName: " + lastName);
		return "person";
	}

	@GetMapping("test6/{info1}/stat{info2}/{id}") // http://localhost:8080/vcp-spring/matrix/test6/firstName=max;lastName=ramos/stat;age=34;birthDate=1988-05-11/1;weight=103;height=180
	public String test6( // Note that pathVar (e.g. company, employee) can be used to differentiate same key (e.g. name). Example: company.name, employee.name
			@PathVariable("id") int id,
			@MatrixVariable(pathVar = "info1") Map<String, String> matrix1,
			@MatrixVariable(pathVar = "info2") Map<String, String> matrix2,
			@MatrixVariable Map<String, String> matrix3, // This will be populated by all matrix fields (including those present in other matrix).
			@MatrixVariable("firstName") String firstName,
			@MatrixVariable("lastName") String lastName,
			@MatrixVariable("age") String age,
			@MatrixVariable("birthDate") String birthDate,
			@MatrixVariable("weight") String weight,
			@MatrixVariable("height") String height) {
		System.out.println("id: " + id);
		System.out.println("matrix1: " + matrix1);
		System.out.println("matrix2: " + matrix2);
		System.out.println("matrix3: " + matrix3);
		System.out.println("firstName: " + firstName);
		System.out.println("lastName: " + lastName);
		System.out.println("age: " + age);
		System.out.println("birthDate: " + birthDate);
		System.out.println("weight: " + weight);
		System.out.println("height: " + height);
		return "person";
	}

}

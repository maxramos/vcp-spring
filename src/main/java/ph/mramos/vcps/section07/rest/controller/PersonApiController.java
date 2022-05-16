package ph.mramos.vcps.section07.rest.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ph.mramos.vcps.section03.entity.Person;
import ph.mramos.vcps.section04.springdatajpa.service.PersonIdNotFoundException;
import ph.mramos.vcps.section04.springdatajpa.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonApiController {

	@Autowired
	private PersonService personService;

	@GetMapping("/{id}")
	public ResponseEntity<Object> find(@PathVariable int id) {
		try {
		Person person = personService.findById(id);
		return ResponseEntity.ok(person);
		} catch (PersonIdNotFoundException e) {
			Map<String, String> error = new LinkedHashMap<>();
			error.put("message", "Person ID Not Found.");
			return ResponseEntity.badRequest().body(error);
		}
	}

	@GetMapping("/find")
	public ResponseEntity<Object> find(@RequestParam String firstName) {
		try {
			Person person = personService.findByFirstName(firstName);
			return ResponseEntity.ok(person);
		} catch (Exception e) {
			Map<String, String> error = new LinkedHashMap<>();
			error.put("message", "Person First Name Not Found.");
			return ResponseEntity.badRequest().body(error);
		}
	}

	@PreAuthorize("hasRole('admin') and #userDetails.username == authentication.name")
	@GetMapping("/admin")
	public Person findSuperAdmin(@AuthenticationPrincipal UserDetails userDetails) {
		Person person = personService.findByFirstName(userDetails.getUsername());
		return person;
	}

}

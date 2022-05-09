package ph.mramos.vcps.section05.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ph.mramos.vcps.section03.entity.Person;
import ph.mramos.vcps.section04.springdatajpa.service.PersonService;

/**
 * If the method param is primitive then @RequestParam is optional (provided there are no other argument resolvers).
 * If the method param is a custom object then @ModelAttribute is optional. Request params are automatically binded to the object's fields (provided there are no other argument resolvers).
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping("/{id}")
	public String find(@PathVariable int id, Model model) {
		Person person = personService.findById(id);
		model.addAttribute("person", person);
		return "person";
	}

	@GetMapping("/find")
	public String find(@RequestParam String firstName, Model model) { // @RequestParam can be query params or form params.
		Person person = personService.findByFirstName(firstName);
		model.addAttribute("person", person);
		return "person";
	}

}

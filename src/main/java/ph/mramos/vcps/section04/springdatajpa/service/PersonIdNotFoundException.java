package ph.mramos.vcps.section04.springdatajpa.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Person ID Not Found.")
@SuppressWarnings("serial")
public class PersonIdNotFoundException extends RuntimeException {

}

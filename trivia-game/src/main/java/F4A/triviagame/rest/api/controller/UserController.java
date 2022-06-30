package F4A.triviagame.rest.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping(path = "/api/usuario/{codigo}")
	public ResponseEntity consultar(@PathVariable("codigo") String codigo) {
		return null;
		
	}

}

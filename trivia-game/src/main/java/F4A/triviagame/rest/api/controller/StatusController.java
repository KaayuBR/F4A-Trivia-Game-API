package F4A.triviagame.rest.api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StatusController {

	@GetMapping(path = "/api/status")
	public String check() {
		return "online";
	}
	
}

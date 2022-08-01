package F4A.triviagame.rest.api.controller;

import org.springframework.web.bind.annotation.RestController;

import F4A.triviagame.rest.api.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StatusController{

	private int i = 1;
	private int j = 0;
	private int lastId = 0;
	private int k = 0;
	private String ids;
	
	
	@GetMapping(path = "/api/status")
	public String check() {
		return "online";
	}
	
	@Autowired
	QuestionRepository questionRepository;
	
	@CrossOrigin
	@GetMapping(path = "/api/totallinhas")
	public long getQuestionCount() {
	    return questionRepository.count();
	}
	
	@CrossOrigin
	@GetMapping(path = "/api/questoes")
	public String idsDasQuestoes() {
		i = 1;
		j = (int) getQuestionCount();
		lastId = 0;
		k = 0;
		ids = "";
		
		checkLastId();
		
		return ids;
	}
	
	public String checkLastId(){
		while (k != j) {
			boolean checkLastId = questionRepository.findById(i).isPresent();
			if (checkLastId) {
				ids = ids + String.valueOf(i) + " \n";
				i++;
				k++;
			}
			else {
				if (k<j)
				{
					i++;
				}
				else {
					k = j;
				}				
			}
		}
		lastId = i;
		return ids;
		
	}


}

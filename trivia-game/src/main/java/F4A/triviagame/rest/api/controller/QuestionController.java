package F4A.triviagame.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import F4A.triviagame.rest.api.model.QuestionModel;
import F4A.triviagame.rest.api.repository.QuestionRepository;

@RestController
public class QuestionController {
	
	@Autowired
	private QuestionRepository repository;
	
	@CrossOrigin
	@GetMapping(path = "/api/questao/consultar/{codigo}")
	public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
		System.out.println("Retornando o JSON dos dados associados com o código: "+codigo);
		return repository.findById(codigo)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@CrossOrigin
	@PostMapping(path = "/api/questao/adicionar")
	public QuestionModel adicionar(@RequestBody QuestionModel questao) {
		int i = 1;
		int lastId = 0;
		while (i != lastId) {
			boolean checkLastId = repository.findById(i).isPresent();
			if (checkLastId) {
				i++;
			}
			else {
				lastId = i;
			}
		}
		
		int id = lastId++;
		questao.setCodigo(id);
		System.out.println("Adicionado os dados da pergunta com o ID: "+id);
		return repository.save(questao);
	}

	@CrossOrigin
	@PutMapping (path = "/api/questao/atualizar/{codigo}")
	public QuestionModel atualizar(@PathVariable("codigo") Integer codigo, @RequestBody QuestionModel questao) {
		questao.setCodigo(codigo);
		System.out.println("Atualizado os dados da pergunta com o ID: "+codigo);
		return repository.save(questao);
	}
	
	@CrossOrigin 	 	
	@DeleteMapping (path = "/api/questao/excluir/{codigo}")
	public void excluir(@PathVariable("codigo") Integer codigo) {
		if(codigo != null) {
			repository.deleteById(codigo);
			System.out.println("Dados associados com o ID "+codigo+" foram apagados com sucesso.");
		}
		else {
			System.out.println("ID null");
		}
	}
}
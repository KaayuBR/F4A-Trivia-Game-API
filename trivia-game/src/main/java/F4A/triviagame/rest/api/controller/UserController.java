package F4A.triviagame.rest.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import F4A.triviagame.rest.api.model.QuestionModel;
import F4A.triviagame.rest.api.model.UserModel;
import F4A.triviagame.rest.api.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping(path = "/api/usuario/{codigo}")
	public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
		System.out.println("Retornando o JSON do usuário com o código: "+codigo);
		return repository.findById(codigo)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	@PostMapping(path = "/api/usuario/salvar")
	public UserModel salvar(@RequestBody UserModel usuario) {
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
		usuario.setCodigo(id);
		System.out.println("Adicionado o usuário com o ID: "+id);
		return repository.save(usuario);
	}
	
	@DeleteMapping (path = "/api/usuario/excluir/{codigo}")
	public void excluir(@PathVariable("codigo") Integer codigo) {
		if(codigo != null) {
			repository.deleteById(codigo);
			System.out.println("Usuário associados com o ID "+codigo+" foram apagados com sucesso.");
		}
		else {
			System.out.println("ID null");
		}
	}

	@PutMapping (path = "/api/usuario/atualizar/{codigo}")
	public UserModel atualizar(@PathVariable("codigo") Integer codigo, @RequestBody UserModel usuario) {
		usuario.setCodigo(codigo);
		System.out.println("Atualizado os dados do usuário com o ID: "+codigo);
		return repository.save(usuario);
	}
}

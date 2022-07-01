package F4A.triviagame.rest.api.repository;

import org.springframework.data.repository.CrudRepository;

import F4A.triviagame.rest.api.model.QuestionModel;

public interface QuestionRepository extends CrudRepository<QuestionModel, Integer> {

}

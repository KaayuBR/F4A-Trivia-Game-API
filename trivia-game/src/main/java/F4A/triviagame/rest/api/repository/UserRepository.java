package F4A.triviagame.rest.api.repository;

import org.springframework.data.repository.CrudRepository;

import F4A.triviagame.rest.api.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer> {

}

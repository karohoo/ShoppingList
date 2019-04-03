package hh.palvelinohjelmointi.ShoppingList.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	
	User findByRole(String role);

}
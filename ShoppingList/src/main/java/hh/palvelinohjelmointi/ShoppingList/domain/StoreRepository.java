package hh.palvelinohjelmointi.ShoppingList.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface StoreRepository extends CrudRepository<Store, Long> {
	
	List<Store> findByName(String name);

}
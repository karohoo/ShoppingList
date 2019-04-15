package hh.palvelinohjelmointi.ShoppingList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.ShoppingList.domain.Store;
import hh.palvelinohjelmointi.ShoppingList.domain.StoreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StoreRepoTest {
	
	@Autowired
	private StoreRepository repository;
	
	@Test
	public void findByNameShouldReturnId() {
		List<Store>stores = repository.findByName("Grocery store");
		assertThat(stores).hasSize(1);
		assertThat(stores.get(0).getStoreId()).isEqualTo(1L);
	}
	
	@Test
	public void createNewStore() {
		Store store = new Store("Clothing store");
		repository.save(store);
		assertThat(store.getStoreId()).isNotNull();
	}
	
	@Test
	public void DeleteStore() {
		Store store = new Store("Clothing store");
		repository.delete(store);
		assertNull(store.getStoreId());
	}

}
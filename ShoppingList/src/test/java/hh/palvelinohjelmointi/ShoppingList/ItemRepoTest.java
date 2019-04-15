package hh.palvelinohjelmointi.ShoppingList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.ShoppingList.domain.Item;
import hh.palvelinohjelmointi.ShoppingList.domain.ItemRepository;
import hh.palvelinohjelmointi.ShoppingList.domain.Store;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepoTest {
	
	@Autowired
	private ItemRepository repository;
	
	@Test
	public void findByNameShouldReturnUnit() {
		List<Item>items = repository.findByName("Coffee");
		assertThat(items).hasSize(1);
		assertThat(items.get(0).getUnit()).isEqualTo("bags");
	}
	
	@Test
	public void createNewItem() {
		Item item = new Item("Socks", 2, "bags", "Size 22/24 and 28/30", new Store("Clothing store"));
		repository.save(item);
		assertThat(item.getId()).isNotNull();
	}
	
	@Test
	public void DeleteItem() {
		Item item = new Item("Socks", 2, "bags", "Size 22/24 and 28/30", new Store("Clothing store"));
		repository.delete(item);
		assertNull(item.getId());
	}

}

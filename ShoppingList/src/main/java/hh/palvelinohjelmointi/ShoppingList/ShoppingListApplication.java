package hh.palvelinohjelmointi.ShoppingList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.ShoppingList.domain.Item;
import hh.palvelinohjelmointi.ShoppingList.domain.ItemRepository;
import hh.palvelinohjelmointi.ShoppingList.domain.Store;
import hh.palvelinohjelmointi.ShoppingList.domain.StoreRepository;
import hh.palvelinohjelmointi.ShoppingList.domain.User;
import hh.palvelinohjelmointi.ShoppingList.domain.UserRepository;

@SpringBootApplication
public class ShoppingListApplication {

	private static final Logger log = LoggerFactory.getLogger(ShoppingListApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner shoppingDemo(ItemRepository irepository, StoreRepository srepository, UserRepository urepository) {
		return (args) -> {
			log.info("saving shopping list");
			srepository.save(new Store("Grocery store"));
			srepository.save(new Store("Sport store"));
			srepository.save(new Store("Pharmacy"));
			irepository.save(new Item("Softshell gloves", 1, "pair", "Size of a 4-year-old", srepository.findByName("Sport store").get(0)));
			irepository.save(new Item("Oat milk", 4, "litre", "", srepository.findByName("Grocery store").get(0)));
			irepository.save(new Item("Coffee", 2, "bags", "Dark roast", srepository.findByName("Grocery store").get(0)));
			irepository.save(new Item("Yoghurt", 1, "litre", "No added sugar", srepository.findByName("Grocery store").get(0)));
			irepository.save(new Item("Skin cream", 2, "cans", "Novalan or Aqualan", srepository.findByName("Pharmacy").get(0)));
			urepository.save(new User("user", "$2a$04$zLnuuuCimyp8lKg/iLQsPeHOvn5SFG.XfYPlcE3zjXpKDm14gEZNW", "USER"));
			urepository.save(new User("admin", "$2a$04$nnSBGiNk6ugfSX647Tw5ruvtx1m9RgcNpNtVjo25q.kjKhYmv/Jgm", "ADMIN"));
			log.info("fetch all items");
			for (Item item : irepository.findAll()) {
				log.info(item.toString());
			}

		};
	}

}

package hh.palvelinohjelmointi.ShoppingList.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.palvelinohjelmointi.ShoppingList.domain.Item;
import hh.palvelinohjelmointi.ShoppingList.domain.ItemRepository;
import hh.palvelinohjelmointi.ShoppingList.domain.StoreRepository;

@Controller
public class ShoppingController {

	@Autowired
	private ItemRepository irepository;
	
	@Autowired
	private StoreRepository srepository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@RequestMapping(value="/shoppinglist", method=RequestMethod.GET)
	public String itemList(Model model) {
		model.addAttribute("items", irepository.findAll());
		return "shoppinglist";
	}
	
	 /*
	  * Not working
	  * 
	@RequestMapping(value="/storelist/{id}", method=RequestMethod.GET)
	public String storeList(@PathVariable("id") Long id, Model model) {
		model.addAttribute("items", irepository.findById(id));
		return "storelist";
	}
	
	*/
	
	@RequestMapping(value="/items", method=RequestMethod.GET)
	public @ResponseBody List<Item> getItemsRest() {
		return (List<Item>) irepository.findAll();
	}
	
	@RequestMapping(value="/items/{id}", method=RequestMethod.GET)
	public @ResponseBody Optional<Item> getItemRest(@PathVariable("id") Long id) {
		return irepository.findById(id);
	}
	
	@RequestMapping(value="/additem", method=RequestMethod.GET)
	public String addItem(Model model) {
		model.addAttribute("item", new Item());
		model.addAttribute("stores", srepository.findAll());
		return "additem";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Item item) {
		irepository.save(item);
		return "redirect:shoppinglist";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String deleteItem(@PathVariable("id") Long id, Model model) {
		irepository.deleteById(id);
		return "redirect:../shoppinglist";
	}
	
	@RequestMapping(value="/edititem/{id}")
	public String editItem(@PathVariable("id") Long id, Model model) {
		model.addAttribute("item", irepository.findById(id));
		model.addAttribute("stores", srepository.findAll());
		return "edititem";
	}
	
	
}

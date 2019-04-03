package hh.palvelinohjelmointi.ShoppingList.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Store {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long storeId;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
	private List<Item> items;
	

	public Store() {
		super();
	}

	public Store(String name) {
		super();
		this.name = name;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setId(Long storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Store [id=" + storeId + ", name=" + name + "]";
	}

}

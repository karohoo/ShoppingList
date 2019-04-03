package hh.palvelinohjelmointi.ShoppingList.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private int quantity;
	private String unit;
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "storeId")
	@JsonIgnore
	private Store store;
	
	public Item() {
		super();
	}

	public Item(String name, int quantity, String unit, String note, Store store) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.unit = unit;
		this.note = note;
		this.store = store;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	@Override
	public String toString() {
		if (this.store != null)
			return "Item [id=" + id +", name=" + name + ", quantity=" + quantity + ", unit=" + unit + ", note=" + note + ", store="
				+ this.getStore() + "]";
		else
			return "Item [id=" + id +", name=" + name + ", quantity=" + quantity + ", unit=" + unit + ", note=" + note + "]";
	}

	
	
	
	
}

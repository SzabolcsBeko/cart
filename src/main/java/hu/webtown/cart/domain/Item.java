package hu.webtown.cart.domain;

import java.io.Serializable;

public class Item implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int price;
	private boolean megaPack;
	private int count;

	public Item() {
		super();
	}

	public Item(int id, String name, int price, boolean megaPack, int count) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.megaPack = megaPack;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isMegaPack() {
		return megaPack;
	}

	public void setMegaPack(boolean megaPack) {
		this.megaPack = megaPack;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", megaPack=" + megaPack + ", count=" + count + "]";
	}

}
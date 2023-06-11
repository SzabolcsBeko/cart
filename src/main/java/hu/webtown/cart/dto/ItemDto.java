package hu.webtown.cart.dto;

public class ItemDto {
	
	private int id;
	private String name;
	private int price;
	private boolean megaPack;
	private int count;
	
	public ItemDto() {
		super();
	}

	public ItemDto(int id, String name, int price, boolean megaPack, int count) {
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "ItemDto [id=" + id + ", name=" + name + ", price=" + price + ", megaPack=" + megaPack + ", count="
				+ count + "]";
	}
		
}

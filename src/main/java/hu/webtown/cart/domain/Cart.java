package hu.webtown.cart.domain;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private int total;
	private int discountPrice;
	private String discountTypeName;
	private String eurRate;
	
	private List<DiscountType> cartItems = new ArrayList<DiscountType>();
	
	public Cart() {
		super();
	}
	
	public Cart(List<DiscountType> cartItems) {
		super();
		this.cartItems = cartItems;
	}

	public List<DiscountType> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<DiscountType> cartItems) {
		this.cartItems = cartItems;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getDiscountTypeName() {
		return discountTypeName;
	}

	public void setDiscountTypeName(String discountTypeName) {
		this.discountTypeName = discountTypeName;
	}

	public String getEurRate() {
		return eurRate;
	}

	public void setEurRate(String eurRate) {
		this.eurRate = eurRate;
	}
	
}

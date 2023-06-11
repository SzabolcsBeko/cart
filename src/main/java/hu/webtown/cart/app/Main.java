package hu.webtown.cart.app;

import java.util.ArrayList;
import java.util.List;

import hu.webtown.cart.domain.Cart;
import hu.webtown.cart.domain.DiscountMegaPack;
import hu.webtown.cart.domain.DiscountThreeForTwo;
import hu.webtown.cart.domain.DiscountType;
import hu.webtown.cart.item.Chestnut;
import hu.webtown.cart.item.Cucumber;
import hu.webtown.cart.item.RubberDuck;
import hu.webtown.cart.item.Salami;
import hu.webtown.cart.util.Converter;
import hu.webtown.cart.util.DiscountCalculatorHelper;
import hu.webtown.cart.util.DiscountTypeName;

public class Main {

	public static void main(String[] args) {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Chestnut(10))));
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Cucumber(10))));
		cartItems.add(new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new Salami(10))));
		cartItems.add(new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new RubberDuck(10))));
		Cart cart = new Cart(cartItems);
		DiscountCalculatorHelper.calculate(cart);
		DiscountCalculatorHelper.setCartTotalSum(cart);
		System.out.println("Total:" + cart.getTotal());
		System.out.println("DiscountType:" + cart.getDiscountTypeName());
		int discountPrice = cart.getTotal() - cart.getDiscountPrice(); 
		System.out.println("Discount:" + discountPrice);
		cart.getCartItems().stream().forEach(System.out::println);

	}
}

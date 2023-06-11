package hu.webtown.cart.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hu.webtown.cart.item.Chestnut;
import hu.webtown.cart.item.Cucumber;
import hu.webtown.cart.item.RubberDuck;
import hu.webtown.cart.item.Salami;
import hu.webtown.cart.util.Converter;
import hu.webtown.cart.util.DiscountCalculatorHelper;
import hu.webtown.cart.util.DiscountTypeName;

public class DomainTest {

	private Cart cart;
	
	@Before
	public void setUp() throws Exception {
		cart = new Cart();
	}

	@Test
	public void testChestnutDiscountPriceForTwelve() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Chestnut(12))));
		cart.setCartItems(cartItems);
		DiscountType discountType = cart.getCartItems().get(0);
		int originalPrice = discountType.getOriginalPrice();
		int discount = discountType.getDiscount(); 
		assertEquals(12000, originalPrice);
		assertEquals(6000, discount);
	}
	
	@Test
	public void testChestnutDiscountPriceForEleven() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Chestnut(11))));
		cart.setCartItems(cartItems);
		DiscountType discountType = cart.getCartItems().get(0);
		int originalPrice = discountType.getOriginalPrice();
		int discount = discountType.getDiscount();
		assertEquals(11000, originalPrice);
		assertEquals(0, discount);
	}
	
	@Test
	public void testSalamiDiscountPriceForThree() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new Salami(3))));
		cart.setCartItems(cartItems);
		DiscountType discountType = cart.getCartItems().get(0);
		int originalPrice = discountType.getOriginalPrice();
		int discount = discountType.getDiscount(); 
		assertEquals(6000, originalPrice);
		assertEquals(2000, discount);
	}
	
	@Test
	public void testSalamiDiscountPriceForTwo() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new Salami(2))));
		cart.setCartItems(cartItems);
		DiscountType discountType = cart.getCartItems().get(0);
		int originalPrice = discountType.getOriginalPrice();
		int discount = discountType.getDiscount(); 
		assertEquals(4000, originalPrice);
		assertEquals(0, discount);
	}
	
	@Test
	public void testCucumberDiscountPriceForTwelve() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Cucumber(12))));
		cart.setCartItems(cartItems);
		DiscountType discountType = cart.getCartItems().get(0);
		int originalPrice = discountType.getOriginalPrice();
		int discount = discountType.getDiscount(); 
		assertEquals(33600, originalPrice);
		assertEquals(6000, discount);
	}
	
	@Test
	public void testCucumberDiscountPriceForEleven() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Cucumber(11))));
		cart.setCartItems(cartItems);
		DiscountType discountType = cart.getCartItems().get(0);
		int originalPrice = discountType.getOriginalPrice();
		int discount = discountType.getDiscount();
		assertEquals(30800, originalPrice);
		assertEquals(0, discount);
	}
	
	@Test
	public void testRubberDuckDiscountPriceForThree() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new RubberDuck(3))));
		cart.setCartItems(cartItems);
		DiscountType discountType = cart.getCartItems().get(0);
		int originalPrice = discountType.getOriginalPrice();
		int discount = discountType.getDiscount(); 
		assertEquals(9000, originalPrice);
		assertEquals(3000, discount);
	}
	
	@Test
	public void testRubberDuckDiscountPriceForTwo() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new RubberDuck(2))));
		cart.setCartItems(cartItems);
		DiscountType discountType = cart.getCartItems().get(0);
		int originalPrice = discountType.getOriginalPrice();
		int discount = discountType.getDiscount(); 
		assertEquals(6000, originalPrice);
		assertEquals(0, discount);
	}

	@Test
	public void testMegaPackDicountTypeEvaluated() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new Salami(3))));
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Chestnut(12))));
		cart.setCartItems(cartItems);
		DiscountCalculatorHelper.calculate(cart);
		assertEquals(DiscountTypeName.MEGAPACK.getName(), cart.getDiscountTypeName());
		assertEquals(6000, cart.getDiscountPrice());
	}

	@Test
	public void testThreeForTwoDicountTypeEvaluated() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new RubberDuck(10))));
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Chestnut(12))));
		cart.setCartItems(cartItems);
		DiscountCalculatorHelper.calculate(cart);
		assertEquals(DiscountTypeName.THREEFORTWO.getName(), cart.getDiscountTypeName());
		assertEquals(9000, cart.getDiscountPrice());
	}
	
	@Test
	public void testMultipleDiscountTypeEvaluated() {
		List<DiscountType> cartItems = new ArrayList<DiscountType>();
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Chestnut(12))));
		cartItems.add(new DiscountMegaPack(DiscountTypeName.MEGAPACK.getName(), Converter.Item2Dto(new Cucumber(12))));
		cartItems.add(new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new Salami(3))));
		cartItems.add(new DiscountThreeForTwo(DiscountTypeName.THREEFORTWO.getName(), Converter.Item2Dto(new RubberDuck(3))));
		cart.setCartItems(cartItems);
		DiscountCalculatorHelper.calculate(cart);
		assertEquals(DiscountTypeName.MEGAPACK.getName(), cart.getDiscountTypeName());
		assertEquals(12000, cart.getDiscountPrice());
	}
	
}

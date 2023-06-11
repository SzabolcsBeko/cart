package hu.webtown.cart.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import hu.webtown.cart.domain.Cart;
import hu.webtown.cart.domain.DiscountType;

public class DiscountCalculatorHelper {

	private static Map<String, Integer> discountTypeMap = new HashMap<String, Integer>();
	
	public DiscountCalculatorHelper() {
		super();
	}

	public static void calculate(Cart cart) {

		Set<DiscountType> discountTypes = cart.getCartItems().stream().distinct().collect(Collectors.toSet());
		
		discountTypeMap.clear();

		for (DiscountType discountType : discountTypes) {
			setCumulatedDiscountByDiscountType(cart, discountType);
		}

		int max = -1;
		String key = "";
		for (Map.Entry<String, Integer> entry : discountTypeMap.entrySet()) {
			if(max < entry.getValue()) {
				key = entry.getKey();
				max = entry.getValue();
			}
		}
		cart.setDiscountPrice(max);
		cart.setDiscountTypeName(key);

	}

	private static void setCumulatedDiscountByDiscountType(Cart cart, DiscountType discountType) {
		List<DiscountType> result = cart.getCartItems().stream()
				.filter(f -> f.getDiscountTypeName().equals(discountType.getDiscountTypeName()))
				.collect(Collectors.toList());
		int discount = 0;
		for (DiscountType discType : result) {
			discount = discType.getDiscount();
			if(discountTypeMap.containsKey(discountType.getDiscountTypeName())) {
				int currentDiscount = discountTypeMap.get(discountType.getDiscountTypeName()); 
				discountTypeMap.replace(discountType.getDiscountTypeName(), Integer.valueOf(currentDiscount), Integer.valueOf(currentDiscount + discount));	
			}
			else {
				discountTypeMap.put(discountType.getDiscountTypeName(), Integer.valueOf(discount));
			}
		}
	}
	
	public static void setCartTotalSum(Cart cart) {
		int sum = 0;
		for(DiscountType discountType : cart.getCartItems()) {
			sum +=discountType.getOriginalPrice();
		}
		cart.setTotal(sum);
	}

}

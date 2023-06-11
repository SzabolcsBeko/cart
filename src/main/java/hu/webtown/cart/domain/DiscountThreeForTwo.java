package hu.webtown.cart.domain;

import hu.webtown.cart.dto.ItemDto;

public class DiscountThreeForTwo extends DiscountType {

	public DiscountThreeForTwo(String name, ItemDto itemDto) {
		super(name, itemDto);
	}

	/**
	 * Just calculate the discount, not the payment amount.
	 * The algorithm calculating the discount: count * 2/3 * unit price
	 * would not be efficient.
	 * 
	 * Just the discount is calculated, at the end of the process the discount is
	 * deducted from the total, resulting the payment.
	 * 
	 *  Not using any other algorithms.
	 */
	@Override
	public int getDiscount() {
		if(getItemDto().getCount() < 3) {
			return 0;
		}
		else {
			return (getItemDto().getCount() / 3) * getItemDto().getPrice();
		}
	}
	
}

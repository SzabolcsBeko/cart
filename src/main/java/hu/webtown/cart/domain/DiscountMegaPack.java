package hu.webtown.cart.domain;

import hu.webtown.cart.dto.ItemDto;

public class DiscountMegaPack extends DiscountType {

	public DiscountMegaPack(String name, ItemDto itemDto) {
		super(name, itemDto);
	}
	@Override
	public int getDiscount() {
		int discount = 0;
		if(getItemDto().getCount() >= 12) {
			discount = (getItemDto().getCount()/12) * 6000;
		}
		return discount;
	}

}

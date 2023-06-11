package hu.webtown.cart.item;

import hu.webtown.cart.domain.Item;
import hu.webtown.cart.util.ItemName;

public class Chestnut extends Item {

	private static final long serialVersionUID = -3298983931390034583L;

	public Chestnut(int count) {
		super(1, ItemName.CHESTNUT.getName(), 1000, true, count);
	}

}

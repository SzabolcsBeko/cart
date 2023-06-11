package hu.webtown.cart.item;

import hu.webtown.cart.domain.Item;
import hu.webtown.cart.util.ItemName;

public class RubberDuck extends Item {
	
	private static final long serialVersionUID = -710915309530390600L;

	public RubberDuck(int count) {
		super(3, ItemName.RUBBERDUCK.getName(), 3000, false, count);
	}

}

package hu.webtown.cart.item;

import hu.webtown.cart.domain.Item;
import hu.webtown.cart.util.ItemName;

public class Cucumber extends Item {

	private static final long serialVersionUID = 72592934980629365L;

	public Cucumber(int count) {
		super(2, ItemName.CUCUMBER.getName(), 2800, true, count);
	}
	
}

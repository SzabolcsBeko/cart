package hu.webtown.cart.item;

import hu.webtown.cart.domain.Item;
import hu.webtown.cart.util.ItemName;

public class Salami extends Item {

	private static final long serialVersionUID = 1857315121879041053L;

	public Salami(int count) {
		super(4, ItemName.SALAMI.getName(), 2000, false, count);
	}

}

package hu.webtown.cart.util;

import hu.webtown.cart.domain.Item;
import hu.webtown.cart.dto.ItemDto;

public class Converter {
	
	public static Item dto2Item(ItemDto dto) {
		return new Item(dto.getId(), dto.getName(), dto.getPrice(), dto.isMegaPack(), dto.getCount());
	}
	
	public static ItemDto Item2Dto(Item item) {
		return new ItemDto(item.getId(), item.getName(), item.getPrice(), item.isMegaPack(), item.getCount());
	}

}

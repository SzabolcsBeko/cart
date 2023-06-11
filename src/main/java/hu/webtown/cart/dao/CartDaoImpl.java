package hu.webtown.cart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hu.webtown.cart.dto.ItemDto;

public class CartDaoImpl implements CartDao {

	private List<ItemDto> cartItemDtos = new ArrayList<ItemDto>();
	
	public CartDaoImpl() {
		super();
	}
	
	public CartDaoImpl(List<ItemDto> cartItemDtos) {
		super();
		this.cartItemDtos = cartItemDtos;
	}

	@Override
	public boolean addItemDto(ItemDto item) {
		return cartItemDtos.add(item);
	}
	
	@Override
	public List<ItemDto> getAllItemDtos() {
		return cartItemDtos.stream().collect(Collectors.toList());
	}

	@Override
	public ItemDto getItemDtoById(int id) {
		return cartItemDtos.stream().filter(a -> Integer.valueOf(a.getId()).equals(Integer.valueOf(id))).findFirst().orElseThrow();
	}
	
	@Override
	public boolean updateItemDto(ItemDto item) {
		boolean result = false;
		ItemDto it = getItemDtoById(item.getId());
		if(cartItemDtos.contains(it)){
			int index = cartItemDtos.indexOf(it);
			cartItemDtos.set(index, item);
			result = true;
		}
		return result;
	}
	
	@Override
	public boolean deleteItemDto(ItemDto itemDto) {
		boolean result = false;
		ItemDto it = getItemDtoById(itemDto.getId());
		if(cartItemDtos.contains(it)){
			int index = cartItemDtos.indexOf(it);
			cartItemDtos.remove(index);
			result = true;
		}
		return result;
	}
	
	public static void main(String[] args) {
		CartDaoImpl cartDaoImpl = new CartDaoImpl();
		cartDaoImpl.getAllItemDtos().forEach(System.out::println);
	}

}

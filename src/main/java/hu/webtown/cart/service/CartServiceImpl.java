package hu.webtown.cart.service;

import java.util.ArrayList;
import java.util.List;

import hu.webtown.cart.dao.CartDao;
import hu.webtown.cart.dao.CartDaoImpl;
import hu.webtown.cart.dto.ItemDto;

public class CartServiceImpl implements CartService {

	private CartDao cartDao = new CartDaoImpl();
	
	public CartServiceImpl(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	@Override
	public List<ItemDto> getAllItemDtos() {
		List<ItemDto> result = new ArrayList<ItemDto>();
		for(ItemDto itemDto: cartDao.getAllItemDtos()){
			result.add(itemDto);
		}
		return result;
	}

	@Override
	public boolean addItemDto(ItemDto itemDto) {
		return cartDao.addItemDto(itemDto);
	}
	
	@Override
	public ItemDto getItemDtoById(int id) {
		ItemDto result = cartDao.getItemDtoById(id);
		return result;
	}
	
	@Override
	public boolean updateItemDto(ItemDto itemDto) {
		return cartDao.updateItemDto(itemDto);
	}
	
	@Override
	public boolean deleteItemDto(ItemDto itemDto) {
		return cartDao.deleteItemDto(itemDto);
	}
	
}

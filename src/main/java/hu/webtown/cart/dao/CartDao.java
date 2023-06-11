package hu.webtown.cart.dao;

import java.util.List;

import hu.webtown.cart.dto.ItemDto;

public interface CartDao {
	
	public List<ItemDto> getAllItemDtos();
	
	public boolean addItemDto(ItemDto itemDto);
	
	public ItemDto getItemDtoById(int id);
	
	public boolean updateItemDto(ItemDto itemDto);
	
	public boolean deleteItemDto(ItemDto itemDto);
	
}

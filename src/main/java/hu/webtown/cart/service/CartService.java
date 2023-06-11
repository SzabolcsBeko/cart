package hu.webtown.cart.service;

import java.util.List;

import hu.webtown.cart.dto.ItemDto;

public interface CartService {

	public List<ItemDto> getAllItemDtos();
	
	public boolean addItemDto(ItemDto iteDto);

	public ItemDto getItemDtoById(int id);
	
	public boolean updateItemDto(ItemDto itemDto); 
	
	public boolean deleteItemDto(ItemDto itemDto); 

}

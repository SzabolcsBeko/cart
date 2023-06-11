package hu.webtown.cart.domain;

import java.util.Objects;

import hu.webtown.cart.dto.ItemDto;

public abstract class DiscountType {
	
	private String discountTypeName;
	private ItemDto itemDto;
		
	public DiscountType() {
		super();
	}

	public DiscountType(String name, ItemDto itemDto) {
		super();
		this.discountTypeName = name;
		this.itemDto = itemDto;
	}

	public String getDiscountTypeName() {
		return discountTypeName;
	}

	public void setDiscountTypeName(String name) {
		this.discountTypeName = name;
	}

	public ItemDto getItemDto() {
		return itemDto;
	}

	public void setItemDto(ItemDto itemDto) {
		this.itemDto = itemDto;
	}

	public abstract int getDiscount();
	
	public int getOriginalPrice() {
		return itemDto.getCount() * itemDto.getPrice();
	}

	@Override
	public int hashCode() {
		return Objects.hash(discountTypeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiscountType other = (DiscountType) obj;
		return Objects.equals(discountTypeName, other.discountTypeName);
	}

	@Override
	public String toString() {
		return "DiscountType [discountTypeName=" + discountTypeName + ", itemDto=" + itemDto + "]";
	}

	
	
}

package hu.webtown.cart.util;

public enum DiscountTypeName {
	
	THREEFORTWO("ThreeForTwo"),
	MEGAPACK("MegaPack");
	
    private String discountTypeName;
 
	DiscountTypeName(String name) {
        this.discountTypeName = name;
    }
 
    public String getName() {
        return discountTypeName;
    }

}

package hu.webtown.cart.util;

public enum ItemName {
	
	CHESTNUT("Chestnut"),
	CUCUMBER("Cucumber"),
	RUBBERDUCK("Rubberduck"),
	SALAMI("Salami");
	
    private String name;
 
    ItemName(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
	
}

package item;

public class Item {
	private String categoryName;
	private String name;
	private int price;

	public Item(String categoryName, String name, int price) {
		this.categoryName = categoryName;
		this.name = name;
		this.price = price;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [categoryName=" + categoryName + ", name=" + name + ", price=" + price + "]";
	}

}

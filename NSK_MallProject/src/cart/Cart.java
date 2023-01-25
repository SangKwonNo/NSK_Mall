package cart;

public class Cart {
	private String memberID;
	private String name;
	private int price;

	public Cart(String memberID, String name, int price) {
		this.memberID = memberID;
		this.name = name;
		this.price = price;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
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
		return "Cart [memberID=" + memberID + ", name=" + name + ", price=" + price + "]";
	}

}

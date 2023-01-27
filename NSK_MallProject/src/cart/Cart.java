package cart;

import item.Item;

public class Cart {
	private String memberID;
	private Item item;

	public Cart(String memberID, Item item) {
		this.memberID = memberID;
		this.item = item;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public Item getItem() {
		return item;
	}

	public void setItem() {
		this.item = item;
	}

	@Override
	public String toString() {
		return item.toString();
	}

}

package cart;

import java.util.ArrayList;

public class CartDAO {
	private static CartDAO cartDAO = new CartDAO();
	private ArrayList<Cart> cartList;

	public static CartDAO getCartDAO() {
		return cartDAO;
	}

	private CartDAO() {
		cartList = new ArrayList<>();
	}
	
	public ArrayList<Cart> getCartList() {
		return cartList;
	}
	
	public Cart findCart(String id) {
		for (Cart cart : cartList) {
			if (cart.getMemberID().equals(id)) {
				return cart;
			}
		}
		return null;
	}
}

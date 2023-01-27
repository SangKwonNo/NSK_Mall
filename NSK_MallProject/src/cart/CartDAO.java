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
	
	public void delCart(int delIdx) {
		cartList.remove(delIdx);
	}
	
	public void delAllCart(String logInID) {
		for (Cart cart : cartList) {
			if (logInID.equals(cart.getMemberID())) {
				cart = null;
			}
		}
	}
	
	public Cart findCart(String id) {
		for (Cart cart : cartList) {
			if (cart.getMemberID().equals(id)) {
				return cart;
			}
		}
		return null;
	}

	public void addCart(Cart cart) {
		cartList.add(cart);
	}
}

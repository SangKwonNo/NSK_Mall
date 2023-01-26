package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;

public class Member_showCart implements MenuCommand {

	private MallController mallCon;
	private CartDAO cartDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		cartDAO = CartDAO.getCartDAO();
	}

	@Override
	public String update() {
		String key = "Member_Cart";
		System.out.println("===============");
		showCartList(cartDAO.getCartList());
		System.out.println("===============");
		return key;
	}

	private void showCartList(ArrayList<Cart> cartList) {
		int cartNumber = 1;
		for (Cart cart : cartList) {
			System.out.println(cartNumber + " )" + cart.toString());
		}
	}
}

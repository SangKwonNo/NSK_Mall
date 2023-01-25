package menu_admin;

import _mall.MenuCommand;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;

public class Admin_showCartList implements MenuCommand {

	private MallController mallCon;
	private CartDAO cartDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		cartDAO = CartDAO.getCartDAO();
	}

	@Override
	public String update() {
		String key = "Admin_CartMenu";
		for (Cart cart : cartDAO.getCartList()) {
			System.out.println(cart.toString());
		}
		return key;
	}

}

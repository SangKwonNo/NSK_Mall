package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;

public class Admin_SearchCart implements MenuCommand {

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
		System.out.println("[ 회원 아이디 입력 ]");
		String memberID = _Main.sc.next();
		Cart findCart = cartDAO.findCart(memberID);
		if (findCart == null) {
			System.err.println("[ 입력한 회원 아이디 없음 ]");
		} else {
			System.out.println(findCart.toString());
		}
		return key;
	}

}

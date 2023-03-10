package menu_member;

import _mall.MenuCommand;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;

public class Member_buyCart implements MenuCommand {

	private MallController mallCon;
	private CartDAO cartDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		cartDAO = CartDAO.getCartDAO();
	}

	@Override
	public String update() {
		String key = "Member_Main";
		int totalPrice = 0;
		String logInID = mallCon.getMemberID();

		for (Cart cart : cartDAO.getCartList()) {
			if (logInID.equals(cart.getMemberID())) {
				totalPrice += cart.getItem().getPrice();
			}
		}
		System.out.printf("[ 총 금액 : %d원 구매 완료 ] \n", totalPrice);

		return key;
	}
}

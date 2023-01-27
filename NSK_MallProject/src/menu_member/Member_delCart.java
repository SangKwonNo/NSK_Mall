package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;
import myUtil.Util;

public class Member_delCart implements MenuCommand {

	private MallController mallCon;
	private CartDAO cartDAO;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		cartDAO = CartDAO.getCartDAO();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Member_Shop";
		ArrayList<Cart> cartList = cartDAO.getCartList();

		showCartList(cartList);
		int sel = util.getInt("[ 삭제할 번호 입력 ]", 1, cartList.size());
		if (sel == -1) {
			return key;
		}

		cartDAO.delCart(sel - 1);
		System.out.println("[ 품목 삭제 완료 ]");
		return key;
	}

	private void showCartList(ArrayList<Cart> cartList) {
		int cartNumber = 1;
		for (Cart cart : cartList) {
			System.out.println(cartNumber + ") " + cart.toString());
			cartNumber++;
		}
	}
}

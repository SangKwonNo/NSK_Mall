package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;

public class Member_delCart implements MenuCommand {

	private MallController mallCon;
	private CartDAO cartDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		cartDAO = CartDAO.getCartDAO();
	}

	@Override
	public String update() {
		String key = "Member_Shop";
		ArrayList<Cart> cartList = cartDAO.getCartList();

		showCartList(cartList);
		System.out.println("[ 삭제할 번호 입력 ]");
		int sel = _Main.sc.nextInt();
		cartDAO.delCart(sel);
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

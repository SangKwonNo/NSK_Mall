package menu_member;

import _mall.MenuCommand;
import cart.CartDAO;
import controller.MallController;
import myUtil.Util;

public class Member_Cart implements MenuCommand {

	private MallController mallCon;
	private Util util;
	private CartDAO cartDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		util = Util.getUtil();
		cartDAO = CartDAO.getCartDAO();
	}

	@Override
	public String update() {
		String key = "Member_Cart";
		if (cartDAO.getCartList() == null) {
			System.err.println("[ 장바구니 목록 없음 ]");
			key = "Member_Main";
			return key;
		}

		int sel = util.getInt(getMenu(), 0, 4);
		if (sel == 1) {
			key = "Member_delCart";
		} else if (sel == 2) {
			key = "Member_delAllCart";
		} else if (sel == 3) {
			key = "Member_showCart";
		} else if (sel == 4) {
			key = "Member_buyCart";
		} else if (sel == 0) {
			key = "Member_Main";
		}
		return key;
	}

	private String getMenu() {
		String menu = "[1.선택삭제]\n[2.전부삭제]\n[3.장바구니출력]\n[4.구입]\n[0.뒤로가기]";
		return menu;
	}
}

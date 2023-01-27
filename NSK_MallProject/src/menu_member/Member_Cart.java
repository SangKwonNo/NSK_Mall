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
			System.err.println("[ ��ٱ��� ��� ���� ]");
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
		String menu = "[1.���û���]\n[2.���λ���]\n[3.��ٱ������]\n[4.����]\n[0.�ڷΰ���]";
		return menu;
	}
}

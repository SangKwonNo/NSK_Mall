package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import myUtil.Util;

public class Member_Shop implements MenuCommand {

	private MallController mallCon;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Member_Shop";
		int sel = util.getInt(getMenu(), 0, 1);
		if (sel == 1) {
			key = "Member_addCart";
		} else if (sel == 0) {
			key = "Member_Main";
		}
		return key;
	}

	private String getMenu() {
		String menu = "[1.장바구니 담기]\n[0.뒤로가기]";
		return menu;
	}
}

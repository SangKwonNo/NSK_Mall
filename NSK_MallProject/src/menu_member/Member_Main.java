package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import myUtil.Util;

public class Member_Main implements MenuCommand {

	private MallController mallCon;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Member_Main";
		int sel = util.getInt(getMenu(), 0, 3);
		if (sel == 1) {
			key = "Member_Shop";
		} else if (sel == 2) {
			key = "Member_Cart";
		} else if (sel == 3) {
			key = "Member_showInfo";
		} else if (sel == 0) {
			mallCon.setMemberID(null);
			key = "Mall_Main";
		}
		return key;
	}

	private String getMenu() {
		String menu = "[1.쇼핑]\n[2.장바구니]\n[3.회원정보]\n[0.로그아웃]";
		return menu;
	}
}

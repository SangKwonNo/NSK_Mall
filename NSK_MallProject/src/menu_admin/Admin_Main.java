package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import myUtil.Util;

public class Admin_Main implements MenuCommand {

	private MallController mallCon;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Admin_Main";
		int sel = util.getInt(getMenu(), 0, 4);
		if (sel == 1) {
			key = "Admin_MemberMenu";
		} else if (sel == 2) {
			key = "Admin_CartMenu";
		} else if (sel == 3) {
			key = "Admin_ItemMenu";
		} else if (sel == 0) {
			key = "Mall_Main";
			mallCon.setMemberID(null);
			System.out.println("[ 로그아웃 성공 ]");
		}
		return key;
	}

	private String getMenu() {
		String menu = "[1.회원관리]\n[2.카트관리]\n[3.아이템관리]\n[0.로그아웃]";
		return menu;
	}
}

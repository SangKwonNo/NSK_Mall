package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import myUtil.Util;

public class Admin_CartMenu implements MenuCommand {

	private MallController mallCon;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Admin_CartMenu";
		int sel = util.getInt(getMenu(), 0, 2);
		if (sel == 1) {
			key = "Admin_SearchCart";
		} else if (sel == 2) {
			key = "Admin_showCartList";
		} else if (sel == 0) {
			key = "Admin_Main";
		}

		return key;
	}

	private String getMenu() {
		String menu = "[1.카트검색]\n[2.전체출력]\n[0.뒤로가기]";
		return menu;
	}
}

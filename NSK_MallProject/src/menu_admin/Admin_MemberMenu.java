package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import myUtil.Util;

public class Admin_MemberMenu implements MenuCommand {

	private MallController mallCon;
	private Util util;
	
	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Admin_MemberMenu";
		int sel = util.getInt(getMenu(), 0, 2);
		if (sel == 1) {
			key = "Admin_SearchMember";
		} else if (sel == 2) {
			key = "Admin_showMemberList";
		} else if (sel == 0) {
			key = "Admin_Main";
		}
		
		return key;
	}

	private String getMenu() {
		String menu = "[1.회원검색]\n[2.전체출력]\n[0.뒤로가기]";
		return menu;
	}
}

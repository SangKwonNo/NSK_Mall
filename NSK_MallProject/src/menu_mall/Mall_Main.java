package menu_mall;

import _mall.MenuCommand;
import controller.MallController;
import myUtil.Util;

public class Mall_Main implements MenuCommand {

	private MallController mallCon;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Mall_Main";
		int sel = util.getInt(getMenu(), 0, 2);
		if (sel == 1) {
			key = "Mall_SignUp";
		} else if (sel == 2) {
			key = "Mall_Login";
		} else if (sel == 0) {
			key = null;
		}
		return key;
	}

	private String getMenu() {
		String menu = "[1.회원가입]\n[2.로그인]\n[0.종료]";
		return menu;
	}

}

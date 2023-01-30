package menu_order;

import _mall.MenuCommand;
import controller.MallController;
import myUtil.Util;

public class Order_Main implements MenuCommand {
	private MallController mallCon;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		util = Util.getUtil();

	}

	@Override
	public String update() {
		String key = "Order_Main";
		int sel = util.getInt(getMenu(), 0, 1);
		if (sel == 1) {
			key = "Order_PrintAll";
		} else if (sel == 2) {
			key = "Order_PrintSearchOrder";
		} else if (sel == 0) {
			key = "Admin_Main";
		}
		return key;
	}

	private String getMenu() {
		String menu = "[1.��ü�ֹ����][2.�ֹ���ϰ˻�]\n[0.�ڷΰ���]";
		return menu;
	}

}

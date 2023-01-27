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
		int sel = util.getInt(getMenu(), 0, 4);
		if (sel == 1) {
			key = "Order_DeliveryTrue";
		} else if (sel == 2) {
			key = "Order_DeliveryFalse";
		} else if (sel == 3) {
			key = "Order_PrintAll";
		} else if (sel == 4) {
			key = "Order_PrintSearchOrder";
		} else if (sel == 0) {
			key = "Admin_Main";
		}
		return key;
	}

	private String getMenu() {
		String menu = "[1.배송완료]\n[2.배송취소]\n[3.전체주문목록]\n[4.주문목록검색]\n[0.뒤로가기]";
		return menu;
	}

}

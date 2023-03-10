package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import item.ItemDAO;
import myUtil.Util;

public class Admin_ItemMenu implements MenuCommand {

	private MallController mallCon;
	private ItemDAO itemDAO;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		itemDAO = ItemDAO.getItemDAO();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Admin_ItmeMenu";
		int sel = util.getInt("[1.아이템추가]\n[2.아이템삭제]\n[3.전체출력]\n[0.뒤로가기]", 0, 3);
		if (sel == 1) {
			key = "Admin_addItem";
		} else if (sel == 2) {
			key = "Admin_delItem";
		} else if (sel == 3) {
			key = "Admin_showItemList";
		} else if (sel == 0) {
			key = "Admin_Main";
		}

		return key;
	}

	private String getMenu() {
		String menu = "[1.아이템추가]\n[2.아이템삭제]\n[3.전체출력]\n[0.뒤로가기]";
		return menu;
	}
}

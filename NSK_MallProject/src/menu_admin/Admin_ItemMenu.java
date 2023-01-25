package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import item.ItemDAO;

public class Admin_ItemMenu implements MenuCommand {

	private MallController mallCon;
	private ItemDAO itemDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		itemDAO = ItemDAO.getItemDAO();
	}

	@Override
	public String update() {
		String key = "Admin_ItmeMenu";
		System.out.println("[1.아이템추가][2.아이템삭제][3.전체출력][0.뒤로가기]");
		int sel = _Main.sc.nextInt();
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

}

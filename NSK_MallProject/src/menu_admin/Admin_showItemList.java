package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import item.Item;
import item.ItemDAO;

public class Admin_showItemList implements MenuCommand {

	private MallController mallCon;
	private ItemDAO itemDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		itemDAO = ItemDAO.getItemDAO();
	}

	@Override
	public String update() {
		String key = "Admin_ItemMenu";
		for (Item item : itemDAO.getItemList()) {
			System.out.println(item.toString());
		}

		return key;

	}

}

package menu_admin;

import java.util.ArrayList;

import _mall.MenuCommand;
import controller.MallController;
import item.Item;
import item.ItemDAO;
import myUtil.Util;

public class Admin_delItem implements MenuCommand {

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
		String key = "Admin_ItemMenu";
		ArrayList<String> categoryList = itemDAO.getCategoryList();
		showCategoryList(categoryList);

		int sel = util.getInt("[ 삭제할 아이템 카테고리 입력 ]", 1, categoryList.size());
		if (sel == -1) {
			return key;
		}
		String selCategory = categoryList.get(sel - 1);

		showSelCategoryItem(selCategory, itemDAO.getItemList());
		String name = util.getName("[ 삭제할 아이템 입력 ]");
		if (name == null) {
			return key;
		}
		
		int delIdx = itemDAO.isItem(name, selCategory);
		if (delIdx == -1) {
			System.err.println("[ 존재하지 않는 아이템 ]");
		} else {
			itemDAO.delItem(delIdx);
			System.out.println("[ 아이템 삭제 완료 ]");
		}
		return key;
	}

	private void showCategoryList(ArrayList<String> categoryList) {
		int categoryNumber = 1;
		for (String category : categoryList) {
			System.out.println(categoryNumber + ") " + category);
			categoryNumber++;
		}
	}

	private void showSelCategoryItem(String selCategory, ArrayList<Item> itemList) {
		int itemNumber = 1;
		for (Item item : itemList) {
			if (item.getCategoryName().equals(selCategory)) {
				System.out.println(item.getName());
			}
		}
	}
}

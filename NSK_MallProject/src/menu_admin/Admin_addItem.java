package menu_admin;

import java.util.ArrayList;

import _mall.MenuCommand;
import controller.MallController;
import item.Item;
import item.ItemDAO;
import myUtil.Util;

public class Admin_addItem implements MenuCommand {

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
		int sel = util.getInt("[ 추가할 아이템 카테고리 입력 ]", 1, categoryList.size());
		if (sel == -1) {
			return key;
		}
		String selCategory = categoryList.get(sel - 1);

		String name = util.getName("[ 추가할 아이템 입력 ]");
		int idx = itemDAO.isItem(name, selCategory);
		if (idx != -1) {
			System.err.println("[ 중복된 아이템 이름 ]");
		} else {
			int price = util.getInt("[ 아이템 가격 입력 ]", 0, 999999999);
			if (price == -1) {
				return key;
			}
			itemDAO.addItem(new Item(selCategory, name, price));
			System.out.println("[ 아이템 추가 완료 ]");
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
}

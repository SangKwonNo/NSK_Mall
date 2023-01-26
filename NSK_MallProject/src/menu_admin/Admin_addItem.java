package menu_admin;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import item.Item;
import item.ItemDAO;

public class Admin_addItem implements MenuCommand {

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
		ArrayList<String> categoryList = itemDAO.getCategoryList();
		showCategoryList(categoryList);
		System.out.println("[ 추가할 아이템 카테고리 입력 ]");
		int sel = _Main.sc.nextInt();
		String selCategory = categoryList.get(sel - 1);
		System.out.println("[ 추가할 아이템 입력 ]");
		String name = _Main.sc.next();
		
		int idx = itemDAO.isItem(name, selCategory);
		if (idx != -1) {
			System.err.println("[ 중복된 아이템 이름 ]");
		} else {
			System.out.println("[ 아이템 가격 입력 ]");
			int price = _Main.sc.nextInt();
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

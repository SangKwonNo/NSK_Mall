package menu_admin;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import item.ItemDAO;

public class Admin_delItem implements MenuCommand {

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
		System.out.println("[ 삭제할 아이템 카테고리 입력 ]");
		int sel = _Main.sc.nextInt();
		String selCategory = categoryList.get(sel - 1);
		System.out.println("[ 삭제할 아이템 입력 ]");
		String name = _Main.sc.next();
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
}

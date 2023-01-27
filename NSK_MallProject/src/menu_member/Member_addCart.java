package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;
import item.Item;
import item.ItemDAO;
import myUtil.Util;

public class Member_addCart implements MenuCommand {

	private MallController mallCon;
	private ItemDAO itemDAO;
	private CartDAO cartDAO;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		itemDAO = ItemDAO.getItemDAO();
		cartDAO = CartDAO.getCartDAO();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Member_Shop";
		ArrayList<String> categoryList = itemDAO.getCategoryList();
		ArrayList<Item> itemList = itemDAO.getItemList();
		
		showCategory(categoryList);
		int sel = util.getInt("[ ī�װ� ���� ]", 1, categoryList.size());
		if (sel == -1) {
			return key;
		}
		
		String selCategory = categoryList.get(sel - 1);
		showSelCategoryItem(selCategory, itemList);
		
		String name = util.getName("[ �߰��� ������ �Է� ]");
		if (name == null) {
			return key;
		}
		
		int idx = itemDAO.isItem(name, selCategory);
		if(idx == -1) {
			System.err.println("[ �Է��� ������ ���� ]");
		} else {
			cartDAO.addCart(new Cart(mallCon.getMemberID(), itemDAO.getItemList().get(idx)));
			System.out.println("[ ��ٱ��� �߰� �Ϸ� ]");
		}
		return key;

	}

	private void showCategory(ArrayList<String> categoryList) {
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
				System.out.println(itemNumber + ") " + item.getName());
				itemNumber++;
			}
		}
	}
}

package menu_member;

import java.util.ArrayList;

import _mall.MenuCommand;
import _mall._Main;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;
import item.Item;
import item.ItemDAO;

public class Member_addCart implements MenuCommand {

	private MallController mallCon;
	private ItemDAO itemDAO;
	private CartDAO cartDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		itemDAO = ItemDAO.getItemDAO();
		cartDAO = CartDAO.getCartDAO();
	}

	@Override
	public String update() {
		String key = "Member_Shop";
		ArrayList<String> categoryList = itemDAO.getCategoryList();
		ArrayList<Item> itemList = itemDAO.getItemList();
		showCategory(categoryList);
		System.out.println("[ ī�װ� ���� ]");
		int sel = _Main.sc.nextInt() - 1;
		String selCategory = categoryList.get(sel);
		showSelCategoryItem(selCategory, itemList);
		System.out.println("[ �߰��� ������ �Է� ]");
		String name = _Main.sc.next();
		int idx = itemDAO.isItem(name, selCategory);
		if(idx == -1) {
			System.err.println("[ �Է��� ������ ���� ]");
		} else {
			cartDAO.addCart(new Cart(mallCon.getMemberID(), name, itemList.get(idx).getPrice()));
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

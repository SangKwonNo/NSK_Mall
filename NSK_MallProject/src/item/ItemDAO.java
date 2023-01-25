package item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class ItemDAO {
	private static ItemDAO itemDAO = new ItemDAO();
	private ArrayList<Item> itemList;

	public static ItemDAO getItemDAO() {
		return itemDAO;
	}

	private ItemDAO() {
		itemList = new ArrayList<>();
		itemList.add(new Item("과자", "새우깡", 1200));
		itemList.add(new Item("과자", "홈런볼", 1600));
		itemList.add(new Item("음료수", "사이다", 800));
		itemList.add(new Item("음료수", "콜라", 1000));
		itemList.add(new Item("생선", "고등어", 8000));
		itemList.add(new Item("생선", "갈치", 12000));
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

	public void delItem(int delIdx) {
		itemList.remove(delIdx);
	}

	public ArrayList<String> getCategoryList() {
		Set<String> categorys = new TreeSet<>();
		for (Item item : itemList) {
			categorys.add(item.getCategoryName());
		}
		ArrayList<String> categoryList = new ArrayList<>();
		Iterator<String> category = categorys.iterator();
		while (category.hasNext()) {
			categoryList.add(category.next());
		}
		return categoryList;

	}

	public int isItem(String newItem, String selCategory) {
		int idx = 0;
		for (Item item : itemList) {
			if (item.getName().equals(newItem) && item.getCategoryName().equals(selCategory)) {
				return idx;
			}
			idx++;
		}
		return -1;
	}
}

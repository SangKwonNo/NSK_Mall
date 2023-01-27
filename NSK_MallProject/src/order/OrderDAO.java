package order;

import java.util.ArrayList;

import cart.Cart;
import item.Item;

public class OrderDAO {
	private static OrderDAO orderDAO = new OrderDAO();
	private ArrayList<ArrayList<Cart>> orderList;

	public static OrderDAO getOrderDAO() {
		return orderDAO;
	}

	private OrderDAO() {
		orderList = new ArrayList<>();

	}

	public void addOrder(ArrayList<Cart> cartList) {
		orderList.add(cartList);
	}

	public ArrayList<ArrayList<Cart>> getOrderList() {
		return orderList;
	}

	public void insertData(String idData, String itemData) {
		String[] temp = data.split(":");
		Item item = null;
		for (int i = 0; i < temp.length; i++) {
			if (i % 2 == 1) {
				String[] info = temp[i].split("\n");
				String[] ItemInfo = info[i].split("/");
				item = new Item(ItemInfo[0], ItemInfo[1], Integer.parseInt(ItemInfo[2]));
			}
			for (ArrayList<Cart> cartList : orderList) {
				cartList.add(new Cart(temp[0], item));
				System.out.println(cartList.toString());
			}
		}

	}
}

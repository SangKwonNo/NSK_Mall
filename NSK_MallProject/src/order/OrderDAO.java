package order;

import java.util.ArrayList;

import cart.Cart;

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
		
	}
}

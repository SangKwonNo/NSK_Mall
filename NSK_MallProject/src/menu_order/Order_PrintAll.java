package menu_order;

import java.util.ArrayList;

import _mall.MenuCommand;
import cart.Cart;
import controller.MallController;
import order.OrderDAO;

public class Order_PrintAll implements MenuCommand {

	private MallController mallCon;
	private OrderDAO orderDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		orderDAO = OrderDAO.getOrderDAO();
	}

	@Override
	public String update() {
		String key = "Order_Main";
		int idx = 0;
		for (ArrayList<Cart> cartList : orderDAO.getOrderList()) {
			System.out.println(cartList.get(idx).getMemberID());
			for (Cart cart : cartList) {
				System.out.println(cart.toString());
			}
			idx++;
		}

		return key;
	}

}

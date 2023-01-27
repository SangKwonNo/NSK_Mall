package menu_order;

import java.util.ArrayList;

import _mall.MenuCommand;
import cart.Cart;
import controller.MallController;
import myUtil.Util;
import order.OrderDAO;

public class Order_PrintSearchOrder implements MenuCommand {
	private MallController mallCon;
	private OrderDAO orderDAO;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		orderDAO = OrderDAO.getOrderDAO();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Order_Main";
		String logInID = mallCon.getMemberID();
		String searchID = util.getValue("[ 검색할 아이디 입력 ]");
		if (searchID == null) {
			return key;
		}
		
		for (ArrayList<Cart> cartList : orderDAO.getOrderList()) {
			for (Cart cart : cartList) {
				if (cart.getMemberID().equals(logInID)) {
					System.out.println(cart.toString());
				}
			}
		}
		return key;
	}

}

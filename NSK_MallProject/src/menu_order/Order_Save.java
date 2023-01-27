package menu_order;

import java.io.FileWriter;
import java.io.IOException;

import _mall.MenuCommand;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;
import order.OrderDAO;

public class Order_Save implements MenuCommand {

	private MallController mallCon;
	private OrderDAO orderDAO;
	private CartDAO cartDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		orderDAO = OrderDAO.getOrderDAO();
		cartDAO = CartDAO.getCartDAO();
	}

	@Override
	public String update() {
		String key = "Member_Main";
		FileWriter fwID = null;
		FileWriter fwItem = null;
		String idData = "";
		String itemData = "";
		idData += mallCon.getMemberID() + "\n";
		for (Cart cart : cartDAO.getCartList()) {
			if (cart.getMemberID().equals(mallCon.getMemberID())) {
				itemData += cart.getItem().getCategoryName() + "/" + cart.getItem().getName() + "/"
						+ cart.getItem().getPrice() + "\n";
			}
		}

		try {
			fwID = new FileWriter("src/DB/orderID.txt", true);
			fwItem = new FileWriter("src/DB/orderItems.txt", true);
			fwID.write(idData);
			fwID.flush();
			fwItem.write(itemData);
			fwItem.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fwItem.close();
				fwID.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		cartDAO.delAllCart(mallCon.getMemberID());
		return key;
	}

}

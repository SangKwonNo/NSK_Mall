package menu_order;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import _mall.MenuCommand;
import controller.MallController;
import order.OrderDAO;

public class Order_Load implements MenuCommand {
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
		FileReader frID = null;
		FileReader frItem = null;
		String itemData = "";
		String idData = "";

		try {
			frID = new FileReader("src/DB/orderID.txt");
			frItem = new FileReader("src/DB/orderItems.txt");
			while (true) {
				int readID = frID.read();
				if (readID == -1) {
					break;
				}
				idData += (char) readID;
			}
			while (true) {
				int readItem = frItem.read();
				if (readItem == -1) {
					break;
				}
				itemData += (char) readItem;
			}
		} catch (FileNotFoundException e1) {
			key = "Admin_Main";
			System.err.println("[ 현재 주문목록 없음 ]");
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			if (frID != null && frItem != null) {
				try {
					frID.close();
					frItem.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		orderDAO.insertData(idData, itemData);
		return key;
	}

}

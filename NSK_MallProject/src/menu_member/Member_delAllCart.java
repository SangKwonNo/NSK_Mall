package menu_member;

import _mall.MenuCommand;
import cart.CartDAO;
import controller.MallController;

public class Member_delAllCart implements MenuCommand {

	private MallController mallCon;
	private CartDAO cartDAO;
	
	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		cartDAO = CartDAO.getCartDAO();
	}

	@Override
	public String update() {
		String key = "Member_Cart";
		cartDAO.delAllCart(mallCon.getMemberID());
		System.out.println("[ ���� ���� �Ϸ� ]");
		return key;
	}

}

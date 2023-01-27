package menu_admin;

import _mall.MenuCommand;
import cart.Cart;
import cart.CartDAO;
import controller.MallController;
import myUtil.Util;

public class Admin_SearchCart implements MenuCommand {

	private MallController mallCon;
	private CartDAO cartDAO;
	private Util util;
	
	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		cartDAO = CartDAO.getCartDAO();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Admin_CartMenu";
		
		String memberID = util.getValue("[ 회원 아이디 입력 ]");
		if (memberID == null) {
			return key;
		}
		
		Cart findCart = cartDAO.findCart(memberID);
		if (findCart == null) {
			System.err.println("[ 입력한 회원 아이디 없음 ]");
		} else {
			System.out.println(findCart.toString());
		}
		return key;
	}

}

package menu_member;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class Member_Main implements MenuCommand{
	
	private MallController mallCon;
	
	@Override
	public void init() {
		mallCon = MallController.getMallCon();
	}

	@Override
	public String update() {
		String key = "Member_Main";
		System.out.println("[1.쇼핑][2.장바구니목록][3.회원정보][0.로그아웃]");
		int sel = _Main.sc.nextInt();
		if (sel == 1) {
			key = "Member_Shop";
		} else if (sel == 2) {
			key = "Member_Cart";
		} else if (sel == 3) {
			key = "Member_showInfo";
		} else if (sel == 0) {
			mallCon.setMemberID(null);
			key = "Mall_Main";
		}
		return key;
	}

}

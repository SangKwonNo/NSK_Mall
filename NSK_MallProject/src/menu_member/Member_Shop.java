package menu_member;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class Member_Shop implements MenuCommand {

	private MallController mallCon;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
	}

	@Override
	public String update() {
		String key = "Member_Shop";
		System.out.println("[1.장바구니 담기][0.뒤로가기]");
		int sel = _Main.sc.nextInt();
		if (sel == 1) {
			key = "Member_addCart";
		} else if (sel == 0) {
			key = "Member_Main";
		}
		return key;
	}

}

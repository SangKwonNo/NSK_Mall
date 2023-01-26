package menu_member;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class Member_Cart implements MenuCommand {

	private MallController mallCon;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
	}

	@Override
	public String update() {
		String key = "Member_Cart";
		System.out.println("[1.선택삭제][2.전부삭제][3.장바구니출력][4.구입][0.뒤로가기]");
		int sel = _Main.sc.nextInt();
		if (sel == 1) {
			key = "Member_delCart";
		} else if (sel == 2) {
			key = "Member_delAllCart";
		} else if (sel == 3) {
			key = "Member_showCart";
		} else if (sel == 4) {
			key = "Memeber_buyCart";
		} else if (sel == 0) {
			key = "Member_Main";
		}
		return key;
	}

}

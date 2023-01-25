package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class Admin_CartMenu implements MenuCommand {

	private MallController mallCon;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
	}

	@Override
	public String update() {
		String key = "Admin_CartMenu";
		System.out.println("[1.īƮ�˻�][2.��ü���][0.�ڷΰ���]");
		int sel = _Main.sc.nextInt();
		if (sel == 1) {
			key = "Admin_SearchCart";
		} else if (sel == 2) {
			key = "Admin_showCartList";
		} else if (sel == 0) {
			key = "Admin_Main";
		}
		
		return key;
	}

}

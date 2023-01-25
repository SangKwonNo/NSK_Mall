package menu_mall;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class Mall_Main implements MenuCommand {

	private MallController mallCon;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
	}

	@Override
	public String update() {
		String key = null;
		System.out.println("[1.ȸ������][2.�α���][0.����]");
		int sel = _Main.sc.nextInt();
		if (sel == 1) {
			key = "Mall_SignUp";
		} else if (sel == 2) {
			key = "Mall_Login";
		}
		return key;
	}

}

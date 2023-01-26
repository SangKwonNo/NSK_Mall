package menu_member;

import _mall.MenuCommand;
import controller.MallController;

public class Member_addCart implements MenuCommand {

	private MallController mallCon;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
	}

	@Override
	public String update() {
		
	}

}

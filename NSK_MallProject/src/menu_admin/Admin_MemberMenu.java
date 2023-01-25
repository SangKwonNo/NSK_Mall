package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class Admin_MemberMenu implements MenuCommand {

	private MallController mallCon;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
	}

	@Override
	public String update() {
		String key = "Admin_MemberMenu";
		System.out.println("[1.회원검색][2.전체출력][0.뒤로가기]");
		int sel = _Main.sc.nextInt();
		if (sel == 1) {
			key = "Admin_SearchMember";
		} else if (sel == 2) {
			key = "Admin_showMemberList";
		} else if (sel == 0) {
			key = "Admin_Main";
		}
		
		return key;
	}

}

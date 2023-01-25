package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;

public class Admin_Main implements MenuCommand{

	private MallController mallCon;
	
	@Override
	public void init() {
		mallCon = MallController.getMallCon();
	}

	@Override
	public String update() {
		String key = "Admin_Main";
		System.out.println("[1.ȸ������][2.īƮ����][3.�����۰���][0.�α׾ƿ�]");
		int sel = _Main.sc.nextInt();
		if (sel == 1) {
			key = "Admin_MemberMenu";
		} else if (sel == 2) {
			key = "Admin_CartMenu";
		} else if (sel == 3) {
			key = "Admin_ItemMenu";
		} else if (sel == 0) {
			key = "Admin_Mall_Main";
			mallCon.setMemberID(null);
			System.out.println("[ �α׾ƿ� ���� ]");
		}
		return key;
	}

}

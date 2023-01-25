package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import member.Member;
import member.MemberDAO;

public class Admin_showMemberList implements MenuCommand {

	private MallController mallCon;
	private MemberDAO memberDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		memberDAO = MemberDAO.getMemberDAO();
	}

	@Override
	public String update() {
		String key = "Admin_MemberMenu";
		for (Member member : memberDAO.getMemberList()) {
			System.out.println(member.toString());
		}
		return key;
	}

}

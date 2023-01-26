package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import member.Member;
import member.MemberDAO;

public class Member_showInfo implements MenuCommand {

	private MallController mallCon;
	private MemberDAO memberDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		memberDAO = MemberDAO.getMemberDAO();
	}

	@Override
	public String update() {
		String key = "Member_Main";
		Member member = memberDAO.findMember(mallCon.getMemberID());
		System.out.println(member.toString());
		return key;
	}

}

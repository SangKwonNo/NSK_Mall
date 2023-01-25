package menu_admin;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import member.Member;
import member.MemberDAO;

public class Admin_SearchMember implements MenuCommand {

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
		System.out.println("[ 검색할 아이디 입력 ]");
		String searchID = _Main.sc.next();
		Member findMember = memberDAO.findMember(searchID);
		if (findMember == null) {
			System.err.println("[ 입력한 아이디 없음 ]");
		} else {
			System.out.println(findMember.toString());
		}
		return key;
	}

}

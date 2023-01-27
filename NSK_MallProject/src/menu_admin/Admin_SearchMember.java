package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import member.Member;
import member.MemberDAO;
import myUtil.Util;

public class Admin_SearchMember implements MenuCommand {

	private MallController mallCon;
	private MemberDAO memberDAO;
	private Util util;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		memberDAO = MemberDAO.getMemberDAO();
		util = Util.getUtil();
	}

	@Override
	public String update() {
		String key = "Admin_MemberMenu";

		String searchID = util.getValue("[ 검색할 아이디 입력 ]");
		if (searchID == null) {
			return key;
		}
		
		Member findMember = memberDAO.findMember(searchID);
		if (findMember == null) {
			System.err.println("[ 입력한 아이디 없음 ]");
		} else {
			System.out.println(findMember.toString());
		}
		return key;
	}

}

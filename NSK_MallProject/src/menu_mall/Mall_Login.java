package menu_mall;

import _mall.MenuCommand;
import controller.MallController;
import member.MemberDAO;
import myUtil.Util;

public class Mall_Login implements MenuCommand {

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
		String key = null;
		
		String id = util.getValue("[ 아이디 입력 ]");
		String pw = util.getValue("[ 비밀번호 입력 ]");
		if (id == null || pw == null) {
			return key;
		}
		
		if (memberDAO.logInCheck(id, pw) == -1) {
			System.err.println("[ ID or PW ERROR ]");
			key = "Mall_Main";
		} else {

			if (id.equals("admin")) {
				key = "Admin_Main";
			} else {
				mallCon.setMemberID(id);
				key = "Member_Main";
			}
			System.out.printf("[ %s님 로그인 성공 ] \n", id);
		}

		return key;
	}

}

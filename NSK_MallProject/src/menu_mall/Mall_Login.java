package menu_mall;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import member.MemberDAO;

public class Mall_Login implements MenuCommand {

	private MallController mallCon;
	private MemberDAO memberDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		memberDAO = MemberDAO.getMemberDAO();
	}

	@Override
	public String update() {
		String key = null;
		System.out.println("[ 아이디 입력 ]");
		String id = _Main.sc.next();
		System.out.println("[ 비밀번호 입력 ]");
		String pw = _Main.sc.next();
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

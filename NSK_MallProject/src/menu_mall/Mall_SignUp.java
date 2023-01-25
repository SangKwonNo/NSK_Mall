package menu_mall;

import _mall.MenuCommand;
import _mall._Main;
import controller.MallController;
import member.Member;
import member.MemberDAO;

public class Mall_SignUp implements MenuCommand {

	private MallController mallCon;
	private MemberDAO memberDAO;

	@Override
	public void init() {
		mallCon = MallController.getMallCon();
		memberDAO = MemberDAO.getMemberDAO();
	}

	@Override
	public String update() {
		String key = "Mall_Main";
		System.out.println("[ 아이디 입력 ]");
		String id = _Main.sc.next();
		System.out.println("[ 비밀번호 입력 ]");
		String pw = _Main.sc.next();
		System.out.println("[ 이름 입력 ]");
		String name = _Main.sc.next();
		if (memberDAO.signUpCheck(id) != -1) {
			System.err.println("[ 이미 존재하는 아이디 ]");
		} else {
			memberDAO.addMember(new Member(id, pw, name));
			System.out.println("[ 회원 가입 성공 ]");
		}
		return key;
	}

}

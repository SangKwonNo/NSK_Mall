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
		System.out.println("[ ���̵� �Է� ]");
		String id = _Main.sc.next();
		System.out.println("[ ��й�ȣ �Է� ]");
		String pw = _Main.sc.next();
		System.out.println("[ �̸� �Է� ]");
		String name = _Main.sc.next();
		if (memberDAO.signUpCheck(id) != -1) {
			System.err.println("[ �̹� �����ϴ� ���̵� ]");
		} else {
			memberDAO.addMember(new Member(id, pw, name));
			System.out.println("[ ȸ�� ���� ���� ]");
		}
		return key;
	}

}

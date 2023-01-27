package menu_mall;

import _mall.MenuCommand;
import controller.MallController;
import member.Member;
import member.MemberDAO;
import myUtil.Util;

public class Mall_SignUp implements MenuCommand {

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
		String key = "Mall_Main";
		
		String id = util.getValue("[ ���̵� �Է� ]");
		String pw = util.getValue("[ ��й�ȣ �Է� ]");
		String name = util.getName("[ �̸� �Է� ]");
		
		if (id == null || pw == null || name == null) {
			return key;
		}
		
		if (memberDAO.signUpCheck(id) != -1) {
			System.err.println("[ �̹� �����ϴ� ���̵� ]");
		} else {
			memberDAO.addMember(new Member(id, pw, name));
			System.out.println("[ ȸ�� ���� ���� ]");
		}
		return key;
	}

}

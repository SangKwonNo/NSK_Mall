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
		
		String id = util.getValue("[ 아이디 입력 ]");
		String pw = util.getValue("[ 비밀번호 입력 ]");
		String name = util.getName("[ 이름 입력 ]");
		
		if (id == null || pw == null || name == null) {
			return key;
		}
		
		if (memberDAO.signUpCheck(id) != -1) {
			System.err.println("[ 이미 존재하는 아이디 ]");
		} else {
			memberDAO.addMember(new Member(id, pw, name));
			System.out.println("[ 회원 가입 성공 ]");
		}
		return key;
	}

}

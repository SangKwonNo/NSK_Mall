package member;

import java.util.ArrayList;

public class MemberDAO {
	private static MemberDAO memberDAO = new MemberDAO();
	private ArrayList<Member> memberList;

	public static MemberDAO getMemberDAO() {
		return memberDAO;
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}

	private MemberDAO() {
		memberList = new ArrayList<>();
		memberList.add(new Member("admin", "admin", "admin"));
	}

	public void addMember(Member member) {
		memberList.add(member);
	}

	public int logInCheck(String id, String pw) {
		int idx = -1;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(id)) {
				idx = i;
			}
		}
		if (idx == -1) {
			return idx;
		}
		if (memberList.get(idx).getPw().equals(pw)) {
			return idx;
		}
		return idx;
	}

	public int signUpCheck(String id) {
		int idx = 0;
		for (Member member : memberList) {
			if (member.getId().equals(id)) {
				return idx;
			}
			idx++;
		}
		return -1;
	}

	public Member findMember(String id) {

		for (Member member : memberList) {
			if (member.getId().equals(id)) {
				return member;
			}
		}
		return null;
	}
}

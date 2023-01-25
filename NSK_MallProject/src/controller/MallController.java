package controller;

import java.util.HashMap;
import java.util.Map;

import _mall.MenuCommand;
import menu_admin.Admin_CartMenu;
import menu_admin.Admin_ItemMenu;
import menu_admin.Admin_Main;
import menu_admin.Admin_MemberMenu;
import menu_admin.Admin_SearchCart;
import menu_admin.Admin_SearchMember;
import menu_admin.Admin_addItem;
import menu_admin.Admin_delItem;
import menu_admin.Admin_showCartList;
import menu_admin.Admin_showItemList;
import menu_admin.Admin_showMemberList;
import menu_mall.Mall_Login;
import menu_mall.Mall_Main;
import menu_mall.Mall_SignUp;
import menu_member.Member_Main;
import menu_member.Member_addCart;
import menu_member.Member_buyCart;
import menu_member.Member_delCart;
import menu_member.Member_showCart;
import menu_member.Member_showInfo;

public class MallController {
	private static MallController mallCon = new MallController();
	private Map<String, MenuCommand> menuList;
	private MenuCommand menuCommand;
	private String MemberID;

	public static MallController getMallCon() {
		return mallCon;
	}

	public void setMemberID(String MemberID) {
		this.MemberID = MemberID;
	}

	private MallController() {
		menuList = new HashMap<>();
		menuList.put("Admin_addItem", new Admin_addItem());
		menuList.put("Admin_delItem", new Admin_delItem());
		menuList.put("Admin_CartMenu", new Admin_CartMenu());
		menuList.put("Admin_ItemMenu", new Admin_ItemMenu());
		menuList.put("Admin_MemberMenu", new Admin_MemberMenu());
		menuList.put("Admin_Main", new Admin_Main());
		menuList.put("Admin_SearchCart", new Admin_SearchCart());
		menuList.put("Admin_SearchMember", new Admin_SearchMember());
		menuList.put("Admin_showCartList", new Admin_showCartList());
		menuList.put("Admin_showMemberList", new Admin_showMemberList());
		menuList.put("Admin_showItemList", new Admin_showItemList());
		
		menuList.put("Mall_Login", new Mall_Login());
		menuList.put("Mall_Main", new Mall_Main());
		menuList.put("Mall_SignUp", new Mall_SignUp());

		menuList.put("Member_addCart", new Member_addCart());
		menuList.put("Member_buyCart", new Member_buyCart());
		menuList.put("Member_delCart", new Member_delCart());
		menuList.put("Member_Main", new Member_Main());
		menuList.put("Member_showCart", new Member_showCart());
		menuList.put("Member_showInfo", new Member_showInfo());
	}

	public void menuControl(String key) {
		while (true) {
			if (key == null) {
				System.out.println("[ Á¾·á ]");
				break;
			}
			menuCommand = menuList.get(key);
			menuCommand.init();
			key = menuCommand.update();

		}
	}

}

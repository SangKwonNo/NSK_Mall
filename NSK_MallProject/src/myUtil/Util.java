package myUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	private static Util util = new Util();
	private Scanner sc = new Scanner(System.in);

	public static Util getUtil() {
		return util;
	}

	public int getInt(String msg, int min, int max) {
		System.out.println(msg);
		int val = -1;
		try {
			val = sc.nextInt();
			if (val < min || val > max) {
				throw new Exception();
			}
		} catch (InputMismatchException e1) {
			val = -1;
			System.err.println("[ ���ڸ� �Է� ]");
		} catch (Exception e2) {
			val = -1;
			System.err.printf("[ %d ~ %d ���� �Է� ] \n", min, max);
		}
		sc.nextLine();
		return val;
	}

	public String getName(String msg) {
		System.out.println(msg);
		String val = null;
		try {
			val = sc.next();
			for (int i = 0; i < val.length(); i++) {
				if (val.charAt(i) >= '0' && val.charAt(i) <= '9') {
					throw new Exception();
				}
			}
		} catch (Exception e) {
			System.err.println("[ ���� �Է� X ]");
			val = null;
		}
		sc.nextLine();
		return val;
	}
	
	public String getValue(String msg) {
		System.out.println(msg);
		String val = null;
		try {
			val = sc.next();
			boolean numberCheck = true;
			for (int i = 0; i < val.length(); i++) {
				if (val.charAt(i) < '0' || val.charAt(i) > '9') {
					numberCheck = false;
				}
			}
			if (numberCheck) {
				throw new Exception();
			}
		} catch (Exception e) {
			val = null;
			System.err.println("[ ���ڸ� �Է� X ]");
		}
		return val;
	}
}

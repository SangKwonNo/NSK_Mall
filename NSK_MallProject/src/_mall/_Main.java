package _mall;

import java.util.Scanner;

import controller.MallController;


public class _Main {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		MallController.getMallCon().menuControl("Mall_Main");
		
	}
}

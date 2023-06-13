package com.yedam;

import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;


public class BoardMain {
	public static void main(String[] args) {

		
		
		Scanner scn = new Scanner(System.in);
		int choice;

		BoardApp app = new BoardApp();

		while (true) {
			try {
				System.out.println("-----1. 추가  2. 수정  3. 조회  4. 삭제 5. 목록 6. 저장 및 종료-----");
				System.out.println("선택 > ");
				choice = Integer.parseInt(scn.nextLine());

				switch (choice) {
				case MENU.REGISTER:
					app.register();
					break;
				case MENU.MODIFY:
					app.modify();
					break;
				case MENU.SEARCH:
					app.search();
					break;
				case MENU.REMOVE:
					app.remove();
					break;
				case MENU.LIST:
					app.list();
					break;
				case MENU.CLOSE:
					app.close();
					System.out.println("종료");
					return;
				}
			} catch (Exception e) {
				break;
			}
		}
		System.out.println("프로그램 종료");
		scn.close();
		
	}
}
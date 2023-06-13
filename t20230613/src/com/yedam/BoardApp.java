package com.yedam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BoardApp {

	List<Board> storage = new ArrayList<>();
	Scanner scn = new Scanner(System.in);
	BoardApp(){
		readFromFile();
	}
	// 파일 읽어오기
	public void readFromFile() {
		try {
			FileInputStream fis = new FileInputStream("c:/temp/boardList.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			storage = (List<Board>) ois.readObject();
			ois.close();
			fis.close();

		} catch (FileNotFoundException | ClassNotFoundException e) {
//			e.printStackTrace();
			System.out.println("계속 진행하세요");
		} catch (IOException e) {
//			e.printStackTrace();
		}
	}


	// 추가
	public void register() {
		System.out.println("게시글 번호 > ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.println("게시글 제목 > ");
		String title = scn.nextLine();
		System.out.println("작성자 > ");
		String name = scn.nextLine();
		System.out.println("게시글 내용 > ");
		String content = scn.nextLine();

		storage.add(new Board(no, title, name, content));

	}

	// 수정
	public void modify() {
		System.out.println("내용을 수정할 게시글 번호를 입력해주세요.");
		int no = Integer.parseInt(scn.nextLine());
		boolean isYn = false;
		for (int i = 0; i < storage.size(); i++) {
			if (no == storage.get(i).getNo()) {
				System.out.println("수정할 내용을 입력하세요.");
				storage.get(i).setContent(scn.nextLine());
				isYn = true;
			}
		}
		System.out.println("수정이 완료되었습니다.");

		if (!isYn) {
			System.out.println("해당 날짜의 게시글이 없습니다.");
		}
	}

	// 조회
	public void search() {
		System.out.printf("조회할 게시글 번호를 입력하세요 > ");
		int no = Integer.parseInt(scn.nextLine());
		boolean isYn = false;
		for (int i = 0; i < storage.size(); i++) {
			if (no == (storage.get(i).getNo())) {
				System.out.println("게시글번호 : " + storage.get(i).getNo() + ", 게시글제목 : "+ storage.get(i).getTitle() + ", 게시글내용 : " +storage.get(i).getContent()
						+ ", 작성자 이름 : " + storage.get(i).getName());
				isYn = true;
			}
		}
		if (!isYn) {
			System.out.println("해당 날짜의 게시글이 없습니다.");
		}
	}

	// 삭제
	public void remove() {
		System.out.printf("삭제할 게시글번호를 입력하세요 > ");
		int no = Integer.parseInt(scn.nextLine());
		boolean isYn = false;
		for (int i = 0; i < storage.size(); i++) {
			if (no == storage.get(i).getNo()) {
				storage.remove(i);
				isYn = true;
			}
			System.out.println("해당 날짜의 게시글이 삭제되었습니다.");
		}
		if (!isYn) {
			System.out.println("해당 날짜의 게시글이 없습니다.");
		}
	}

	// 목록
	public void list() {

		for (Board board : storage) {
			System.out.printf("게시글번호 %d, 게시글제목 %s, 작성자 %s \n", board.getNo(), board.getTitle(), board.getName());
		}

	}
	
	// 파일 저장
	public void close() throws Exception {
		try {
			FileOutputStream fos = new FileOutputStream("c:/temp/boardList.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(storage);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

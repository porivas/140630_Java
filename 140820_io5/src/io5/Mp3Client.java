package io5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Mp3Client {

	private String ip;
	private int port;
	private Scanner keysc;
	protected DataInputStream dis;
	protected DataOutputStream dos;
	// protected InputStream in;
	// protected OutputStream out;
	private FileOutputStream fos;
	private FileInputStream fis;
	private String path;

	// 생성자
	public Mp3Client(String ip) {
		super();
		this.ip = ip;
		this.port = 5555;
		this.path = "C:\\zzz2\\Mp3\\";
	}

	// 사용자가 옵션선택
	public void selectOption() throws Exception {
		System.out.println("1. 리스트가져오기(하위폴더까지 검색) \n2. 파일검색  \n3. 특정파일다운로드 \n4. 특정파일업로드 \n5. 종료\n원하는 번호 입력:");
		keysc = new Scanner(System.in);
		int userNum = keysc.nextInt();

		switch (userNum) {

		case 1:
			getList();
			break;

		case 2:
			search();
			break;

		case 3:
			download();

			break;

		case 4:
			upLoad();
			break;

		case 5:
			Exit();
			break;
		}
		selectOption();
	}

	// 목록 얻어오기
	public void getList() throws Exception {
		System.out.println("하위 디렉토리의 파일까지 표시합니다.");
		new ClientAgent(this.ip, this.port) {

			@Override
			public void sendMsg() throws Exception {
				dos.writeUTF("1");
			}

			@Override
			public void recieveMsg() throws Exception {
				System.out.println(dis.readUTF());
			}

		}.doExecute();
	}

	// 검색
	public void search() throws Exception {
		Scanner keysc4 = new Scanner(System.in);

		System.out.println("검색할 이름을 입력하세요!");
		String searchName = keysc4.nextLine();

		new ClientAgent(this.ip, this.port) {
			@Override
			public void sendMsg() throws Exception {
				dos.writeUTF("2");
				dos.writeUTF(searchName);
			}

			@Override
			public void recieveMsg() throws Exception {
				System.out.println(dis.readUTF());
			}
		}.doExecute();

	}

	// 다운로드
	public void download() throws Exception {
		Scanner keysc2 = new Scanner(System.in);

		System.out.println("다운로드할 파일명을 입력하세요");
		final String fileName1 = keysc2.nextLine();

		new ClientAgent(this.ip, this.port) {
			@Override
			public void sendMsg() throws Exception {
				dos.writeUTF("3");
				dos.writeUTF(fileName1);
			}

			@Override
			public void recieveMsg() throws Exception {
				String mp3File = dis.readUTF();

				fos = new FileOutputStream(path + mp3File);
				CopyUtil.copy(dis, fos, false, true);
				System.out.println("다운로드완료!");
			}
		}.doExecute();
	}

	// 업로드
	public void upLoad() throws Exception {
		Scanner keysc3 = new Scanner(System.in);

		System.out.println("업로드할 파일명을 입력하세요");
		final String fileName = keysc3.nextLine();

		new ClientAgent(this.ip, this.port) {

			@Override
			public void sendMsg() throws Exception {
				dos.writeUTF("4");
				dos.writeUTF(fileName);

				fis = new FileInputStream(path + fileName);
				CopyUtil.copy(fis, dos, true, false);
				System.out.println("전송 완료");
			}

			@Override
			public void recieveMsg() throws Exception {
			}

		}.doExecute();

	}

	public void Exit() throws Exception {

		System.out.println("종료하시려면 암호를 입력하세요");
		String userPdw = keysc.next();

		new ClientAgent(this.ip, this.port) {

			@Override
			public void sendMsg() throws Exception {
				dos.writeUTF("5");
				dos.writeUTF(userPdw);
			}

			@Override
			public void recieveMsg() throws Exception {
				String result = dis.readUTF();
				System.out.println(result);
				if (result.equals("서버 종료")) {
					System.out.println("클라이언트도 종료합니다");
					System.exit(0);
				}

			}

		}.doExecute();

	}

	public static void main(String[] args) throws Exception {
		Mp3Client aa = new Mp3Client("192.168.0.73");
		aa.selectOption();

	}

}

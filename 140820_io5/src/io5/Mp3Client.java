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

	// ������
	public Mp3Client(String ip) {
		super();
		this.ip = ip;
		this.port = 5555;
		this.path = "C:\\zzz2\\Mp3\\";
	}

	// ����ڰ� �ɼǼ���
	public void selectOption() throws Exception {
		System.out.println("1. ����Ʈ��������(������������ �˻�) \n2. ���ϰ˻�  \n3. Ư�����ϴٿ�ε� \n4. Ư�����Ͼ��ε� \n5. ����\n���ϴ� ��ȣ �Է�:");
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

	// ��� ������
	public void getList() throws Exception {
		System.out.println("���� ���丮�� ���ϱ��� ǥ���մϴ�.");
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

	// �˻�
	public void search() throws Exception {
		Scanner keysc4 = new Scanner(System.in);

		System.out.println("�˻��� �̸��� �Է��ϼ���!");
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

	// �ٿ�ε�
	public void download() throws Exception {
		Scanner keysc2 = new Scanner(System.in);

		System.out.println("�ٿ�ε��� ���ϸ��� �Է��ϼ���");
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
				System.out.println("�ٿ�ε�Ϸ�!");
			}
		}.doExecute();
	}

	// ���ε�
	public void upLoad() throws Exception {
		Scanner keysc3 = new Scanner(System.in);

		System.out.println("���ε��� ���ϸ��� �Է��ϼ���");
		final String fileName = keysc3.nextLine();

		new ClientAgent(this.ip, this.port) {

			@Override
			public void sendMsg() throws Exception {
				dos.writeUTF("4");
				dos.writeUTF(fileName);

				fis = new FileInputStream(path + fileName);
				CopyUtil.copy(fis, dos, true, false);
				System.out.println("���� �Ϸ�");
			}

			@Override
			public void recieveMsg() throws Exception {
			}

		}.doExecute();

	}

	public void Exit() throws Exception {

		System.out.println("�����Ͻ÷��� ��ȣ�� �Է��ϼ���");
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
				if (result.equals("���� ����")) {
					System.out.println("Ŭ���̾�Ʈ�� �����մϴ�");
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

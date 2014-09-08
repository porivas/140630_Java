package io5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class MP3server extends Mp3serverAbs {

	private String adminPass;
	private String filePath;
	private String filePath2;

	public MP3server() throws Exception {
		super();
		this.adminPass = "502e";
	}

	// �ɼ��Ǵ�
	public void execute() throws Exception {
		this.connectUser();

		String options = dis.readUTF();
		switch (options) {
		case "1":
			sendFileList();
			break;
		case "2":
			searchSpecificName();
			break;
		case "3":
			sendRealFile();
			break;
		case "4":
			receiveFile();
			break;
		case "5":
			System.out.println("��ȣüũ�����մϴ�.");
			checkPasswords();
			break;
		}

		this.closeAll();
		execute();
	}

	// 1�� ���� �� ���ϸ���Ʈ �����ֱ�
	public void sendFileList() throws Exception {
//		System.out.println("1�� ���� �� ���ϸ���Ʈ �����ֱ�");
		filePath = "C:\\zzz\\";
		sendListHelper(filePath);
		String fileList = mp3Buffer.toString();
		// fileList = null;
		dos.writeUTF(fileList);
	}

	StringBuffer mp3Buffer = new StringBuffer();

	public void sendListHelper(String filePath) throws Exception {

		File mp3Dir = new File(filePath);
		File[] mp3List = mp3Dir.listFiles();
		for (File file : mp3List) {
			if (file.isFile()) {
				mp3Buffer.append(file.getName() + "|");
			} else if (file.isDirectory()) {
//				System.out.println(filePath + file.getName());
				sendListHelper(filePath + file.getName());
			}
		}

	}

	// 2�� Ư���� �̸����� �˻��ϱ�
	public void searchSpecificName() throws Exception {
		System.out.println("2�� Ư���� �̸����� �˻��ϱ�");
		String specificName = dis.readUTF();
		filePath = "C:\\zzz\\";
		sendListHelper(filePath, specificName);
		String fileList;
		fileList = mp3Buffer.toString();
		dos.writeUTF(fileList);
		mp3Buffer.delete(0, mp3Buffer.length());
	}

	private void sendListHelper(String filePath, String specificName) {
		// TODO Auto-generated method stub
		File mp3Dir = new File(filePath);

		File[] mp3List = mp3Dir.listFiles();
		for (File file : mp3List) { // "(?i).*ooo.*"
			if (file.isFile()
					&& file.getName().matches(".*" + specificName + ".*")) {
				mp3Buffer.append(file.getName() + "|");
			} else if (file.isDirectory()) {
				System.out.println(filePath + file.getName());
				sendListHelper((filePath + file.getName()), specificName);
			}
		}
	}

	// 3�� Ŭ���̾�Ʈ�� Ư������ �����ֱ�
	public void sendRealFile() throws Exception {
		String specificName = dis.readUTF();
		dos.writeUTF(specificName);
		filePath = "C:\\zzz\\";
		sendFileHelper(filePath, specificName);
		System.out.println(filePath2);
		fis = new FileInputStream(filePath2);
		CopyUtil.copy(fis, dos, false, false);
		System.out.println("Ư������ ���ۿϷ�");
	}

	public void sendFileHelper(String filePath, String specificName) {
		System.out.println(specificName + "ã���ϴ�.");
		File mp3Dir = new File(filePath);

		File[] mp3List = mp3Dir.listFiles();
		for (File file : mp3List) { // "(?i).*ooo.*"
			System.out.println(file.getName());
			if (file.getName().equals(specificName)) {
				System.out.println("ã�Ҵ�!....");
				System.out.println(file.getAbsolutePath());
				this.filePath2 = file.getAbsolutePath();
				break;
			} else if (file.isDirectory()) {
				System.out.println(filePath + file.getName());
				sendFileHelper((filePath + file.getName()), specificName);
			}
		}

	}

	// 4�� Ŭ���̾�Ʈ���� ���� �ޱ�
	public void receiveFile() throws Exception {
		String fileName = dis.readUTF();
		System.out.println(fileName + "������");
		filePath = "C:\\zzz\\";
		fos = new FileOutputStream(filePath + fileName);
		CopyUtil.copy(dis, fos, false, false);
		System.out.println("���ϼ��ſϷ�");

	}

	// 5�� Ŭ���̾�Ʈ���� ��ȣ�޾Ƽ� ��������
	public void checkPasswords() throws Exception {

		String passwords = dis.readUTF();
		System.out.println("������ȣ: " + passwords);
		if (adminPass.equals(passwords)) {
			String msg = "���� ����";
			dos.writeUTF(msg);
			System.exit(0);
		} else {
			String msg2 = "��ȣ�� ����� �Է����ּ���.";
			dos.writeUTF(msg2);
			dos.close();
		}
	}

	public static void main(String[] args) throws Exception {

		MP3server server = new MP3server();
		server.execute();
	}

}

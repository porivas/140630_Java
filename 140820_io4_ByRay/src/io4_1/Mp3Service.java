package io4_1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Mp3Service {
	
	private String rootDirName;
		
	public Mp3Service(String rootDirName) {
		super();
		this.rootDirName = rootDirName;
	}

	public String getList()throws Exception{
		// File�̶�� Ÿ���� OS������ ������� ��θ� ����� �� �ֱ� ������, String ���� ����. 
		File mp3Dir = new File(this.rootDirName);
		
		String[] songList = mp3Dir.list();
		// StringBuilder�� ����ؼ� String �� ������ �ִ� �޸� ���� �ּ�ȭ.  
		// StringBuffer ��  ������ ������ ��. ����ȭ�� ������.
		StringBuilder builder = new StringBuilder();
		
		for (String title : songList) {
			builder.append(title+"|");
		}
		
		String result = builder.toString();
		
		return result;
	}
	// Ư�� ���� �̸��� ���� ��Ʈ ��α��� ����
	public File getFile(String fileName)throws Exception{
		
		return new File(this.rootDirName+"\\" + fileName);
	}
	
	// �� ���丮�� ������ ����. ���ε��� ���� �̸��� DataInputStream�� �޵���
	public void saveFile(String uploadFileName, DataInputStream din)throws Exception {
		
		FileOutputStream fos = new FileOutputStream(this.rootDirName+"\\"+uploadFileName);
		
		CopyUtil.copy(din, fos, false, true);
		
	}
}

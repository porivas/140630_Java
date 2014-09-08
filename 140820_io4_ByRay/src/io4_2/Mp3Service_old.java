package io4_2;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Mp3Service_old {
	
	private String rootDirName;
		
	public Mp3Service_old(String rootDirName) {
		super();
		this.rootDirName = rootDirName;
	}

	public String getList()throws Exception{
		
		File mp3Dir = new File(this.rootDirName);
		
		String[] songList = mp3Dir.list();
		
		StringBuilder builder = new StringBuilder();
		
		for (String title : songList) {
			builder.append(title+"|");
		}
		
		String result = builder.toString();
		
		return result;
	}
		
	public File getFile(String fileName)throws Exception{
		
		return new File(this.rootDirName+"\\" + fileName);
	}

	public void saveFile(String uploadFileName, DataInputStream din)throws Exception {
		
		FileOutputStream fos = new FileOutputStream(this.rootDirName+"\\"+uploadFileName);
		
		CopyUtil_old.copy(din, fos, false, true);
		
	}
}









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
		// File이라는 타입은 OS종류에 상관없이 경로를 사용할 수 있기 때문에, String 보다 상위. 
		File mp3Dir = new File(this.rootDirName);
		
		String[] songList = mp3Dir.list();
		// StringBuilder를 사용해서 String 이 가지고 있는 메모리 낭비를 최소화.  
		// StringBuffer 도  있으니 참조할 것. 동기화가 먹힌다.
		StringBuilder builder = new StringBuilder();
		
		for (String title : songList) {
			builder.append(title+"|");
		}
		
		String result = builder.toString();
		
		return result;
	}
	// 특정 파일 이름과 상위 루트 경로까지 전송
	public File getFile(String fileName)throws Exception{
		
		return new File(this.rootDirName+"\\" + fileName);
	}
	
	// 내 디렉토리에 파일을 저장. 업로드할 파일 이름과 DataInputStream을 받도록
	public void saveFile(String uploadFileName, DataInputStream din)throws Exception {
		
		FileOutputStream fos = new FileOutputStream(this.rootDirName+"\\"+uploadFileName);
		
		CopyUtil.copy(din, fos, false, true);
		
	}
}

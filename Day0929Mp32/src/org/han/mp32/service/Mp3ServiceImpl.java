package org.han.mp32.service;

import java.util.ArrayList;
import java.util.List;

import org.han.mp32.vo.MP3;

class Mp3ServiceImpl implements Mp3Service {
	
	private static final String ROOT = "C:\\zzz";
	private List<MP3> mp3List;
	
	public Mp3ServiceImpl(){
		mp3List = new ArrayList<MP3>();
	}

	@Override
	public List<MP3> getFolderList(String dirName) {
		// TODO Auto-generated method stub
		return mp3List;
	}

	@Override
	public void addMp3(MP3 mp3) {
		
		mp3List.add(mp3);
	}

	@Override
	public void removeMp3(String fileName) {
		// TODO Auto-generated method stub

	}

}

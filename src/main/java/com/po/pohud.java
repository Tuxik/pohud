package com.po;

import com.po.file.FileReaderWMX;
import com.po.file.FileUtils;

public class pohud {

	public static void main(String[] args) {
		String workingDir = System.getProperty("user.dir");
		String s = FileUtils.getContentOfFile(workingDir + "/test-res/WHistory.txt");
		System.out.println(FileReaderWMX.getNumberOfHands(s));
		for (String sHid : FileReaderWMX.getHandsId(s)) {
			System.out.println(sHid);
		}
	}
}

package com.po.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileUtils {

	/**
	 * Read content of file
	 * 
	 * @param file
	 * @return
	 */
	public static String getContentOfFile(String file) {

		StringBuffer sb = null;
		try {
			RandomAccessFile aFile = new RandomAccessFile(file, "r");
			FileChannel inChannel = aFile.getChannel();
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
			buffer.load();
			sb = new StringBuffer();
			for (int i = 0; i < buffer.limit(); i++) {
				sb.append((char) buffer.get());
			}
			buffer.clear(); // do something with the data and clear/compact it.
			inChannel.close();
			aFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sb != null) {
			return sb.toString();
		} else {
			return null;
		}
	}
}

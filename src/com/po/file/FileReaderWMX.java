package com.po.file;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileReaderWMX {
	private static final Pattern WIN_PATTERN = Pattern.compile("^Winamax Poker.*");
	private static final Pattern WIN_HANDID_PATTERN = Pattern.compile("(?m).*HandId: (#[0-9]{16}-[0-9]-[0-9]{10}).*");

	public static int getNumberOfHands(String content) {
		Matcher m = WIN_HANDID_PATTERN.matcher(content);
		int i = 0;
		while (m.find()) {
			i++;
		}
		return i;
	}

	public static ArrayList<String> getHandsId(String content) {
		Matcher m = WIN_HANDID_PATTERN.matcher(content);

		ArrayList<String> aS = new ArrayList<String>();
		while (m.find()) {
			aS.add(m.group());
		}
		return aS;
	}

}

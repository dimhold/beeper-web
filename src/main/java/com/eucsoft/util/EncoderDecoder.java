package com.eucsoft.util;

public class EncoderDecoder {
	public static Integer decode(String code) {
		if (code != null) {
			int length = code.length();
			if (length % 2 == 0) {
				int number = 0;
				for (int i = 0; i < length / 2; i++) {
					int digit = 'Z' - code.charAt(i);
					if (digit < 0 || digit > 9 || digit != (code.charAt(length - 1 - i) - 'A')
							|| (number > (Integer.MAX_VALUE - digit)/10))
						return null;
					number = number * 10 + digit;
				}
				return number;
			}
		}
		return null;
	}
	
	public static String encode(int number) {
		if (number <= 0) return "";
		StringBuilder tail = new StringBuilder();
		for (; number > 0; number /= 10)
			tail.append((char)('A' + number%10));
		StringBuilder head = new StringBuilder();
		for (int i = tail.length() - 1; i >= 0; i--)
			head.append((char)('Z' - (tail.charAt(i)-'A')));
		head.append(tail);
		return head.toString();
	}
}

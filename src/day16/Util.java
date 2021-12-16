package day16;

import java.util.HashMap;
import java.util.Map;

class Util {

	private static final Map<Character, String> hexmap = new HashMap<>();
	static {
		hexmap.put('0', "0000");
		hexmap.put('1', "0001");
		hexmap.put('2', "0010");
		hexmap.put('3', "0011");
		hexmap.put('4', "0100");
		hexmap.put('5', "0101");
		hexmap.put('6', "0110");
		hexmap.put('7', "0111");
		hexmap.put('8', "1000");
		hexmap.put('9', "1001");
		hexmap.put('A', "1010");
		hexmap.put('B', "1011");
		hexmap.put('C', "1100");
		hexmap.put('D', "1101");
		hexmap.put('E', "1110");
		hexmap.put('F', "1111");
	}

	static String parseHexToBinary(String line) {
		var stringBuilder = new StringBuilder();
		for (char c : line.toCharArray()) {
			stringBuilder.append(hexmap.get(c));
		}

		return stringBuilder.toString();
	}

}

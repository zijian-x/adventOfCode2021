package day16;

import java.util.ArrayList;
import java.util.List;

class PartTwo {

	private final String binary;
	private final int binaryLength;
	private int pointer;

	PartTwo(String binary) {
		this.binary = binary;
		this.binaryLength = binary.length();
		this.pointer = 0;
	}

	void run() {
		while (true) {
			try {
				long val = parsePacket();
				System.out.println(val);
			} catch (EOLException e) {
				break;
			}
		}
	}

	private long parsePacket() throws EOLException {
		binaryToHex(3);
		long typeID = binaryToHex(3);
		if (typeID == 4)
			return parseLiteral();

		List<Long> res = new ArrayList<>();

		long lengthTypeID = binaryToHex(1);
		if (lengthTypeID == 0) {
			long totalLength = binaryToHex(15);
			int begin = this.pointer;
			int inc = 0;
			while (inc < totalLength) {
				res.add(parsePacket());
				inc = this.pointer - begin;
			}
		} else {
			long count = binaryToHex(11);
			while (count-- > 0)
				res.add(parsePacket());
		}

		return parseResults(res, typeID);
	}

	private long parseResults(List<Long> res, long typeID) {
		switch ((int)typeID) {
			case 0: // sum
				return res.stream().mapToLong(Long::longValue).sum();
			case 1: // product
				return res.stream().mapToLong(Long::longValue).reduce(1L, (a, b) -> (a * b));
			case 2: // min
				return res.stream().mapToLong(Long::longValue).min().getAsLong();
			case 3: // max
				return res.stream().mapToLong(Long::longValue).max().getAsLong();
			case 5: // greater than:	return 1 if 1. sub > 2. sub
				return res.get(0) > res.get(1) ? 1L : 0L;
			case 6: // less than:		return 1 if 1. sub < 2. sub
				return res.get(0) < res.get(1) ? 1L : 0L;
			case 7: // equal to:		return 1 if 1. sub = 2. sub
				return res.get(0) == res.get(1) ? 1L : 0L;
			default:
				throw new IllegalStateException("wrong type ID.");
		}
	}

	private long parseLiteral() throws EOLException {
		String bits;
		String digit = "";
		do {
			bits = getBits(5);
			digit += bits.substring(1);
		} while (bits.charAt(0) == '1');
		return Long.parseLong(digit, 2);
	}

	private String getBits(int length) throws EOLException {
		String bits = "";
		for (int i = 0; i < 5; ++i) {
			if (this.pointer == binaryLength)
				throw new EOLException();
			bits += this.binary.charAt(pointer++);
		}

		return bits;
	}

	private long binaryToHex(int length) throws EOLException {
		String pkgVer = "";
		int ct = 0;
		while (ct++ < length) {
			if (this.pointer == binaryLength)
				throw new EOLException();
			pkgVer += binary.charAt(pointer++);
		}
		return Long.parseLong(pkgVer, 2);
	}

	private class EOLException extends Exception {

		private EOLException() {
			super();
		}

	}

}

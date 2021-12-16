package day16;

class PartOne {

	private final String binary;
	private final int binaryLength;
	private int pointer;

	private int pkgVerSum;

	PartOne(String binary) {
		this.binary = binary;
		this.binaryLength = binary.length();
		this.pointer = 0;
		this.pkgVerSum = 0;
	}

	void run() {
		while (true) {
			try {
				parsePacket();
			} catch (EOLException e) {
				break;
			}
		}

		System.out.println(pkgVerSum);
	}

	private void parsePacket() throws EOLException {
		int pkgVer = binaryToHex(3);
		pkgVerSum += pkgVer;
		int typeID = binaryToHex(3);
		if (typeID == 4) {
			String bits;
			String digit = "";
			do {
				bits = getBits(5);
				digit += bits.substring(1);
			} while (bits.charAt(0) == '1');
			long num = Long.parseLong(digit, 2);
		} else {
			int lengthTypeID = binaryToHex(1);
			if (lengthTypeID == 0) {
				int totalLength = binaryToHex(15);
				int begin = this.pointer;
				int inc = 0;
				while (inc < totalLength) {
					parsePacket();
					inc = this.pointer - begin;
				}
			} else {
				int count = binaryToHex(11);
				while (count-- > 0)
					parsePacket();
			}
		}
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

	private int binaryToHex(int length) throws EOLException {
		String pkgVer = "";
		int ct = 0;
		while (ct++ < length) {
			if (this.pointer == binaryLength)
				throw new EOLException();
			pkgVer += binary.charAt(pointer++);
		}
		return Integer.parseInt(pkgVer, 2);
	}

	private class EOLException extends Exception {

		private EOLException() {
			super();
		}

	}

}

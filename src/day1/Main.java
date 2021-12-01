package day1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		prep();
		new PartTwo(scanner).run();
	}

	private static void prep() {
		String path = "resources/" + Main.class.getPackageName() + "/input";
		try {
			scanner = new Scanner(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

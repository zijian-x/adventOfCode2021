package day2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String path = "resources/" + Main.class.getPackageName() + "/input";

		try (Scanner scanner = new Scanner(new File(path))) {
			// new PartOne(scanner).run();
			new PartTwo(scanner).run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

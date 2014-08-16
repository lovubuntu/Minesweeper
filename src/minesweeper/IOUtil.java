package minesweeper;

import java.util.Scanner;

public class IOUtil {
	private static Scanner scanner = new Scanner(System.in);

	public static String read() {
		return scanner.nextLine();
	}

	public static void print(String string) {
		System.out.print(string);
	}

	public static void println(String string) {
		System.out.println(string);
	}

}

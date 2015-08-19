package task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
	/*
	 * Считайте из файла текст на английском языке, вычислите относительную
	 * частоту повторения каждой буквы и выведите на экран результат в порядке
	 * убывания относительной частоты повторения.
	 */
	 
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		StringBuffer text = new StringBuffer();
		String filename = askUser("Type the filename. Only latin letters are acceptable!",
				"[a-zA-z0-9][a-zA-z0-9./]{0,}");
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String temp = "";
			for (; (temp = br.readLine()) != null;) {
				text.append(temp);
			}
		} catch (IOException e) {
			System.out.println("Error reading file!");
		}

		if (text.length() > 0) {
			buildStat(text.toString().toLowerCase());
		}
	}

	static void buildStat(String text) {
		TreeSet<LetterStat> letters = new TreeSet<LetterStat>(new LetterStatComparator());

		ArrayList<LetterStat> zerostat = new ArrayList<LetterStat>(1);
		zerostat.add(new LetterStat((char) 0));

		for (char l = 'a'; l <= 'z'; l++) {
			LetterStat s = new LetterStat(l);
			for (int j = 0; j < text.length(); j++) {
				if (text.charAt(j) == l) {
					s.incr(1);
				}
			}
			s.countStat(text.length());
			letters.add(s);
		}

		letters.removeAll(zerostat);

		Iterator<LetterStat> ls = letters.iterator();
		while (ls.hasNext()) {
			System.out.println(ls.next());
		}

	}

	static String askUser(String question, String allowedAnswers) {
		String input;
		String notAllowedAnswer = "You entered wrong symbols, please try again!";
		while (true) {
			System.out.print(question + ": ");
			input = sc.nextLine();
			if (input.matches(allowedAnswers)) {
				break;
			} else {
				System.out.println(notAllowedAnswer);
			}
		}
		return input;
	}
}

class LetterStat {
	private char letter;
	private int qty;
	private double stat;

	LetterStat(char letter) {
		this.letter = letter;
		this.qty = 0;
		this.stat = qty;
	}

	public char getLetter() {
		return letter;
	}

	public int getQty() {
		return qty;
	}

	public double getStat() {
		return stat;
	}

	public void incr(int qty) {
		this.qty += qty;
	}

	@Override
	public String toString() {
		return String.format("%s : %3d : %.2f ", letter, qty, stat);
	}

	public void countStat(int total) {
		stat = qty * 100. / total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + qty;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LetterStat other = (LetterStat) obj;
		if (qty != other.qty)
			return false;
		return true;
	}
}

class LetterStatComparator implements Comparator<LetterStat> {
	@Override
	public int compare(LetterStat a, LetterStat b) {
		return b.getQty() - a.getQty();
	}
}

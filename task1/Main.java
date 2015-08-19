package task1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class Main {
	/*
	 * Написать метод, который создаст список, положит в него 10 элементов,
	 * затем удалит первые два и последний, а затем выведет результат на экран.
	 */
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			a.add(rand.nextInt(100));
		}
		
		System.out.println(a);
		a.remove(0);
		a.remove(0);
		a.remove(a.size() - 1);
		System.out.println(a);

		ArrayDeque<Integer> b = new ArrayDeque<Integer>();
		for (int i = 0; i < 10; i++) {
			b.push(rand.nextInt(100));
		}
		
		System.out.println(b);
		b.pop();
		b.pop();
		b.pollLast();
		System.out.println(b);
	}
}

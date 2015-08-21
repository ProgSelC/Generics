package selcpkg;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Integer[] a = { 1, 1, 2, 3, 3, 4, 5, 6, 7, 9, 9, 9, 9, 9, 10 };
		typeDuplicates(a);

	}

	public static <T> void typeDuplicates(T[] a) {
		if (a != null) {
			HashMap<T, Integer> map = new HashMap<T, Integer>();
			for (T key : a) {
				if (map.get(key) == null) {
					map.put(key, 1);
				} else {
					map.put(key, map.get(key) + 1);
				}
			}

			for (Map.Entry<T, Integer> s : map.entrySet()) {
				if (s.getValue() > 1) {
					System.out.printf("Element \"%s\" has: %2d entries\n", s.getKey(), s.getValue());
				}
			}
		} else {
			System.out.println("The array is null");
		}
	}

}


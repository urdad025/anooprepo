package javaOOS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArraListClass {

	public static void main(String[] args) {

		String[] arr = { "mango", "Cherry", "Grapes" };
		ArrayList<String> list = new ArrayList<>(Arrays.asList(arr));
		list.add("papaya");
		for (String a : list) {
			System.out.println(a);
		}
		int[] num = { 6, 7, 3, 1, 2, 3, 4, 5 };
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.stream(num).boxed().toList());

		list1.add(0, 12);

		System.out.println(list1);
		int index = 0;
		for (Integer x : list1) {
			System.out.println("Index: " + index + ", Value: " + x);
			index++;
		}
		System.out.println(list1.stream().limit(2).toList());

		// hasSetmethod();
		// hasMapmethod();
		// listClass();
		duplicateFinder();
	}

	public static void hasSetmethod() {

		int[] num = { 9, 7, 3, 3, 3, 3, 4, 5 };

		HashSet<Integer> has = new HashSet<>(Arrays.stream(num).boxed().toList());

		has.add(12);

		System.out.println(has);
		Iterator<Integer> it = has.iterator();
		System.out.println(it.next());
		System.out.println(it.next());

		System.out.println("******Finish Set****");

	}

	public static void hasMapmethod() {

		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(0, "Anoop");
		map.put(1, "Akash");
		map.put(2, "Ana");
		map.put(3, "Aru");

		Set<Map.Entry<Integer, String>> sn = map.entrySet();
		Iterator<Map.Entry<Integer, String>> itr = sn.iterator();
		System.out.println();

		while (itr.hasNext()) {
			Map.Entry<Integer, String> mp = itr.next();
			System.out.println(mp.getKey());
			System.out.println(mp.getValue());

		}
	}

	public static void listClass() {

		System.out.println("exercise*****");

		int[] arr = { 4, 3, 3, 2, 2, 2, 1, 1, 1, 1 };

		List<Integer> ls = new ArrayList<Integer>(Arrays.stream(arr).boxed().toList());

		Set<Integer> newls = new HashSet<>(ls);

		for (Integer x : newls) {
			int i = 0;

			for (int j = 0; j <= ls.size() - 1; j++) {
				if (ls.get(j).equals(x)) {
					i++;
				}
			}

			System.out.println("Numner " + x + " repeated in array for " + i + " times");

		}

	}

	public static void duplicateFinder() {

		System.out.println("exercise*****");

		int[] arr = { 4,4,3, 3, 2, 2, 2, 1, 1, 1, 1 };

		Set<Integer> unique = new HashSet<>();

		Map<Integer, Integer> duplicate = new HashMap<>();

		for (int i : arr) {

			if (!unique.add(i)) {

				duplicate.put(i, duplicate.getOrDefault(i, 1) + 1);

			} else {

				duplicate.put(i, 1);

			}

		}
		for (Entry<Integer, Integer> entry : duplicate.entrySet()) {
			System.out.println("Number: " + entry.getKey() + " is repeated for: " + entry.getValue());
			
			if(entry.getValue()==1) {
				System.out.println("Number: " + entry.getKey() +" is a unique numbner");
			} else {
				System.out.println("No unique number");
			}

		}
	}
}

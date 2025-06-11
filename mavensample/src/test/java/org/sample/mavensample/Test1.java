package org.sample.mavensample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

//@Test
	public void regular() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Akash");
		names.add("Damki");
		names.add("Anoop");
		names.add("Aansh");
		names.add("Pune");

		int count = 0;

		for (int i = 0; i < names.size(); i++) {
			String actuals = names.get(i);
			if (actuals.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
	}

//@Test
	public void streamFilter() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("Akash");
		names.add("Damki");
		names.add("Anoop");
		names.add("Aansh");
		names.add("Pune");
		names.add("Ana");
		names.add("Dev");

		long c = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		names.stream().filter(s -> s.length() < 4).forEach(s -> System.out.println(s));

		System.out.println("********");
		names.stream().filter(s -> s.length() > 4).limit(2).forEach(s -> System.out.println(s));

	}

//@Test
	public void streamcreate() {
		long a = Stream.of("Anoop", "Abhinav", "Suman", "Guru", "Ivan").filter(s -> s.startsWith("A")).count();
		System.out.println(a);

	}

	//@Test
	public void mapTest() {

		// Stream.of("Anoop","Abhinav","Suman","Guru","Ivan").filter(s->s.endsWith("n")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

		// Stream.of("Anoop","Abhinav","Suman","Guru","Ivan").filter(s->s.contains("u")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

		String[] arr = { "Anoop", "Abhinav", "Auman", "Guru", "Ivan" };

		Arrays.asList(arr).stream().filter(s -> s.toLowerCase().startsWith("a")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
	}
	
	//@Test
	public void mergeTest() {
		String[] arr = { "Parmod", "Jack", "Ana", "Laura", "Martin" };
		ArrayList<String> names = new ArrayList<String>();
		names.add("Akash");
		names.add("Damki");
		names.add("Anoop");
		names.add("Aansh");
		names.add("Pune");
		
	Stream<String> newStream =	Stream.concat(Arrays.asList(arr).stream(), names.stream());
	
	newStream.sorted().forEach(s->System.out.println(s));
			
	}
	//@Test
	public void findinArrayusingStream() {
		String[] arr = { "Parmod", "Jack", "Ana", "Laura", "Anoop" };
		ArrayList<String> names = new ArrayList<String>();
		names.add("Akash");
		names.add("Damki");
		names.add("Anoop");
		names.add("Aansh");
		names.add("Pune");
		
		Stream<String> newStream =	Stream.concat(Arrays.asList(arr).stream(), names.stream());
		boolean b=newStream.anyMatch(s->s.equalsIgnoreCase("Anoop"));
		System.out.println(b);
		Assert.assertTrue(b);
	}
	
	//@Test
	public void streamCollect() {
		String[] arr = { "Parmod", "Jack", "Ana", "Laura", "Anoop" };
		ArrayList<String> names = new ArrayList<String>();
		names.add("Akash");
		names.add("Damki");
		names.add("Anoop");
		names.add("Aansh");
		names.add("Pune");
		
		List<String> ls =  names.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase())
				.collect(Collectors.toList());
	//	System.out.println(ls.get(0));
	}
	
	@Test
	public void assignment() {
		Integer[] arr = {3,2,2,7,5,1,9,7,2,2,7,7,3,3};
		//Print - unique numbers, short array.
		
		List<Integer> num = Arrays.asList(arr);
		
		num.stream().sorted().forEach(System.out::println);
		
		System.out.println("****");
		
		Arrays.asList(arr).stream().distinct().sorted().forEach(System.out::println);

		System.out.println("****");
		num.stream().filter(i -> Collections.frequency(num, i) > 1).distinct().sorted().forEach(System.out::println);
		
		//short and distinct and print 3rd element

		System.out.println("****");
	List<Integer> nls=	Arrays.asList(arr).stream().distinct().sorted().collect(Collectors.toList());

		System.out.println(nls.get(2));
		
		//frequency of repeated elements
		
		num.stream().filter(s-> Collections.frequency(num, s) > 1).distinct().sorted()
		.forEach(s-> System.out.println(s+" appear "+ Collections.frequency(num, s)+ " times" ));
	}
	
}

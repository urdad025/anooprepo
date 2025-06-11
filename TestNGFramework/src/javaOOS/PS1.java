package javaOOS;

import org.testng.annotations.*;

public class PS1 extends PS {

	// Single Responsibility Principle (SRP)

	@Test
	public void testRun() {

		int a = 3;
		PS2 ps2 = new PS2(a); // Parameterized constructor
		doThis();
		System.out.println(ps2.increment());
		System.out.println(ps2.decrement());

		System.out.println(ps2.multiplyThree());

	}

}

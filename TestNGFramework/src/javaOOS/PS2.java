package javaOOS;

public class PS2 extends PS3 {

	int a;

	public PS2(int a) {
		super(a); //parent class constructor will be invoked
		this.a=a; //assigning loacl variable (from constructor) to class level of variable  
		

	}

	public int increment() {

		a = a + 1;
		return a;

	}

	public int decrement() {

		a = a - 1;
		return a;

	}

}

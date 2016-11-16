package com.person.staticInnerClass;

/**
 * 参考：http://stackoverflow.com/questions/7486012/static-classes-in-java <br>
 * 
 * @author lakala-shawn
 *
 */
public class TestMyStaticClass {

	public static void main(String[] args) {
		MyStaticClass.setMyStaticMember(5);
		System.out.println("Static value: " + MyStaticClass.getMyStaticMember());
		System.out.println("Value squared: " + MyStaticClass.squareMyStaticMember());
		// MyStaticClass x = new MyStaticClass(); // results in compile time
		// error
	}
}

// final class 被称做 top-level java class
// A top-level Java class mimicking static class behavior
final class MyStaticClass {
	private MyStaticClass() { // private constructor
		myStaticMember = 1;
	}

	// Make all the members and functions of the class static
	private static int myStaticMember;

	public static void setMyStaticMember(int val) {
		myStaticMember = val;
	}

	public static int getMyStaticMember() {
		return myStaticMember;
	}

	public static int squareMyStaticMember() {
		return myStaticMember * myStaticMember;
	}
}

/*
 * 报错:
//Illegal modifier for the class staticClass; only public, abstract & final are permitted
static class staticClass
{
	
}*/

//JDK 中的体现:
// 比如java.lang.Math (就是一个函数 - 函数式编程)
// public final class Math {
//
// /**
// * Don't let anyone instantiate this class.
// */
// private Math() {}
//
// /**
// * The {@code double} value that is closer than any other to
// * <i>e</i>, the base of the natural logarithms.
// */
// public static final double E = 2.7182818284590452354;

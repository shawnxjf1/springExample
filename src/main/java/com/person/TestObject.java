package com.person;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

public class TestObject {
	// object对象中的 public boolean equals(Object obj)，对于任何非空引用值 x 和 y，当且仅当 x 和 y
	// 引用同一个对象时，此方法才返回 true；
	// 注意：当此方法被重写时，通常有必要重写 hashCode 方法，以维护 hashCode
	// 方法的常规协定，该协定声明相等对象必须具有相等的哈希码。如下：
	// (1)当obj1.equals(obj2)为true时，obj1.hashCode() == obj2.hashCode()必须为true
	// (2)当obj1.hashCode() == obj2.hashCode()为false时，obj1.equals(obj2)必须为false

	@Test
	public void testObjEqualOverrite() {
		Student stu = new Student("01Name", "01");
		Student stuBak = new Student("01Name", "01");
		if (stu == stuBak) {
			System.out.println("stu == stuBak");
		}
		if (stu.equals(stuBak)) {
			System.out.println("stu.equals(stuBak)");
		}
		/**
		 * 2016年12月09日 输出<br>
		 * stu.equals(stuBak)
		 */
	}

	@Test
	public void testHashSet() {
		Student n1 = new Student("01Name", "01");
		Student n2 = new Student("01Name", "01");

		Collection c = new HashSet();
		c.add(n1);
		c.add(n2);
		System.out.println("n1.equals(n2)==" + n1.equals(n2));
		System.out.println("------------");
		System.out.println("n1.hashcode=" + n1.hashCode());
		System.out.println("n2.hashcode=" + n2.hashCode());
		System.out.println(c);
		/**
		 * 2016年12月09日 测试结果：没有重写hashcode 一个collection里面存放了两个相同值得对象<br>
		 * n1.equals(n2)==true ------------ n1.hashcode=1768673309
		 * n2.hashcode=623662589 [com.person.Student@696bd01d,
		 * com.person.Student@252c55fd]
		 */
	}
	@Test
	public void testStudentWithHashCode()
	{
		StudentWithHashCode n1 = new StudentWithHashCode("01Name", "01");
		StudentWithHashCode n2 = new StudentWithHashCode("01Name", "01");

		Collection c = new HashSet();
		c.add(n1);
		c.add(n2);
		System.out.println("n1.equals(n2)==" + n1.equals(n2));
		System.out.println("------------");
		System.out.println("n1.hashcode=" + n1.hashCode());
		System.out.println("n2.hashcode=" + n2.hashCode());
		System.out.println(c);
		/**
		 * n1.equals(n2)==true
------------
n1.hashcode=1537
n2.hashcode=1537
[com.person.StudentWithHashCode@601] //2016年12月09日测试过，必须hashCode 和equals两个都重写才会hashset才会只有一个对象
		 */
	}

}

class StudentWithHashCode {
	String name;
	String id;

	StudentWithHashCode(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	@Override
	public int hashCode()
	{
		return id.hashCode();
	}
	
	/**
	 * 请注意： 重写equals方法后最好重写hashCode方法，否则两个等价对象可能得到不同的hashCode,这在集合框架中使用可能产生严重后果
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof StudentWithHashCode)) {
			return false;
		}
		final StudentWithHashCode s = (StudentWithHashCode) obj;
		if (s.name.equals(this.name) && s.id.equals(this.id)) {
			return true;
		}
		return false;
	}

}

class Student {
	String name;
	String id;

	Student(String name, String id) {
		this.name = name;
		this.id = id;
	}

	/**
	 * 请注意： 重写equals方法后最好重写hashCode方法，否则两个等价对象可能得到不同的hashCode,这在集合框架中使用可能产生严重后果
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Student)) {
			return false;
		}
		final Student s = (Student) obj;
		if (s.name.equals(this.name) && s.id.equals(this.id)) {
			return true;
		}
		return false;
	}

}

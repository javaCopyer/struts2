package com.demo01.entity;

import java.util.Arrays;
import java.util.Comparator;

public class Person implements Comparable{
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Object o) {
		if(this.age > ((Person)o).getAge()) {
			return 1;
		} else {
			return -1;
		}
		
	}
	@Override
	public String toString() {
		return name + " " + age;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Person[] people = new Person[] { new Person("xujian", 20),
				new Person("xiewei", 10), new Person("aaa", 30)};
		System.out.println("排序前");
		for (Person person : people) {
			System.out.println(person.getName() + ":" + person.getAge());
		}
//		Arrays.sort(people);
		Arrays.sort(people, new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Person p1 = (Person) o1;
				Person p2 = (Person) o2;
				if(p1.getAge() > p2.getAge()) {
					return 1;
				} else {
					return -1;
				}
			}
			
		});
		System.out.println("\n排序后");
		for (Person person : people) {
			System.out.println(person.getName() + ":" + person.getAge());
		}
	}
	
	
}

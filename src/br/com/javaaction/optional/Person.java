package br.com.javaaction.optional;

import java.util.Optional;

public class Person {

	private int age;
	private Optional<Car> car = Optional.empty();

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Optional<Car> car) {
		this.car = car;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

package br.com.javaaction.optional;

import java.util.Optional;

public class TestNullPointer {

	public static void main(String[] args) {
		Person person = new Person();
		String name = getCarInsuranceNameOpt(person, 10);

		System.out.println("Name:" + name);

		Insurance insurance = new Insurance();
		insurance.setName("Aldo");

		Car car = new Car();
		car.setInsurance(Optional.of(insurance));

		Optional<Car> optCar = Optional.of(car);
		person.setCar(optCar);
		person.setAge(20);

		String nameOk = getCarInsuranceNameOpt(person, 20);

		System.out.println("Name: " + nameOk);
		System.out.println("Age: " + person.getAge());

		Insurance result = nullSafeFindCheapeastInsuranceSingle(Optional.empty(), Optional.empty()).orElseThrow();

	}

	// Old way
	/*
	 * public static String getCarInsuranceName(Person person) { return
	 * person.getCar().getInsurance().getName(); }
	 */

	public static String getCarInsuranceNameOpt(Person person, int minAge) {
		Optional<Person> optPerson = Optional.of(person);
		String name = optPerson.filter(ins -> ins.getAge() >= minAge).flatMap(Person::getCar).flatMap(Car::getInsurance)
				.map(Insurance::getName).orElse("Unknown");
		return name;
	}

	public static Insurance findCheapestInsurance(Person person, Car car) {

		return new Insurance();
	}

	public static Optional<Insurance> nullSafeFindCheapeastInsurance(Optional<Person> person, Optional<Car> car) {
		if (person.isPresent() && car.isPresent()) {
			return Optional.of(findCheapestInsurance(person.get(), car.get()));
		} else {
			return Optional.empty();
		}
	}

	public static Optional<Insurance> nullSafeFindCheapeastInsuranceSingle(Optional<Person> person, Optional<Car> car) {
		Optional<Insurance> optInsurance = person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));

		return optInsurance;
	}

}

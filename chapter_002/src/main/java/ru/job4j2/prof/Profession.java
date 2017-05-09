package ru.job4j2.prof;

/**
* Class Profession - parent class to all professions.
* @author vivanov
* @version 1
* @since 08.05.2017
*/
public class Profession {

	/** field name.*/
	private String name;

	/** field last name.*/
	private String lastName;

	/** field birthday date.*/
	private long birthDay;

	/** field address.*/
	private String address;

	/** field diploma.*/
	private String diploma;

	/** field working hours of the doctor for month.*/
	private int workingHours;

	/** field salary value.*/
	private int salary;
	/** Default constructor.*/
	public Profession() {
	}

	/** Constructor with parameters.
	 * @param name - name
	 * @param lastName - last name.
	 * @param birthDay - birthday.
	 * @param diploma - diploma.
	 * @param workingHours - working hours
	 * @param salary - salary per month
	 */
	public Profession(String name, String lastName, long birthDay, String diploma, int workingHours, int salary) {
		this.name = name;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.diploma = diploma;
		this.workingHours = workingHours;
		this.salary = salary;
	}

	/**
	 * Name getter.
	 * @return Name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Last name getter.
	 * @return last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Birth Day getter.
	 * @return birth day
	 */
	public long getBirthDay() {
		return birthDay;
	}

	/**
	 * Address getter.
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Diploma getter.
	 * @return diploma
	 */
	public String getDiploma() {
		return diploma;
	}

	/**
	 * Working hours getter.
	 * @return working hours
	 */
	public int getWorkingHours() {
		return workingHours;
	}

	/**
	 * Salary getter.
	 * @return salary
	 */
	public int getSalary() {
		return salary;
	}
}
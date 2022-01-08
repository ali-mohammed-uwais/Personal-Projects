package assignment7;

public class Course {

	private String name;
	private int credits, capacity;
	private Student[] roster;
	private int numStudents = 0;

	/**
	 * 
	 * @param name
	 * @param credits
	 * @param capacity basically a constructor that these
	 */
	public Course(String name, int credits, int capacity) {
		this.name = name;
		this.credits = credits;
		this.capacity = capacity;
		this.roster = new Student[capacity];
	}

	/**
	 * code returns the credits this a getter
	 * 
	 * @param none
	 */
	public int getCredits() {
		return this.credits;
	}

	/**
	 * no parameters. this is a getter
	 * 
	 * @returns name
	 */
	public String getName() {
		return name;
	}

	/**
	 * getter
	 * 
	 * @return the capacity of a classroom
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean addStudent(Student s) {

		for (int i = 0; i < numStudents + 1; i++) {

			if (numStudents < capacity && roster[i] != null) {
				if (roster[i].equals(s)) {

					return false;
				}
			} 
			else if (numStudents < capacity) {
				roster[numStudents] = s;
				numStudents = numStudents + 1;
				return true;

			}
		}

		return false;
	}

	/**
	 * parameter is index
	 * return the roster at specific index
	 */
	public Student getStudentAt(int index) {
		return roster[index];

	}

	public int getSeatsRemaining() {
		return capacity - numStudents;
	}
	/**
	 * 
	 * @return a string
	 */
	public String generateRoster() {
		String allNames = "";
		if (numStudents == 0) {
			return null;
		}
		for (int i = 0; i < numStudents; i++) {
			allNames += roster[i].getFullName();

		}
		return allNames;
	}
	/**
	 * 
	 * @return a double which is the GPA
	 */
	public double calculateAverageGPA() {
		double totalGPA = 0.0;
		for(int i = 0; i < numStudents; i++) {
			totalGPA += roster[i].calculateGradePointAverage();
		}
		return totalGPA/numStudents;
		
		
		
	}
	/**
	 * returns a string
	 */
	public String toString() {
		
		
		
		
		
		return "" + getName() + "" + getCredits();
	}

}

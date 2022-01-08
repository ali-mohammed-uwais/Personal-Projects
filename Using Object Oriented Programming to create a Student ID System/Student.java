package assignment7;

public class Student {
	// First Name
	// Last Name
	// Student ID Number
	// Attempted Credits
	// Passing Credits
	// Total Grade Quality Points
	// Bear Bucks Balance

	private String firstName, lastName;
	private int id, AttemptedCredits, passingCredits;
	private double bearBucks, totalGradeQualityPoints;

	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param id
	 */
	public Student(String firstName, String lastName, int id) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */
	public String getFullName() {

		return this.firstName + " " + this.lastName;

	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param grade
	 * @param credits
	 */
	public void submitGrade(double grade, int credits) {
		totalGradeQualityPoints += (grade * credits);
		if (grade >= 1.7) {
			this.passingCredits += credits;
		}
		this.AttemptedCredits += credits;

	}

	/**
	 * 
	 * @return
	 */
	public int getTotalAttemptedCredits() {
		return this.AttemptedCredits;
	}

	/**
	 * 
	 * @return
	 */
	public int getTotalPassingCredits() {
		return this.passingCredits;
	}

	/**
	 * no paramaters
	 * 
	 * @return GPA
	 */
	public double calculateGradePointAverage() {
		return 1.0 * totalGradeQualityPoints / AttemptedCredits;
	}

	/**
	 * 
	 * @return a string that informs you what the class standing is
	 */
	public String getClassStanding() { // based on passing grades
		if (getTotalPassingCredits() >= 90) {
			return "Senior";
		} else if (getTotalPassingCredits() < 90 && getTotalPassingCredits() >= 60) {
			return "Junior";
		} else if (getTotalPassingCredits() < 60 && getTotalPassingCredits() >= 30) {
			return "Sophomore";
		} else {
			return "First Year";
		}

	}

	/**
	 * 
	 * @return a boolean that tells you if you are eligible for Phi Beta Kappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		if (getTotalAttemptedCredits() >= 98 && calculateGradePointAverage() >= 3.60) {
			return true;
		} else if (getTotalAttemptedCredits() >= 75 && calculateGradePointAverage() >= 3.80) {
			return true;
		} else { // if none of the above cases are met than they are not eligible
			return false;
		}
	}

	/**
	 * 
	 * @param amount adds amount to bearbucks
	 */
	public void depositBearBucks(double amount) {
		this.bearBucks += amount;
	}

	/**
	 * 
	 * @param amount subtracts the amount from bearBucks
	 */
	public void deductBearBucks(double amount) {
		this.bearBucks = this.bearBucks - amount;
	}

	/**
	 * 
	 * @return bearBucks
	 */
	public double getBearBucksBalance() {
		return this.bearBucks;
	}

	/**
	 * 
	 * @return bearBucks
	 */
	public double cashOutBearBucks() {
		if (getBearBucksBalance() <= 10) {
			this.bearBucks = 0.0;
			return this.bearBucks;
		} else {
			double balance = this.bearBucks - 10;
			this.bearBucks = 0;
			return balance;
		}
	}

	/**
	 * 
	 * @param firstName
	 * @param other
	 * @param isHyphenated
	 * @param id
	 * @return
	 */
	public Student createLegacy(String firstName, Student other, boolean isHyphenated, int id) {
		if (isHyphenated) {
			Student newChild = new Student(firstName, this.lastName + "-" + other.lastName, id);
			newChild.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
			return newChild;

		} else {
			Student newChild = new Student(firstName, this.lastName, id);
			newChild.depositBearBucks(this.cashOutBearBucks() + other.cashOutBearBucks());
			return newChild;

		}

	}

	/**
	 * just returns a string of first name added to last name
	 */
	public String toString() {
		return "" + this.firstName + " " + this.lastName + "" + this.id;
	}

}

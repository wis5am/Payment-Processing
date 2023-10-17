package s23Lab6;
/**
* Description: The Programmer class is an abstract superclass that implements the Payme interface.
* Subclasses of Programmer should provide implementations for the abstract methods:
* {@link #getPaymentAmount()} and {@link #earnings()}.
* @author Wisam Al-Humairi
* @see Programmer
* @see HourlyProgrammer
* @see SalariedProgrammer
* @see CommissionProgrammer
* @see BasePlusCommissionProgrammer
* @see PaymeInterfaceTest
* @version 17.0.5
* @since June 25th, 2023
*/

public abstract class Programmer  {

	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private int contractYear;
	
	/**
     * Three-argument constructor to create a Programmer object.
     *
     * @param firstName           The first name of the programmer.
     * @param lastName            The last name of the programmer.
     * @param socialSecurityNumber The social security number of the programmer.
     * @param year                The last two digits of the contract year (e.g., 21 for 2021).
     */
	public Programmer(String first, String last, String ssn, int year) {
	 firstName = first;
	 lastName = last;
	 socialSecurityNumber = ssn;
	 contractYear = modifyContractYear(year);
	}
	/**
     * Gets the contract year of the programmer.
     *
     * @return The full contract year (e.g., 2021) calculated based on the provided last two digits (e.g., 21).
     */
	public int getContractYear() {
		return contractYear;
	}
    // Private method to calculate the full contract year from the last two digits provided.
	private int modifyContractYear(int year) {
	    if (year >= 0 && year <= 23) {
	        return 2000 + year;
	    } else if (year > 23 && year <= 99) {
	        return 1900 + year;
	    } else {
	        if (year < 1900) {
	            return 1900;
	        } else if (year > 2023) {
	            return 2023;
	        }
	    }
	    return year;
	}
	/**
	 * Gets the first name of the programmer.
	 *
	 * @return The first name as a String.
	 */
	public String getFirstName() {
	    return firstName;
	}
	/**
	 * Gets the last name of the programmer.
	 *
	 * @return The last name as a String.
	 */
	public String getLastName() {
	    return lastName;
	}
	/**
	 * Gets the social security number of the programmer.
	 *
	 * @return The social security number as a String.
	 */
	public String getSocialSecurityNumber() {
	    return socialSecurityNumber;
	}
	
	/**
	 * Returns a String representation of the Programmer object.
	 *
	 * @return A formatted String containing first name, last name, social security number, and contract year.
	 */
	@Override
	public String toString() {
	return String.format("%s %s\n%s: %s\n%s: %s\n%d:", 
	  getFirstName(), getLastName(), getSocialSecurityNumber(), getContractYear());
	} 
	
	
	/**
	 * Abstract method to get the payment amount for the programmer.
	 * Subclasses must provide their implementation.
	 *
	 * @return The payment amount as a double value.
	 */
	public abstract double getPaymentAmount();
	/**
	 * Abstract method to get the earnings for the programmer.
	 * Subclasses must provide their implementation.
	 *
	 * @return The earnings as a double value.
	 *         The meaning of earnings can vary depending on the subclass.
	 *         For example, it could represent the total salary, hourly wage, or any other form of payment.
	 */
	public abstract double earnings(); /** No implementation here. This method should be overridden by subclasses. */
} 



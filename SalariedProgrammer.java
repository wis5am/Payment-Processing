package s23Lab6;

/**
 * Description: The SalariedProgrammer class represents a salaried programmer, which is a type of programmer.
 * It extends the abstract class Programmer and implements the Payme interface.
 * @author Wisam Al-Humairi
 * @see Payme
 * @see Programmer
 * @see PaymeInterfaceTest
 * @version 17.0.5
 * @since June 25th, 2023
 */
public class SalariedProgrammer extends Programmer implements Payme {

    private double weeklySalary;

    /**
     * Constructor to create a SalariedProgrammer object.
     *
     * @param firstName           The first name of the salaried programmer.
     * @param lastName            The last name of the salaried programmer.
     * @param socialSecurityNumber The social security number of the salaried programmer.
     * @param year                The year the salaried programmer joined the company.
     * @param weeklySalary        The weekly salary of the salaried programmer.
     *                            Must be greater than or equal to 0.0.
     * @throws IllegalArgumentException if weeklySalary is less than 0.0.
     */
    public SalariedProgrammer(String firstName, String lastName, String socialSecurityNumber,int year,
                              double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber,year);

        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        }

        this.weeklySalary = weeklySalary;
    }

    /**
     * Sets the weekly salary of the salaried programmer.
     *
     * @param weeklySalary The weekly salary to be set.
     * @throws IllegalArgumentException if weeklySalary is less than 0.0.
     */
    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        }

        this.weeklySalary = weeklySalary;
    }

    /**
     * Gets the weekly salary of the salaried programmer.
     *
     * @return The weekly salary as a double value.
     */
    public double getWeeklySalary() {
        return weeklySalary;
    }

    /**
     * Calculates the payment amount for the salaried programmer.
     *
     * @return The payment amount as a double value.
     *         The payment amount is the weekly salary of the salaried programmer.
     */
    @Override
    public double getPaymentAmount() {
        return getWeeklySalary();
    }

    /**
     * Returns a String representation of the SalariedProgrammer object.
     *
     * @return A formatted String containing the first name, last name, social security number, contract year, and weekly salary.
     */
    @Override
    public String toString() {
        return String.format("Salaried Programmer: %s %s\nSocial Security Number: %s\nContarct Year: %d\nWeekly Salary: $%.2f",
                getFirstName(), getLastName(), getSocialSecurityNumber(),getContractYear(), getWeeklySalary());
    }

    /**
     * This method should be overridden by subclasses to provide the earnings for the salaried programmer.
     *
     * @return The earnings of the salaried programmer as a double value.
     *         The meaning of earnings can vary depending on the subclass.
     *         For a salaried programmer, it could represent the monthly or yearly salary.
     */
    @Override
    public double earnings() {
        // TODO: Implement the actual earnings calculation based on the specific requirements of the subclass.
        return getWeeklySalary(); // For now, returning the weekly salary as earnings.
    }
}

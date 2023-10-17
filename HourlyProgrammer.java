package s23Lab6;

/**
 * Description: The HourlyProgrammer class represents an hourly programmer, which is a type of programmer.
 * It extends the abstract class Programmer and implements the Payme interface.
 * @author Wisam Al-Humairi
 * @see Payme
 * @see Programmer
 * @see PaymeInterfaceTest
 * @version 17.0.5
 * @since June 25th, 2023
 */
public class HourlyProgrammer extends Programmer implements Payme {

    private double wage; // wage per hour
    private double hours; // hours worked for week

    /**
     * Creates an HourlyProgrammer object representing an hourly paid programmer.
     *
     * @param firstName           The first name of the hourly programmer.
     * @param lastName            The last name of the hourly programmer.
     * @param socialSecurityNumber The social security number of the hourly programmer.
     * @param year                The year the hourly programmer joined the company.
     * @param wage                The hourly wage of the hourly programmer.
     *                            Must be greater than or equal to 0.0.
     * @param hours               The number of hours worked by the hourly programmer for the week.
     *                            Must be between 0.0 and 168.0 (inclusive).
     * @throws IllegalArgumentException If the wage is less than 0.0 or if hours are not within the valid range.
     */
    public HourlyProgrammer(String firstName, String lastName, String socialSecurityNumber,int year,
                            double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber, year);

        if (wage < 0.0) {
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        }

        if ((hours < 0.0) || (hours > 168.0)) {
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }

        this.wage = wage;
        this.hours = hours;
    }

    /**
     * Sets the hourly wage of the hourly programmer.
     *
     * @param wage The hourly wage to be set.
     * @throws IllegalArgumentException if wage is less than 0.0.
     */
    public void setWage(double wage) {
        if (wage < 0.0) {
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        }

        this.wage = wage;
    }

    /**
     * Gets the hourly wage of the hourly programmer.
     *
     * @return The hourly wage as a double value.
     */
    public double getWage() {
        return wage;
    }

    /**
     * Sets the hours worked for the week by the hourly programmer.
     *
     * @param hours The hours worked to be set.
     * @throws IllegalArgumentException if hours is not within the valid range (0.0 to 168.0 inclusive).
     */
    public void setHours(double hours) {
        if ((hours < 0.0) || (hours > 168.0)) {
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }

        this.hours = hours;
    }

    /**
     * Gets the hours worked for the week by the hourly programmer.
     *
     * @return The hours worked as a double value.
     */
    public double getHours() {
        return hours;
    }

    /**
     * Calculates the payment amount for the hourly programmer.
     * If the hours worked are 40 or less, the payment amount is the wage multiplied by the hours worked.
     * If the hours worked are more than 40, the payment amount is the wage for the first 40 hours plus 1.5 times
     * the wage for the additional hours.
     *
     * @return The payment amount as a double value.
     */
    @Override
    public double getPaymentAmount() {
        if (getHours() <= 40) {
            return getWage() * getHours();
        } else {
            return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
        }
    }

    /**
     * Returns a String representation of the HourlyProgrammer object.
     *
     * @return A formatted String containing the first name, last name, social security number, hourly wage,
     * and hours worked.
     */
    @Override
    public String toString() {
        return String.format("Hourly Programmer: %s %s\nSocial Security Number: %s\nContarct Year: %d\nHourly Wage: $%.2f; Hours Worked: %.2f",
                getFirstName(), getLastName(), getSocialSecurityNumber(),getContractYear(), getWage(), getHours());
    }

    /**
     * This method should be overridden by subclasses to provide the earnings for the hourly programmer.
     *
     * @return The earnings of the hourly programmer as a double value.
     *         The meaning of earnings can vary depending on the subclass.
     *         For an hourly programmer, it could represent the weekly or monthly earnings.
     */
    @Override
    public double earnings() {
        // TODO: Implement the actual earnings calculation based on the specific requirements of the subclass.
        return getPaymentAmount(); // For now, returning the payment amount as earnings.
    }
}

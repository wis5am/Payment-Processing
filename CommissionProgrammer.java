package s23Lab6;

/**
 * Description: The CommissionProgrammer class represents a commission-based programmer, which is a type of programmer.
 * It extends the abstract class Programmer and implements the Payme interface.
 * @author Wisam Al-Humairi
 * @see Payme
 * @see Programmer
 * @see BasePlusCommisionProgrammer
 * @see PaymeInterfaceTest
 * @version 17.0.5
 * @since June 25th, 2023
 */
public class CommissionProgrammer extends Programmer implements Payme {

    private double grossSales; // gross weekly sales
    private double commissionRate; // commission percentage

    /**
     * Constructor to create a CommissionProgrammer object.
     *
     * @param firstName           The first name of the commission-based programmer.
     * @param lastName            The last name of the commission-based programmer.
     * @param socialSecurityNumber The social security number of the commission-based programmer.
     * @param year                The year the commission-based programmer joined the company.
     * @param grossSales          The gross weekly sales of the commission-based programmer.
     *                            Must be greater than or equal to 0.0.
     * @param commissionRate      The commission rate of the commission-based programmer.
     *                            Must be greater than 0.0 and less than 1.0.
     * @throws IllegalArgumentException if grossSales is less than 0.0 or if commissionRate is not within the valid range.
     */
    public CommissionProgrammer(String firstName, String lastName, String socialSecurityNumber,int year ,
                                double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber, year);

        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }

        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }

        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    /**
     * Sets the gross weekly sales of the commission-based programmer.
     *
     * @param grossSales The gross weekly sales to be set.
     * @throws IllegalArgumentException if grossSales is less than 0.0.
     */
    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }

        this.grossSales = grossSales;
    }

    /**
     * Gets the gross weekly sales of the commission-based programmer.
     *
     * @return The gross weekly sales as a double value.
     */
    public double getGrossSales() {
        return grossSales;
    }

    /**
     * Sets the commission rate of the commission-based programmer.
     *
     * @param commissionRate The commission rate to be set.
     * @throws IllegalArgumentException if commissionRate is not within the valid range (0.0 to 1.0 exclusive).
     */
    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }

        this.commissionRate = commissionRate;
    }

    /**
     * Gets the commission rate of the commission-based programmer.
     *
     * @return The commission rate as a double value.
     */
    public double getCommissionRate() {
        return commissionRate;
    }

    /**
     * Calculates the payment amount for the commission-based programmer.
     * The payment amount is the gross sales multiplied by the commission rate.
     *
     * @return The payment amount as a double value.
     */
    @Override
    public double getPaymentAmount() {
        return getCommissionRate() * getGrossSales();
    }

    /**
     * Returns a String representation of the CommissionProgrammer object.
     *
     * @return A formatted String containing the first name, last name, social security number, contract year, gross sales,
     * and commission rate.
     */
    @Override
    public String toString() {
        return String.format("Commission Programmer: %s %s\nSocial Security Number: %s\nContarct Year: %d\nGross Sales: $%.2f; Commission Rate: %.2f",
                getFirstName(), getLastName(), getSocialSecurityNumber(),getContractYear(), getGrossSales(), getCommissionRate());
    }

    /**
     * This method should be overridden by subclasses to provide the earnings for the commission-based programmer.
     *
     * @return The earnings of the commission-based programmer as a double value.
     *         The meaning of earnings can vary depending on the subclass.
     *         For a commission-based programmer, it could represent the monthly or yearly earnings.
     */
    @Override
    public double earnings() {
        // TODO: Implement the actual earnings calculation based on the specific requirements of the subclass.
        return getPaymentAmount(); // For now, returning the payment amount as earnings.
    }
}

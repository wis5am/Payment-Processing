package s23Lab6;

/**
 * Description: The BasePlusCommissionProgrammer class represents a base plus commission-based programmer, which is a type of programmer.
 * It extends the CommissionProgrammer class.
 * @author Wisam Al-Humairi
 * @see Payme
 * @see CommissionProgrammer
 * @see PaymeInterfaceTest
 * @version 17.0.5
 * @since June 25th, 2023
 */
public class BasePlusCommissionProgrammer extends CommissionProgrammer {

    private double baseSalary; // base salary per week

    /**
     * Constructor to create a BasePlusCommissionProgrammer object.
     *
     * @param firstName           The first name of the base plus commission-based programmer.
     * @param lastName            The last name of the base plus commission-based programmer.
     * @param socialSecurityNumber The social security number of the base plus commission-based programmer.
     * @param year                The year the base plus commission-based programmer joined the company.
     * @param grossSales          The gross weekly sales of the base plus commission-based programmer.
     *                            Must be greater than or equal to 0.0.
     * @param commissionRate      The commission rate of the base plus commission-based programmer.
     *                            Must be greater than 0.0 and less than 1.0.
     * @param baseSalary          The base salary per week of the base plus commission-based programmer.
     *                            Must be greater than or equal to 0.0.
     * @throws IllegalArgumentException if grossSales is less than 0.0,
     *                                  commissionRate is not within the valid range (0.0 to 1.0 exclusive),
     *                                  or baseSalary is less than 0.0.
     */
    public BasePlusCommissionProgrammer(String firstName, String lastName, String socialSecurityNumber,int year,
                                        double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber,year, grossSales, commissionRate);

        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }

        this.baseSalary = baseSalary;
    }

    /**
     * Sets the base salary per week of the base plus commission-based programmer.
     *
     * @param baseSalary The base salary to be set.
     * @throws IllegalArgumentException if baseSalary is less than 0.0.
     */
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }

        this.baseSalary = baseSalary;
    }

    /**
     * Gets the base salary per week of the base plus commission-based programmer.
     *
     * @return The base salary as a double value.
     */
    public double getBaseSalary() {
        return baseSalary;
    }

    /**
     * Calculates the payment amount for the base plus commission-based programmer.
     * The payment amount is the base salary plus the commission earned based on gross sales.
     *
     * @return The payment amount as a double value.
     */
    @Override
    public double getPaymentAmount() {
        return getBaseSalary() + super.getPaymentAmount();
    }

    /**
     * Returns a String representation of the BasePlusCommissionProgrammer object.
     *
     * @return A formatted String containing the first name, last name, social security number, contract year, gross sales,
     * commission rate, and base salary.
     */
    @Override
    public String toString() {
        return String.format("Base-Plus Commission Programmer: %s %s\nSocial Security Number: %s\nContarct Year: %d\nGross Sales: $%.2f; Commission Rate: %.2f; Base Salary: $%.2f",
                getFirstName(), getLastName(), getSocialSecurityNumber(),getContractYear(), getGrossSales(), getCommissionRate(), getBaseSalary());
    }

    /**
     * This method should be overridden by subclasses to provide the earnings for the base plus commission-based programmer.
     *
     * @return The earnings of the base plus commission-based programmer as a double value.
     *         The meaning of earnings can vary depending on the subclass.
     *         For a base plus commission-based programmer, it could represent the monthly or yearly earnings.
     */
    @Override
    public double earnings() {
        // TODO: Implement the actual earnings calculation based on the specific requirements of the subclass.
        return getPaymentAmount(); // For now, returning the payment amount as earnings.
    }
}

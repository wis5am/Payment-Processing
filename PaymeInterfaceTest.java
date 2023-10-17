package s23Lab6;

/**
 * Description: The PaymeInterfaceTest class is a test class that demonstrates polymorphism using the Payme interface.
 * It creates an array of Payme objects and processes payments for different types of programmers and invoices.
 * @author Wisam Al-Humairi
 * @see Payme
 * @see Programmer
 * @see Invoice
 * @see PaymeInterfaceTest
 * @version 17.0.5
 * @since June 25th, 2023
 */
public class PaymeInterfaceTest {

    /**
     * The main method serves as the entry point of the program.
     * It creates an array of Payme objects, populates it with different programmers and invoices,
     * and then processes their payments polymorphically.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Payme[] paymeObjects = new Payme[6];

        // Populate the array with objects
        paymeObjects[0] = new Invoice("22776", "brakes", 3, 300.00);
        paymeObjects[1] = new Invoice("33442", "gear", 5, 90.99);
        paymeObjects[2] = new SalariedProgrammer("Chioma", "Chidimma", "345-67-0001",10000, 320.00);
        paymeObjects[3] = new HourlyProgrammer("Amara", "Chukwu", "234-56-7770",02, 18.95, 40.0);
        paymeObjects[4] = new CommissionProgrammer("Peter", "Goodman", "123-45-6999",13, 16500.0, 0.44);
        paymeObjects[5] = new BasePlusCommissionProgrammer("Esther", "Patel", "102-34-5888",-10, 1200.0, 0.04, 720.0);

        System.out.println("Payment for Invoices and Programmers are processed polymorphically:\n");

        // Process payments for each Payme object in the array
        for (Payme currentPayme : paymeObjects) {
            System.out.print(currentPayme.toString());

            // If the current object is a BasePlusCommissionProgrammer, increase the base salary by 10%
            if (currentPayme instanceof BasePlusCommissionProgrammer) {
                BasePlusCommissionProgrammer programmer = (BasePlusCommissionProgrammer) currentPayme;
                double oldBaseSalary = programmer.getBaseSalary();
                programmer.setBaseSalary(1.10 * oldBaseSalary);
                System.out.printf("\n%s%.2f" ,"new base salary with 10% increase is: $", programmer.getBaseSalary());
            }

            // Display the payment due for the current Payme object
            System.out.printf("\npayment due: $%.2f", currentPayme.getPaymentAmount());
            System.out.println();
            System.out.println();
        }
        System.out.println("Program by Wisam Al-Humairi");
    }
}

package s23Lab6;
/**
 * Description: The Payme interface represents a contract for classes that can calculate the payment amount.
 * Classes that implement this interface should provide an implementation for the {@link #getPaymentAmount()} method.
 * @author Wisam Al-Humairi
 * @version 17.0.5
 * @since June 25th, 2023
 */
public interface Payme {
	 /**
     * Gets the payment amount for a specific entity.
     *
     * @return The payment amount as a double value.
     */
    double getPaymentAmount();
}
package dpatrefinedsolution;

public interface PricingStrategy {
    double calculatePrice(int productId, double basePrice);
    
    default String paymentMethod() {
        return "default";
    }
}

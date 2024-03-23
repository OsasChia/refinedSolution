package dpatrefinedsolution;

public class CreditCardPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(int productId, double basePrice) {
        return basePrice;
    }

    @Override
    public String paymentMethod() {
        return "Credit Card";
    }
}

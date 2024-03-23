package dpatrefinedsolution;

public class PayPalPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(int productId, double basePrice) {
        return basePrice;
    }

    @Override
    public String paymentMethod() {
        return "PayPal";
    }
}

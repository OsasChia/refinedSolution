package dpatrefinedsolution;

public class FixedDiscountDecorator extends DiscountDecorator {
    private double discountAmount;

    public FixedDiscountDecorator(PricingStrategy wrappedPricingStrategy, double discountAmount) {
        super(wrappedPricingStrategy);
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculatePrice(int productId, double basePrice) {
        double priceAfterWrappedStrategy = wrappedPricingStrategy.calculatePrice(productId, basePrice);
        return Math.max(0, priceAfterWrappedStrategy - discountAmount);
    }
}
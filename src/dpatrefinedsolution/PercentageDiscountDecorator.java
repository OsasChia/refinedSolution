package dpatrefinedsolution;

public class PercentageDiscountDecorator extends DiscountDecorator{
    private double percentage;

    public PercentageDiscountDecorator(PricingStrategy wrappedPricingStrategy, double percentage) {
        super(wrappedPricingStrategy);
        this.percentage = percentage;
    }

    @Override
    public double calculatePrice(int productId, double basePrice) {
        double priceAfterWrappedStrategy = wrappedPricingStrategy.calculatePrice(productId, basePrice);
        return priceAfterWrappedStrategy - (priceAfterWrappedStrategy * percentage / 100);
    }    
}

package dpatrefinedsolution;

public abstract  class DiscountDecorator implements PricingStrategy{
    protected PricingStrategy wrappedPricingStrategy;

    public DiscountDecorator(PricingStrategy wrappedPricingStrategy) {
        this.wrappedPricingStrategy = wrappedPricingStrategy;
    }

    @Override
    public abstract double calculatePrice(int productId, double basePrice);    
}

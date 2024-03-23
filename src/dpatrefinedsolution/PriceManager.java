package dpatrefinedsolution;

import java.util.HashMap;
import java.util.Map;

public class PriceManager {
    //private Map<Integer, Double> priceList = new HashMap<>();
    private Map<Integer, Double> priceList = new HashMap<>();
    private PricingStrategy pricingStrategy;
    
    public PriceManager(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }
    
    public void addProductPrice(int productId, double price) {
        priceList.put(productId, price);
    }    
    
    public double getPrice(int productId) {
        double basePrice = priceList.getOrDefault(productId, 0.0);
        return pricingStrategy.calculatePrice(productId, basePrice);
    }    

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }  
}

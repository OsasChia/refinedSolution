package dpatrefinedsolution;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products = new ArrayList<>();
    private PriceManager priceManager;

    public PriceManager getPriceManager() {
        return priceManager;
    }
    
    public Inventory(PricingStrategy pricingStrategy) {
        this.priceManager = new PriceManager(pricingStrategy);
    }

    public void applyPricingStrategy(PricingStrategy pricingStrategy) {
        this.priceManager.setPricingStrategy(pricingStrategy);
    }
        
    public void addProduct(Product product) {
        products.add(product);
    }

    public void updatePrice(int productId, double newPrice) {
        priceManager.addProductPrice(productId, newPrice);
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        priceManager.setPricingStrategy(pricingStrategy);
    }

    public PricingStrategy getPricingStrategy() {
        return this.priceManager.getPricingStrategy();
    }

    public void displayInventory() {
        for (Product product : products) {
            double price = priceManager.getPrice(product.getProductId());
            System.out.println(product.getProductDetails() + " - Price: $" + price);
        }
    }
    
    public void removeProduct(Product product) {
        products.remove(product);
    }    
}

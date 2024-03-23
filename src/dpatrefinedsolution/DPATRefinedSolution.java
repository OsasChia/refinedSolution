package dpatrefinedsolution;

public class DPATRefinedSolution {
    public static void main(String[] args) {
        // 1. Initialize Category Manager and add categories
        CategoryManager categoryManager = new CategoryManager();
        categoryManager.addCategory("Electronics");
        categoryManager.addCategory("Books");

        // 2. Initialize Inventory with a default pricing strategy (no discount)
        Inventory inventory = new Inventory(new PricingStrategy() {
            @Override
            public double calculatePrice(int productId, double basePrice) {
                return basePrice; // Default strategy without any discount
            }
        });

        // 3. Create and add products to the inventory
        Product laptop = new Product(1, "Laptop", "Electronics");
        Product book = new Product(2, "Book", "Books");
        inventory.addProduct(laptop);
        inventory.addProduct(book);

        // 4. Set initial prices for products
        inventory.updatePrice(1, 1000); // Set price for Laptop
        inventory.updatePrice(2, 50);   // Set price for Book

        // 5. Display initial price
        System.out.println("Inventory initial price:");
        inventory.displayInventory();

        // 6. Update the price of the Book and display
        inventory.updatePrice(2, 60); // Update price for Book
        System.out.println("\nInventory after updating the book's price:");
        inventory.displayInventory();

        // 7. Apply a fixed discount of $10 to all products and display
        inventory.applyPricingStrategy(new FixedDiscountDecorator(inventory.getPricingStrategy(), 10));
        System.out.println("\nInventory with fixed discount 10$ applied:");
        inventory.displayInventory();

        // 8. Apply an additional 50% percentage discount on top of the fixed discount and display
        inventory.applyPricingStrategy(new PercentageDiscountDecorator(inventory.getPricingStrategy(), 50));
        System.out.println("\nInventory with both fixed and percentage discounts applied:");
        inventory.displayInventory();

        // 9. Simulate payment transactions using the final prices after discount
        double laptopFinalPrice = inventory.getPriceManager().getPrice(laptop.getProductId());
        double bookFinalPrice = inventory.getPriceManager().getPrice(book.getProductId());

        PricingStrategy creditCardStrategy = new CreditCardPricingStrategy();
        System.out.println("\nPayment with Credit Card for Laptop (Product ID 1):");
        System.out.println("Final price: $" + laptopFinalPrice);
        System.out.println("Payment Method: " + creditCardStrategy.paymentMethod());
        
        PricingStrategy payPalStrategy = new PayPalPricingStrategy();
        System.out.println("\nPayment with PayPal for Book (Product ID 2):");
        System.out.println("Final price: $" + bookFinalPrice);
        System.out.println("Payment Method: " + payPalStrategy.paymentMethod());

        // Remove the Laptop from the inventory
        inventory.removeProduct(laptop);
        System.out.println("\nInventory after removing the laptop:");
        inventory.displayInventory();
    }
    
}

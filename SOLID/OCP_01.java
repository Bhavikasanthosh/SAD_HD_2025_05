package SOLID;

import java.util.HashMap;
import java.util.Map;

// Step 1: Define interface for discount behavior
interface DiscountStrategy {
    double applyDiscount(double amount);
}

// Step 2: Implement different strategies
class RegularCustomer implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.1;
    }
}

class PremiumCustomer implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.2;
    }
}

// You can now easily add more types:
class GoldCustomer implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.3;
    }
}

// Step 3: Calculator delegates to strategy
public class OCP_01 {
    public static class DiscountCalculator {
        private Map<String, DiscountStrategy> strategyMap = new HashMap<>();

        public DiscountCalculator() {
            strategyMap.put("Regular", new RegularCustomer());
            strategyMap.put("Premium", new PremiumCustomer());
            strategyMap.put("Gold", new GoldCustomer()); // OCP: Added without modifying logic
        }

        public double calculateDiscount(String customerType, double amount) {
            DiscountStrategy strategy = strategyMap.get(customerType);
            return strategy != null ? strategy.applyDiscount(amount) : 0.0;
        }
    }

    public static void main(String[] args) {
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Regular Discount: " + calculator.calculateDiscount("Regular", 100.0));
        System.out.println("Premium Discount: " + calculator.calculateDiscount("Premium", 100.0));
        System.out.println("Gold Discount: " + calculator.calculateDiscount("Gold", 100.0));
    }
}

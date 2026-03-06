package Week_5.Assignment;
import java.time.LocalDateTime; 
import java.util.*; 
 
final class Product { 
    private final String productId; 
    private final String name; 
    private final String category; 
    private final String manufacturer; 
    private final double basePrice; 
    private final double weight; 
    private final String[] features; 
    private final Map<String, String> specifications; 
 
    private Product(String productId, String name, String category, String 
manufacturer, 
                   double basePrice, double weight, String[] features, 
                   Map<String, String> specifications) { 
        if (productId == null || name == null || category == null || 
manufacturer == null) { 
            throw new IllegalArgumentException("Product fields cannot be null"); 
        } 
        this.productId = productId; 
        this.name = name; 
        this.category = category; 
        this.manufacturer = manufacturer; 
        this.basePrice = basePrice; 
        this.weight = weight; 
        this.features = features != null ? Arrays.copyOf(features, 
features.length) : new String[0]; 
        this.specifications = specifications != null ? new 
HashMap<>(specifications) : new HashMap<>(); 
    } 
 
    // Factory methods 
    public static Product createElectronics(String productId, String name, 
double basePrice, double weight) { 
        return new Product(productId, name, "Electronics", "Generic Manufacturer", 
                basePrice, weight, new String[]{"1 year warranty"}, 
Map.of("Voltage", "220V")); 
    } 
 
    public static Product createClothing(String productId, String name, 
double basePrice, String size) { 
        return new Product(productId, name, "Clothing", "Fashion Brand", 
                basePrice, 0.5, new String[]{"Washable"}, Map.of("Size", 
size)); 
    } 
 
    public static Product createBooks(String productId, String name, 
double basePrice, String author) { 
        return new Product(productId, name, "Books", author, 
                basePrice, 1.0, new String[]{"Paperback"}, 
Map.of("Author", author)); 
    } 
 
    public String getProductId() { return productId; } 
    public String getName() { return name; } 
    public String getCategory() { return category; } 
    public String getManufacturer() { return manufacturer; } 
    public double getBasePrice() { return basePrice; } 
    public double getWeight() { return weight; } 
    public String[] getFeatures() { return Arrays.copyOf(features, 
features.length); } 
    public Map<String, String> getSpecifications() { return new 
HashMap<>(specifications); } 
 
    public final double calculateTax(String region) { 
        return switch (region.toUpperCase()) { 
            case "US" -> basePrice * 0.07; 
            case "EU" -> basePrice * 0.20; 
            default -> basePrice * 0.10; 
        }; 
    } 
 
    @Override 
    public String toString() { 
        return "Product{" + name + ", category=" + category + ", price=" + 
basePrice + "}"; 
    } 
} 
 
class Customer { 
    private final String customerId; 
    private final String email; 
    private String name; 
    private String phoneNumber; 
    private String preferredLanguage; 
    private final String accountCreationDate; 
 
    public Customer(String customerId, String email) { 
        this(customerId, email, "Guest", null, "EN", 
LocalDateTime.now().toString()); 
    } 
 
    public Customer(String customerId, String email, String name, 
                    String phoneNumber, String preferredLanguage, 
                    String accountCreationDate) { 
        this.customerId = customerId; 
        this.email = email; 
        this.name = name; 
        this.phoneNumber = phoneNumber; 
        this.preferredLanguage = preferredLanguage; 
        this.accountCreationDate = accountCreationDate; 
    } 
 
    public String getCustomerId() { return customerId; } 
    public String getEmail() { return email; } 
    public String getName() { return name; } 
    public void setName(String name) { this.name = name; } 
    public String getPhoneNumber() { return phoneNumber; } 
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = 
phoneNumber; } 
    public String getPreferredLanguage() { return preferredLanguage; } 
    public void setPreferredLanguage(String preferredLanguage) { 
this.preferredLanguage = preferredLanguage; } 
    public String getAccountCreationDate() { return accountCreationDate; } 
 
    // Package-private 
    String getCreditRating() { return "Good"; } 
 
    public String getPublicProfile() { 
        return "Customer: " + name + " (" + preferredLanguage + ")"; 
    } 
 
    @Override 
    public String toString() { 
        return "Customer{" + "id='" + customerId + "', email='" + email + 
"', name='" + name + "'}"; 
    } 
} 
 
class ShoppingCart { 
    private final String cartId; 
    private final String customerId; 
    private final List<Object> items; 
    private double totalAmount; 
    private int itemCount; 
 
    public ShoppingCart(String cartId, String customerId) { 
        this.cartId = cartId; 
        this.customerId = customerId; 
        this.items = new ArrayList<>(); 
        this.totalAmount = 0; 
        this.itemCount = 0; 
    } 
 
    public boolean addItem(Object product, int quantity) { 
        if (product instanceof Product && quantity > 0) { 
            items.add(product); 
            Product p = (Product) product; 
            totalAmount += (p.getBasePrice() * quantity); 
            itemCount += quantity; 
            return true; 
        } 
        return false; 
    } 
 
    private double calculateDiscount() { 
        return itemCount > 5 ? totalAmount * 0.05 : 0.0; 
    } 
 
    String getCartSummary() { 
        return "Cart{" + "items=" + itemCount + ", total=" + (totalAmount - calculateDiscount()) + "}"; 
    } 
} 
 
class Order { 
    private final String orderId; 
    private final LocalDateTime orderTime; 
 
    public Order(String orderId) { 
        this.orderId = orderId; 
        this.orderTime = LocalDateTime.now(); 
    } 
 
    public String getOrderId() { return orderId; } 
    public LocalDateTime getOrderTime() { return orderTime; } 
} 
 
class PaymentProcessor { 
    private final String processorId; 
    private final String securityKey; 
 
    public PaymentProcessor(String processorId, String securityKey) { 
        this.processorId = processorId; 
        this.securityKey = securityKey; 
    } 
 
    public boolean processPayment(double amount) { 
        return amount > 0; // Simple rule 
    } 
} 
 
class ShippingCalculator { 
    private final Map<String, Double> shippingRates; 
 
    public ShippingCalculator(Map<String, Double> shippingRates) { 
        this.shippingRates = new HashMap<>(shippingRates); 
    } 
 
    public double calculateShipping(String region, double weight) { 
        return shippingRates.getOrDefault(region, 10.0) * weight; 
    } 
} 
 
public final class ECommerceSystem { 
    private static final Map<String, Object> productCatalog = new 
HashMap<>(); 
 
    public static boolean processOrder(Object order, Object customer) { 
        return (order instanceof Order) && (customer instanceof Customer); 
    } 
 
    public static void addProductToCatalog(Product product) { 
        productCatalog.put(product.getProductId(), product); 
    } 
 
    public static void showCatalog() { 
        System.out.println("Catalog: " + productCatalog.values()); 
    } 
    public static void main(String[] args) { 
        Product laptop = Product.createElectronics("P001", "Laptop", 1000.0, 2.5); 
        Product tshirt = Product.createClothing("P002", "T-Shirt", 20.0, "M"); 
        Product novel = Product.createBooks("P003", "Java Programming", 40.0, "John Doe"); 
        addProductToCatalog(laptop); 
        addProductToCatalog(tshirt); 
        addProductToCatalog(novel); 
        showCatalog(); 
        Customer cust = new Customer("C001", "john@example.com", "John Doe", "12345", "EN", "2022-01-01"); 
        ShoppingCart cart = new ShoppingCart("CART001", cust.getCustomerId()); 
        cart.addItem(laptop, 1); 
        cart.addItem(tshirt, 3); 
        cart.addItem(novel, 2); 
        System.out.println(cart.getCartSummary()); 
        Order order = new Order("O001"); 
        PaymentProcessor processor = new PaymentProcessor("PAY001", "SEC123"); 
        ShippingCalculator shipping = new ShippingCalculator(Map.of("US", 5.0, "EU", 8.0)); 
        if (processOrder(order, cust) && processor.processPayment(1100)) { double shippingCost = shipping.calculateShipping("US", 
        laptop.getWeight() + novel.getWeight()); 
        System.out.println("Order " + order.getOrderId() + " processed for customer " + cust.getName()); 
        System.out.println("Shipping cost: " + shippingCost); 
        } 
    } 
} 
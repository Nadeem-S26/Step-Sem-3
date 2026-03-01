package Week_3.Assignment;
import java.util.*;
class Product {
    private String productId;
    private String productName;
    private double price;
    private String category;
    private int stockQuantity;
    static int totalProducts = 0;
    static String[] categories = {"Electronics", "Clothing", "Groceries", "Books", "Toys"};
    public Product(String productId, String productName, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        totalProducts++;
    }
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }
    public void reduceStock(int qty) { stockQuantity -= qty; }
    public void increaseStock(int qty) { stockQuantity += qty; }
    public static Product findProductById(Product[] products, String productId) {
        for (Product p : products) {
            if (p != null && p.getProductId().equalsIgnoreCase(productId)) {
                return p;
            }
        }
        return null;
    }
    public static void getProductsByCategory(Product[] products, String category) {
        System.out.println("Products in category: " + category);
        for (Product p : products) {
            if (p != null && p.getCategory().equalsIgnoreCase(category)) {
                System.out.println(p.getProductId() + " - " + p.getProductName() + " - Rs. " + p.getPrice() + " (Stock: " + p.getStockQuantity() + ")");
            }
        }
    }
    public void displayProduct() {
        System.out.println(productId + " - " + productName + " - Rs. " + price + " - " + category + " (Stock: " + stockQuantity + ")");
    }
}
class ShoppingCart {
    private String cartId;
    private String customerName;
    private Product[] products;
    private int[] quantities;
    private double cartTotal;
    private int itemCount;
    public ShoppingCart(String cartId, String customerName) {
        this.cartId = cartId;
        this.customerName = customerName;
        this.products = new Product[50];
        this.quantities = new int[50];
        this.cartTotal = 0.0;
        this.itemCount = 0;
    }
    public void addProduct(Product product, int quantity) {
        if (product.getStockQuantity() >= quantity) {
            products[itemCount] = product;
            quantities[itemCount] = quantity;
            product.reduceStock(quantity);
            itemCount++;
            calculateTotal();
            System.out.println(quantity + " x " + product.getProductName() + " added to cart.");
        } else {
            System.out.println("Not enough stock for " + product.getProductName());
        }
    }
    public void removeProduct(String productId) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getProductId().equalsIgnoreCase(productId)) {
                products[i].increaseStock(quantities[i]);
                System.out.println(products[i].getProductName() + " removed from cart.");
                for (int j = i; j < itemCount - 1; j++) {
                    products[j] = products[j + 1];
                    quantities[j] = quantities[j + 1];
                }
                products[itemCount - 1] = null;
                quantities[itemCount - 1] = 0;
                itemCount--;
                calculateTotal();
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }
    public void calculateTotal() {
        cartTotal = 0.0;
        for (int i = 0; i < itemCount; i++) {
            cartTotal += products[i].getPrice() * quantities[i];
        }
    }
    public void displayCart() {
        System.out.println("\nCart for " + customerName + " (ID: " + cartId + ")");
        if (itemCount == 0) {
            System.out.println("Cart is empty.");
        } else {
            for (int i = 0; i < itemCount; i++) {
                System.out.println(products[i].getProductName() + " x " + quantities[i] + " = Rs. " + (products[i].getPrice() * quantities[i]));
            }
            System.out.println("Total: Rs. " + cartTotal);
        }
    }
    public void checkout() {
        if (itemCount == 0) {
            System.out.println("Cart is empty. Cannot checkout.");
        } else {
            displayCart();
            System.out.println("Checkout complete. Thank you for shopping!");
            itemCount = 0;
            cartTotal = 0.0;
        }
    }
}
public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = {
            new Product("P001", "Laptop", 55000, "Electronics", 5),
            new Product("P002", "Smartphone", 25000, "Electronics", 10),
            new Product("P003", "T-Shirt", 500, "Clothing", 20),
            new Product("P004", "Jeans", 1200, "Clothing", 15),
            new Product("P005", "Rice Bag", 800, "Groceries", 50),
            new Product("P006", "Cooking Oil", 150, "Groceries", 30),
            new Product("P007", "Novel Book", 300, "Books", 25),
            new Product("P008", "Children Story Book", 200, "Books", 40),
            new Product("P009", "Toy Car", 350, "Toys", 35),
            new Product("P010", "Doll", 450, "Toys", 25)
        };
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        ShoppingCart cart = new ShoppingCart("CART001", name);
        int choice;
        do {
            System.out.println("\n--- Online Shopping Menu ---");
            System.out.println("1. View All Products");
            System.out.println("2. View Products by Category");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    for (Product p : products) {
                        p.displayProduct();
                    }
                    break;
                case 2:
                    System.out.print("Enter category: ");
                    String cat = sc.nextLine();
                    Product.getProductsByCategory(products, cat);
                    break;
                case 3:
                    System.out.print("Enter product ID to add: ");
                    String pid = sc.nextLine();
                    Product prod = Product.findProductById(products, pid);
                    if (prod != null) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        cart.addProduct(prod, qty);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter product ID to remove: ");
                    String rid = sc.nextLine();
                    cart.removeProduct(rid);
                    break;
                case 5:
                    cart.displayCart();
                    break;
                case 6:
                    cart.checkout();
                    break;
                case 0:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}
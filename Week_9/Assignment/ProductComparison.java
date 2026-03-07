package Week_9.Assignment;
class Product {
    private int productId;
    private String productName;
    public Product(int productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // same reference
        if (obj == null || getClass() != obj.getClass()) return false;

        Product other = (Product) obj;
        return this.productId == other.productId;
    }
    @Override
    public String toString() {
        return "Product{id=" + productId + ", name='" + productName + "'}";
    }
}
public class ProductComparison {
    public static void main(String[] args) {
        Product p1 = new Product(1001, "Laptop");
        Product p2 = new Product(1001, "Notebook");
        Product p3 = p1; 
        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p1 == p3: " + (p1 == p3));
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1.equals(p3): " + p1.equals(p3));
    }
}

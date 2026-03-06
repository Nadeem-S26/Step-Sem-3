package Week_7.Assignment;
public class HotelBooking {
    void calculatePrice(String roomType, int nights) {
        int rate = getRate(roomType);
        int total = rate * nights;
        System.out.println("Standard Booking:");
        System.out.println("Room: " + roomType + ", Nights: " + nights);
        System.out.println("Total: " + total);
    }
    void calculatePrice(String roomType, int nights, double seasonalMultiplier) {
        int rate = getRate(roomType);
        double total = rate * nights * seasonalMultiplier;
        System.out.println("Seasonal Booking:");
        System.out.println("Room: " + roomType + ", Nights: " + nights + ", Multiplier: " + seasonalMultiplier);
        System.out.println("Total: " + total);
    }
    void calculatePrice(String roomType, int nights, double discount, boolean mealPackage) {
        int rate = getRate(roomType);
        double base = rate * nights;
        double discounted = base - (base * discount);
        double mealCost = mealPackage ? 500 * nights : 0;
        double total = discounted + mealCost;
        System.out.println("Corporate Booking:");
        System.out.println("Room: " + roomType + ", Nights: " + nights + ", Discount: " + (discount * 100) + "%");
        System.out.println("Meal Package: " + (mealPackage ? "Included" : "Not Included"));
        System.out.println("Total: " + total);
    }
    void calculatePrice(String roomType, int nights, int guestCount, int decorationFee, boolean catering) {
        int rate = getRate(roomType);
        int base = rate * nights;
        int cateringCost = catering ? 1000 * guestCount : 0;
        int total = base + decorationFee + cateringCost;
        System.out.println("Wedding Package:");
        System.out.println("Room: " + roomType + ", Nights: " + nights + ", Guests: " + guestCount);
        System.out.println("Decoration Fee: ₹" + decorationFee + ", Catering: " + (catering ? "Included" : "Not Included"));
        System.out.println("Total: " + total);
    }
    int getRate(String roomType) {
        if (roomType.equalsIgnoreCase("Deluxe")) return 3000;
        if (roomType.equalsIgnoreCase("Suite")) return 5000;
        return 2000;
    }
    public static void main(String[] args) {
        HotelBooking hb = new HotelBooking();
        hb.calculatePrice("Deluxe", 3);
        System.out.println();
        hb.calculatePrice("Suite", 2, 1.2);
        System.out.println();
        hb.calculatePrice("Deluxe", 4, 0.15, true);
        System.out.println();
        hb.calculatePrice("Suite", 2, 50, 10000, true);
    }
}
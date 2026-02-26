package Week_1.Assignment;

import java.util.Scanner;
public class Calendar {
    // Array of month names
    static String[] monthNames = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };
    // Array of days in each month
    static int[] monthDays = {
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };
    // Method to check if a year is a leap year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    // Method to get number of days in a month
    public static int getDaysInMonth(int month, int year) {
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return monthDays[month - 1];
    }
    // Method to get the first day of the month using Gregorian calendar algorithm
    public static int getFirstDayOfMonth(int month, int year) {
        int d = 1; // First day of the month
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0; // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    }
    // Method to display the calendar
    public static void displayCalendar(int month, int year) {
        String monthName = monthNames[month - 1];
        int days = getDaysInMonth(month, year);
        int startDay = getFirstDayOfMonth(month, year);
        System.out.printf("\n     %s %d\n", monthName, year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        // Indentation for the first day
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }
        // Print days of the month
        for (int day = 1; day <= days; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0) {
                System.out.println(); // Move to next line after Saturday
            }
        }
        System.out.println(); // Final newline
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        displayCalendar(month, year);
        sc.close();
    }
}

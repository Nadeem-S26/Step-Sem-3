package Week_2.Lab;
import java.util.Scanner;
public class EmailAnalysis {
    public static boolean isValidEmail(String email) {
        int atIndex = email.indexOf('@');
        int lastAtIndex = email.lastIndexOf('@');
        if (atIndex == -1 || atIndex != lastAtIndex) return false;
        int dotIndex = email.indexOf('.', atIndex);
        if (dotIndex == -1) return false;
        String username = email.substring(0, atIndex);
        String domain = email.substring(atIndex + 1);
        return !username.isEmpty() && !domain.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of email addresses: ");
        int count = sc.nextInt();
        sc.nextLine();
        String[] emails = new String[count];
        String[] usernames = new String[count];
        String[] domains = new String[count];
        String[] domainNames = new String[count];
        String[] extensions = new String[count];
        boolean[] validity = new boolean[count];
        int validCount = 0;
        int totalUsernameLength = 0;
        String mostCommonDomain = "";
        int maxDomainCount = 0;
        String[] domainTracker = new String[count];
        int[] domainFrequency = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter email #" + (i + 1) + ": ");
            emails[i] = sc.nextLine();
            validity[i] = isValidEmail(emails[i]);
            if (validity[i]) {
                int atIndex = emails[i].indexOf('@');
                usernames[i] = emails[i].substring(0, atIndex);
                domains[i] = emails[i].substring(atIndex + 1);
                int dotIndex = domains[i].lastIndexOf('.');
                domainNames[i] = domains[i].substring(0, dotIndex);
                extensions[i] = domains[i].substring(dotIndex + 1);
                validCount++;
                totalUsernameLength += usernames[i].length();
                boolean found = false;
                for (int j = 0; j < i; j++) {
                    if (domains[i].equals(domainTracker[j])) {
                        domainFrequency[j]++;
                        found = true;
                        if (domainFrequency[j] > maxDomainCount) {
                            maxDomainCount = domainFrequency[j];
                            mostCommonDomain = domainTracker[j];
                        }
                        break;
                    }
                }
                if (!found) {
                    domainTracker[i] = domains[i];
                    domainFrequency[i] = 1;
                    if (domainFrequency[i] > maxDomainCount) {
                        maxDomainCount = domainFrequency[i];
                        mostCommonDomain = domainTracker[i];
                    }
                }
            } else {
                usernames[i] = domains[i] = domainNames[i] = extensions[i] = "-";
            }
        }
        System.out.println("\nEmail Analysis Table:");
        System.out.println("| Email                     | Username | Domain         | Domain Name | Extension | Valid/Invalid|");
        for (int i = 0; i < count; i++) {
            System.out.printf("| %-25s | %-8s | %-14s | %-11s | %-9s | %-12s |\n",
                    emails[i], usernames[i], domains[i], domainNames[i], extensions[i],
                    validity[i] ? "Valid" : "Invalid");
        }
        int invalidCount = count - validCount;
        double avgUsernameLength = validCount > 0 ? (double) totalUsernameLength / validCount : 0;
        System.out.println("\nEmail Statistics:");
        System.out.println("Total Valid Emails: " + validCount);
        System.out.println("Total Invalid Emails: " + invalidCount);
        System.out.println("Most Common Domain: " + mostCommonDomain);
        System.out.printf("Average Username Length: %.2f\n", avgUsernameLength);
        sc.close();
    }
}
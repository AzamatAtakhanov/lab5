package ScreenTimeTracker;

import java.util.Scanner;

public class ScreenTimeTracker {
    private static final Scanner sc = new Scanner(System.in);
    private static int totalTime;
    private static int sessions;
    private static final Category[] categories = new Category[]{
            new Category("Social Media", Type.Entertainment),
            new Category("Gaming", Type.Entertainment),
            new Category("Studying", Type.Productive),
            new Category("Video or streaming", Type.Entertainment),
    };
    public static void main(String[] args) {
        boolean keepGoing = true;
        while (keepGoing){
            // Main menu
            displayMainMenu();

            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            if (1 <= choice && choice <= categories.length) {
                addScreenTime(categories[choice - 1]);
            } else if (choice == categories.length + 1) {
                viewStatistics();
            } else if (choice == categories.length + 2) {
                System.out.println("Screen-time tracker closing...");
                keepGoing = false;
            } else{
                System.out.println("Invalid option. Choose a number between 1 and " + (categories.length + 2));
                enterToContinue();
            }
        }
    }

    private static void addScreenTime(Category category) {
        System.out.print("Enter " + category.getTitle().toLowerCase() + " minutes: ");
        int minutes = sc.nextInt();
        if (minutes <= 0){
            System.out.println("Invalid time. Minutes must be greater than 0.");
            enterToContinue();
            addScreenTime(category);
        }
        else{
            category.addTime(minutes);
            totalTime += minutes;
            sessions++;
            System.out.println("Time added successfully!");
            enterToContinue();
        }
    }
    private static void viewStatistics() {
        int entertainmentTime = 0;
        int productiveTime = 0;
        System.out.println("===== TODAY'S SCREEN TIME =====");

        for (Category category : categories) {
            System.out.println(category.getTitle() + ": " +  category.getTotalTime() + " minutes");
            if (category.getType() == Type.Entertainment)
                entertainmentTime += category.getTotalTime();
            else
                productiveTime += category.getTotalTime();
        }

        System.out.println("Total screen time: " + totalTime + " minutes");
        System.out.println("Recorded sessions: " + sessions);

        if (entertainmentTime > productiveTime)
            System.out.println("Entertainment screen time is greater than study time.");
        else if (entertainmentTime < productiveTime)
            System.out.println("Study screen time is greater than entertainment screen time. Good balance!");
        else
            System.out.println("Study and entertainment screen time are equal.");
        enterToContinue();
    }
    private static void displayMainMenu() {
        System.out.println("===== SCREEN TIME TRACKER =====");
        if (totalTime >= 240)
            System.out.print("High");
        else if (totalTime >= 120)
            System.out.print("Moderate");
        else
            System.out.print("Low");
        System.out.println(" screen time");
        for(int i = 0; i < categories.length; i++)
            System.out.printf("%d. Add %s time\n", i + 1, categories[i].getTitle().toLowerCase());
        System.out.println(categories.length + 1 + ". View statistics");
        System.out.println(categories.length + 2 + ". Exit");
    }
    private static void enterToContinue() {
        System.out.print("Enter to continue...");
        sc.nextLine();
        sc.nextLine();
    }
}

package StudyTracker;

import java.util.Scanner;

public class StudyTracker {
    // Variables
    private final static Scanner sc = new Scanner(System.in);
    private final static Subject[] subjects = new Subject[] {
            new Subject("Programming"),
            new Subject("Mathematics"),
            new Subject("English"),
            new Subject("Other"),
    };
    private static int studySessions;
    private static int totalStudyTime;
    private static int weeklyGoal = 600;

    public static void main(String[] args) {
        // Main program
        boolean keepRunning = true;
        while (keepRunning) {
            // Menu
            System.out.println("===== STUDY TRACKER =====");
            System.out.println("1. Add study session");
            System.out.println("2. View statistics");
            System.out.println("3. Check weekly goal");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            // Options
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    addStudySession();
                    break;
                case 2:
                    viewStatistics();
                    break;
                case 3:
                    checkWeeklyGoal();
                    break;
                case 4:
                    keepRunning = false;
                    System.out.println("Study tracker closed. Keep up the good work!");
                    break;
                default:
                    System.out.println("Invalid option. Choose between 1 and 4.");
                    enterToContinue();
                    break;
            }
        }
    }
    public static void addStudySession() {
        System.out.println("Choose subject: ");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + ". " + subjects[i].getName());
        }
        System.out.print("Choose an option: ");
        int option = sc.nextInt();

        if (1 <= option && option <= subjects.length) {
            System.out.print("Study time in minutes: ");
            int time = sc.nextInt();
            if (time <= 0) {
                System.out.println("Invalid study time. Time must be greater than 0.");
                enterToContinue();
                addStudySession();
            }
            else{
                totalStudyTime += time;
                studySessions++;
                subjects[option - 1].addStudyTime(time);
                System.out.println("Study session added!");
                System.out.println("Current total study time: " + totalStudyTime);
                enterToContinue();
            }
        } else {
            System.out.println("Invalid option. Choose between 1 and " + subjects.length + ".");
            enterToContinue();
            addStudySession();
        }
    }
    public static void viewStatistics() {
        System.out.println("===== WEEKLY STATISTICS =====");

        System.out.println("Study sessions: " + studySessions);
        System.out.println("Total study time: " + totalStudyTime + " minutes");

        for (Subject subject : subjects) {
            System.out.println(subject.getName() + ": " + subject.getStudyTime() + " minutes");
        }
        enterToContinue();
    }
    public static void checkWeeklyGoal() {
        if (totalStudyTime >= weeklyGoal) {
            System.out.println("Weekly goal achieved! 🎉🎉🎉");
        }
        else{
            System.out.println("Weekly goal: " + weeklyGoal +  " minutes");
            System.out.println("You studied: " + totalStudyTime + " minutes");
            System.out.println("Remaining: " + (weeklyGoal - totalStudyTime) + " minutes");
        }
        enterToContinue();
    }
    public static void enterToContinue() {
        sc.nextLine();
        System.out.print("Press enter to continue...");
        sc.nextLine();
    }
}

package SemesterGradeTracker;

import java.util.Scanner;

public class GradeTracker {
    private static final Scanner sc = new Scanner(System.in);
    private static float totalAssignmentPoints = 0;
    private static float totalExamPoints = 0;
    private static int assignmentCount = 0;
    private static int examCount = 0;
    public static void main(String[] args) {
        boolean keepGoing = true;
        while (keepGoing) {
            // Displaying main menu
            System.out.println("===== SEMESTER GRADE TRACKER =====");
            System.out.println("1. Add assignment result");
            System.out.println("2. Add exam result");
            System.out.println("3. View current grade");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            // Option checker
            switch (choice) {
                case 1:
                    addAssignmentResult();
                    break;
                case 2:
                    addExamResult();
                    break;
                case 3:
                    viewCurrentGrade();
                    break;
                case 4:
                    // Exiting a program by breaking out of the loop
                    System.out.println("Thank you for using this program.");
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Invalid choice. Choose between 1 and 4");
                    enterToContinue();
            }
        }
        sc.close();
    }
    private static void addAssignmentResult() {
        System.out.print("Enter assignment score: ");
        int score = sc.nextInt();
        // Check if user entered score correctly between 0 and 100 inclusive
        if (0 <= score && score <= 100) {
            totalAssignmentPoints += score;
            assignmentCount++;
            System.out.println("Assignment score added");
            enterToContinue();
        }
        else {
            System.out.println("Invalid score. Enter a value from 0 to 100.");
            enterToContinue();
            addAssignmentResult();
        }
    }
    private static void addExamResult() {
        System.out.print("Enter exam score: ");
        int score = sc.nextInt();
        if (0 <= score && score <= 100) {
            totalExamPoints += score;
            examCount++;
            System.out.println("Exam score added");
            enterToContinue();
        } else{
            System.out.println("Invalid score. Enter a value from 0 to 100.");
            enterToContinue();
            addExamResult();
        }
    }
    private static void viewCurrentGrade() {
        float assignmentAverage = assignmentCount != 0 ? totalAssignmentPoints / assignmentCount : 0;
        float examAverage =  examCount != 0 ? totalExamPoints / examCount : 0;
        float overallAverage;

        if (assignmentCount == 0 && examCount == 0) {
            System.out.println("No results available yet.");
            enterToContinue();
        }
        else{
            System.out.println("===== CURRENT RESULTS =====");
            // Printing assignment results if they are present
            if (assignmentCount != 0) {
                System.out.println("Assignments completed: " + assignmentCount);
                System.out.println("Assignment average: " + assignmentAverage);
            }
            // Printing exam results if they are present
            if (examCount != 0) {
                System.out.println("Exams completed: " + examCount);
                System.out.println("Exam average: " + examAverage);
            }
            // Determining overall average: if both assignment and exam counts are nonzero
            // use the formula, otherwise overall average = one of them
            if (assignmentCount != 0 &&  examCount != 0)
                overallAverage = assignmentAverage * 0.5f +  examAverage * 0.5f;
            else
                // One of them is already zero, so it is either overall average = assignment average, or exam average
                overallAverage = assignmentAverage + examAverage;
            // Finding out if student has passed the overall average mark of 60
            // If overall average >= 60 then status = "Passed", otherwise "Failed"
            String status = overallAverage >= 60 ? "Passed" : "Failed";
            // Assigning grade by overall average
            char grade = grade(overallAverage);
            // Printing final results
            System.out.println("Overall average: " + overallAverage);
            System.out.println("Grade: " + grade);
            System.out.println("Status: " + status);
            enterToContinue();
        }
    }
    private static char grade(float average) {
        // Returning mark according to the average
        if (average >= 90)
            return 'A';
        else if (average >= 80)
            return 'B';
        else if (average >= 70)
            return 'C';
        else if (average >= 60)
            return 'D';
        else
            return 'F';
    }
    private static void enterToContinue() {
        System.out.print("Enter to continue...");
        sc.nextLine();
        sc.nextLine();
    }
}

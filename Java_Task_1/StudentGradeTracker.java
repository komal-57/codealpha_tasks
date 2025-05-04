import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    static ArrayList<String> studentNames = new ArrayList<>();
    static ArrayList<Double> studentGrades = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewAllStudents();
                case 3 -> calculateAverage();
                case 4 -> findHighestGrade();
                case 5 -> findLowestGrade();
                case 6 -> System.out.println("Exiting program. Goodbye!");
                default -> System.out.println("Invalid choice! Please select from 1 to 6.");
            }
        } while (choice != 6);
    }

    // Function to print menu
    static void printMenu() {
        System.out.println("\n=== Student Grade Tracker Menu ===");
        System.out.println("1. Add Student and Grade");
        System.out.println("2. View All Students and Grades");
        System.out.println("3. Calculate Average Grade");
        System.out.println("4. Find Highest Grade");
        System.out.println("5. Find Lowest Grade");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }

    // Function to add a student and grade
    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter grade for " + name + ": ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        studentNames.add(name);
        studentGrades.add(grade);
        System.out.println("Student added successfully.");
    }

    // Function to view all students and grades
    static void viewAllStudents() {
        System.out.println("\n-- All Students and Grades --");
        if (studentNames.isEmpty()) {
            System.out.println("No student data available.");
        } else {
            for (int i = 0; i < studentNames.size(); i++) {
                System.out.println(studentNames.get(i) + ": " + studentGrades.get(i));
            }
        }
    }

    // Function to calculate average grade
    static void calculateAverage() {
        if (studentGrades.isEmpty()) {
            System.out.println("No grades available to calculate average.");
        } else {
            double sum = 0;
            for (double grade : studentGrades) {
                sum += grade;
            }
            double average = sum / studentGrades.size();
            System.out.printf("Average grade: %.2f\n", average);
        }
    }

    // Function to find the highest grade
    static void findHighestGrade() {
        if (studentGrades.isEmpty()) {
            System.out.println("No grades available to find highest.");
        } else {
            double highest = studentGrades.get(0);
            String topStudent = studentNames.get(0);
            for (int i = 1; i < studentGrades.size(); i++) {
                if (studentGrades.get(i) > highest) {
                    highest = studentGrades.get(i);
                    topStudent = studentNames.get(i);
                }
            }
            System.out.printf("Highest grade: %.2f (%s)\n", highest, topStudent);
        }
    }

    // Function to find the lowest grade
    static void findLowestGrade() {
        if (studentGrades.isEmpty()) {
            System.out.println("No grades available to find lowest.");
        } else {
            double lowest = studentGrades.get(0);
            String lowStudent = studentNames.get(0);
            for (int i = 1; i < studentGrades.size(); i++) {
                if (studentGrades.get(i) < lowest) {
                    lowest = studentGrades.get(i);
                    lowStudent = studentNames.get(i);
                }
            }
            System.out.printf("Lowest grade: %.2f (%s)\n", lowest, lowStudent);
        }
    }
}


// Output:-----------------------------------------------------------------------------------------------------------------------------------
// === Student Grade Tracker Menu ===
// 1. Add Student and Grade
// 2. View All Students and Grades
// 3. Calculate Average Grade
// 4. Find Highest Grade
// 5. Find Lowest Grade
// 6. Exit
// Enter your choice (1-6): 1
// Enter student name: komal
// Enter grade for komal: 75
// Student added successfully.

// === Student Grade Tracker Menu ===
// 1. Add Student and Grade
// 2. View All Students and Grades
// 3. Calculate Average Grade
// 4. Find Highest Grade
// 5. Find Lowest Grade
// 6. Exit
// Enter your choice (1-6): 2

// -- All Students and Grades --
// komal: 75.0
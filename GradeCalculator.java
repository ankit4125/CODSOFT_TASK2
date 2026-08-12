import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();

            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid marks! Enter marks between 0 and 100: ");
                marks[i] = sc.nextInt();
            }

            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / numSubjects;

        String grade = calculateGrade(averagePercentage);

        System.out.println("\n----- Result -----");
        System.out.println("Total Marks       : " + totalMarks + " out of " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade             : " + grade);

        sc.close();
    }

    public static String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else if (percentage >= 40) {
            return "E";
        } else {
            return "F (Fail)";
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class GradeCalculator {

    static String getGrade(double avg) {
        if (avg >= 90) return "O";
        else if (avg >= 80) return "A+";
        else if (avg >= 70) return "A";
        else if (avg >= 60) return "B+";
        else if (avg >= 50) return "B";
        else return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> averages = new ArrayList<>();
        ArrayList<String> grades = new ArrayList<>();

        System.out.print("How many students? ");
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = sc.nextLine().trim();

            System.out.print("How many subjects? ");
            int s = Integer.parseInt(sc.nextLine().trim());

            double total = 0;
            for (int j = 0; j < s; j++) {
                System.out.print("  Subject " + (j + 1) + " marks (out of 100): ");
                double marks = Double.parseDouble(sc.nextLine().trim());
                total += marks;
            }

            double avg = total / s;
            String grade = getGrade(avg);
            names.add(name);
            averages.add(avg);
            grades.add(grade);
        }

        System.out.println("\n========== RESULT ==========");
        System.out.printf("%-20s %-10s %-10s%n", "Name", "Average", "Grade");
        System.out.println("------------------------------------");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%-20s %-10.2f %-10s%n", names.get(i), averages.get(i), grades.get(i));
        }
        System.out.println("============================");
        sc.close();
    }
}
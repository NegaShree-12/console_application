package StudentManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        int studentid = scan.nextInt();

        scan.nextLine(); // consume newline

        System.out.print("Enter Student Name: ");
        String studentname = scan.nextLine();

        System.out.print("Enter number of subjects: ");
        int count = scan.nextInt();

        Student student = new Student(studentid, studentname, count);

        student.inputMark(scan);
        student.totalMark();
        student.avgMark();
        student.calculateGrade();
        student.display();

        // scan.close(); // ❌ keep commented while testing
    }
}

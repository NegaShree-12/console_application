package StudentManagement;
import java.util.Scanner;

public class Student {
    int studentid;
    String studentname;
    int[] marks;
    int total;
    double avg;
    char grade;
    public Student(int studentid,String studentname,int count)
    {
        this.studentid=studentid;
        this.studentname=studentname;
        this.marks=new int[count];
    }

    public void inputMark(Scanner scan)
    {
        for(int i=0;i<marks.length;i++)
        {
            marks[i]=scan.nextInt();
        }
    }

    public void totalMark()
    {
        this.total=0;
        for(int i=0;i<marks.length;i++)
        {
            this.total+=marks[i];
        }
    }

    public void avgMark()
    {
        avg=(double)total/marks.length;
    }

    public void calculateGrade()
    {
        if(avg>=90)
        {
            grade='A';
        }
        else if(avg>=80 && avg<90)
        {
            grade='B';
        }
        else if(avg>=70 && avg<80)
        {
            grade='C';
        }
        else if(avg>=60 && avg<70)
        {
            grade='D';
        }
        else
        {
            grade='F';
        }
    }

    public void display()
    {
        System.out.println("Student details:");
        System.out.println(studentid);
        System.out.println(studentname);
        System.out.println(total);
        System.out.println(avg);
        System.out.println(grade);
    }
}

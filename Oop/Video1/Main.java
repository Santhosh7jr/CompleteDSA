package Oop.Video1;
import java.util.*;

class Student{
    int roll_no;
    String name;
    double marks;
    final String city="mumbai";

    public Student(){
        this(1,"kunal",99.9);
    }

    public Student(int roll_no,String name,double marks){
        this.roll_no=roll_no;
        this.name=name;
        this.marks=marks;
    }

    public Student(Student object){
        this.roll_no=object.roll_no;
        this.name=object.name;
        this.marks=object.marks;
    }
}

public class Main {

    public static void main(String[] args) {

        Student student=new Student(1,"kunal",99.9);
        System.out.println("roll number: "+student.roll_no);
        System.out.println("name: "+student.name);
        System.out.println("marks: "+student.marks);
        System.out.println("city: "+student.city);

//        student.city="bengaluru";

    }

}

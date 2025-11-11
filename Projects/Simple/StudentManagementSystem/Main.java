package Projects.Simple.StudentManagementSystem;
import java.util.*;
import java.util.regex.*;

class Student {

    private String name;
    private String register_no;
    private double cgpa;

    public Student(String name, String register_no, double cgpa) {
        this.name = name;
        this.register_no = register_no;
        this.cgpa = cgpa;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegister_no() {
        return this.register_no;
    }

    public void setRegister_no(String register_no) {
        this.register_no = register_no;
    }

    public double getCgpa() {
        return this.cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

}

public class Main {

    private List<Student> dataSet;
    private HashSet<String> usnSet;

    public Main() {
        this.dataSet = new ArrayList<>();
        this.usnSet = new HashSet<>();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        int choice = 0;

        do {

            System.out.println("Enter 1 - > Student Registration \n2 -> Student Data Modification\n 3-> Student Data Deletion \n4 -> Get Student Details \nAny Number -> Exit: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 :
                    System.out.println("Enter Student Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter Student USN: ");
                    String usn = scanner.nextLine();

                    System.out.println("Enter Student CGPA: ");
                    double cgpa = scanner.nextDouble();

                    main.registerStudent(name, usn, cgpa);
                    System.out.println();
                    break;

                case 2 :
                    System.out.println("Enter Student oldName: ");
                    String oldName = scanner.nextLine();

                    System.out.println("Enter Student oldUSN: ");
                    String oldUsn = scanner.nextLine();

                    System.out.println("Enter Student oldCGPA: ");
                    double oldCgpa = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter Student newName: ");
                    String newName = scanner.nextLine();

                    System.out.println("Enter Student newUSN: ");
                    String newUsn = scanner.nextLine();

                    System.out.println("Enter Student newCGPA: ");
                    double newCgpa = scanner.nextDouble();

                    main.modifyStudentDetails(oldName, newName, oldUsn, newUsn, oldCgpa, newCgpa);
                    System.out.println();
                    break;

                case 3 :
                    System.out.println("Enter Student USN: ");
                    String studUsn = scanner.nextLine();
                    main.removeStudentDetails(studUsn);
                    System.out.println();
                    break;

                case 4 :
                    System.out.println("Enter Student USN: ");
                    String stdUsn = scanner.nextLine();
                    main.searchStudent(stdUsn);
                    System.out.println();
                    break;

                default:
                    System.out.println("Ending Student Registration");
                    break;

            }

        } while (choice > 0 && choice < 5);

    }

    public boolean registerStudent(String name, String usn, double cgpa) {

        String regex = "^\\d[A-Z]{2}\\d{2}[A-Z]{2}\\d{3}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(usn);

        if (!matcher.matches() || this.usnSet.contains(usn)) {
            System.out.println("Invalid USN. Registration Failed");
            return false;
        }

        if (cgpa < 0 || cgpa > 10) {
            System.out.println("Invalid CGPA. Registration Failed");
            return false;
        }

        this.dataSet.add(new Student(name, usn, cgpa));
        this.usnSet.add(usn);

        System.out.println("Registration Successful");

        return true;

    }

    public boolean modifyStudentDetails(String oldName, String newName, String oldUsn, String newUsn, double oldCgpa, double newCgpa) {

        Student oldStudent = null;

        for (Student s : dataSet) {
            if (s.getRegister_no().equals(oldUsn)) {
                oldStudent = s;
                break;
            }
        }

        if (oldStudent == null) {
            System.out.println("Old USN not found. Modification failed.");
            return false;
        }

        String regex = "^\\d[A-Z]{2}\\d{2}[A-Z]{2}\\d{3}$";
        if (!newUsn.matches(regex)) {
            System.out.println("Invalid new USN format.");
            return false;
        }

        oldStudent.setName(newName);
        oldStudent.setRegister_no(newUsn);
        oldStudent.setCgpa(newCgpa);

        usnSet.remove(oldUsn);
        usnSet.add(newUsn);

        System.out.println("Modification Successful");

        return true;

    }

    public void removeStudentDetails(String usn) {

        if (!usnSet.contains(usn)) {
            System.out.println("USN not found. Cannot delete.");
            return;
        }

        usnSet.remove(usn);
        dataSet.removeIf(s -> s.getRegister_no().equals(usn));

        System.out.println("Student removed successfully.");
    }

    public boolean searchStudent(String usn) {

        if (!this.usnSet.contains(usn)) {
            System.out.println("Student Details Not Found!");
            return false;
        }

        getStudentData(usn);

        return true;
    }

    private void getStudentData(String usn) {

        for (Student student : this.dataSet) {
            if (student.getRegister_no().equals(usn)) {
                displayData(student.getName(), student.getRegister_no(), student.getCgpa());
                return;
            }
        }

    }

    private static void displayData(String name, String usn, double cgpa) {

        for (int i = 1; i <= 5; i++) {

            if (i % 2 == 1) {

                System.out.print("+");

                for (int k = 0; k < name.length() + 2; k++) {
                    System.out.print("-");
                }

                System.out.print("+");

                for (int k = 0; k <= 12; k++) {
                    System.out.print("-");
                }

                System.out.print("+");

                for (int k = 0; k < 6; k++) {
                    System.out.print("-");
                }

                System.out.print("+");

            } else {

                if (i == 2) {

                    System.out.print("|");

                    int distance = (name.length() - 4) / 2;

                    for (int k = 0; k <= distance; k++) {
                        System.out.print(" ");
                    }

                    System.out.print("name");

                    for (int k = 0; k <= distance + ((name.length() % 2 == 1) ? 1 : 0); k++) {
                        System.out.print(" ");
                    }

                    System.out.print("| register_no | cgpa |");

                } else {

                    System.out.print("| " + name + " | " + usn + "  | " + String.format("%.2f", cgpa) + " |");

                }

            }

            System.out.println();

        }

    }

}

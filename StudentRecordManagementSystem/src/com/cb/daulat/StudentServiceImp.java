package com.cb.daulat;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentServiceImp implements StudentService {
	
	private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
	
	// Add student
    public void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Check for duplicate ID
            for (Student s : students) {
                if (s.getId() == id) {
                    System.out.println("Student with this ID already exists.");
                    return;
                }
            }

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Marks: ");
            double marks = Double.parseDouble(scanner.nextLine());

            Student student = new Student(id, name, marks);
            students.add(student);
            System.out.println("Student added successfully.");
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input. Please enter correct data.");
        }
    }

    // View all students
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("---- Student Records ----");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Update student by ID
    public void updateStudent() {
    	try {
	        System.out.print("Enter ID of the student to update: ");
	        int id = Integer.parseInt(scanner.nextLine());
        

	        for (Student s : students) {
	            if (s.getId() == id) {
	                System.out.print("Enter new name: ");
	                s.setName(scanner.nextLine());
	
	                System.out.print("Enter new marks: ");
	                s.setMarks(Double.parseDouble(scanner.nextLine()));
	
	                System.out.println("Student updated successfully.");
	                return;
	            } 
	            }
            }catch (NumberFormatException ex) {
                System.out.println("Invalid input. Please enter a number.");
                return;
        }

        System.out.println("Student not found.");
    }

    // Delete student by ID
    public void deleteStudent() {
        System.out.print("Enter ID of the student to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}

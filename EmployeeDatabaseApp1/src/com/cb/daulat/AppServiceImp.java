package com.cb.daulat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AppServiceImp implements AppService{
	
	private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    
    private static final String USER = "root"; 
    private static final String PASSWORD = "8006";
    
	private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
	
	public void addEmployee(Scanner sc) {
        System.out.print("Enter Name: ");
        sc.nextLine(); // consume leftover newline
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, dept);
            stmt.setDouble(3, salary);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " employee(s) added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void viewEmployees() {
        String sql = "SELECT * FROM employees";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("\n--- Employee List ---");
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void updateEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter New Name: ");
        String name = sc.nextLine();
        System.out.print("Enter New Department: ");
        String dept = sc.nextLine();
        System.out.print("Enter New Salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE employees SET name=?, department=?, salary=? WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, dept);
            stmt.setDouble(3, salary);
            stmt.setInt(4, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " employee(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public void deleteEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            System.out.println(rows + " employee(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

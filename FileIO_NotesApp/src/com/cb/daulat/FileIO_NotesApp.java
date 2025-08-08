package com.cb.daulat;

import java.util.Scanner;

public class FileIO_NotesApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		NotesServiceImp notes = new NotesServiceImp();
        int choice;

        do {
            System.out.println("\n===== Notes Manager =====");
            System.out.println("1. Add a new note");
            System.out.println("2. View all notes");
            System.out.println("3. Edit a note");
            System.out.println("4. Delete a note");
            System.out.println("5. Search notes");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> notes.addNote();
                case 2 -> notes.viewNotes();
                case 3 -> notes.editNote();
                case 4 -> notes.deleteNote();
                case 5 -> notes.searchNotes();
                case 6 -> System.out.println("Exiting... Thanks for Use!");
                default -> System.out.println("Invalid choice! Please enter 1-6.");
            }
        } while (choice != 6);

        scanner.close();
    }

	}

package com.cb.daulat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotesServiceImp implements INotesService{
	Scanner scanner = new Scanner(System.in);
	private static final String FILE_NAME = "notes.txt";
	// Add new note
    public void addNote() {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            System.out.print("Enter your note: ");
            String note = scanner.nextLine();
            fw.write(note + System.lineSeparator());
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // View all notes
    public List<String> viewNotes() {
        List<String> notes = loadNotes();
        if (notes.isEmpty()) {
            System.out.println("(No notes found!)");
        } else {
            System.out.println("\n--- Saved Notes ---");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i));
            }
        }
        return notes;
    }

    // Edit a note
    public void editNote() {
        List<String> notes = viewNotes();
        if (notes.isEmpty()) return;

        System.out.print("Enter note number to edit: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < notes.size()) {
            System.out.print("Enter new content: ");
            String newContent = scanner.nextLine();
            notes.set(index, newContent);
            saveNotes(notes);
            System.out.println("Note updated successfully!");
        } else {
            System.out.println("Invalid note number!");
        }
    }

    // Delete a note
    public void deleteNote() {
        List<String> notes = viewNotes();
        if (notes.isEmpty()) return;

        System.out.print("Enter note number to delete: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            saveNotes(notes);
            System.out.println("Note deleted successfully!");
        } else {
            System.out.println("Invalid note number!");
        }
    }

    // Search notes
    public void searchNotes() {
        List<String> notes = loadNotes();
        if (notes.isEmpty()) {
            System.out.println("(No notes found!)");
            return;
        }

        System.out.print("Enter keyword to search: ");
        String keyword = scanner.nextLine().toLowerCase();

        System.out.println("\n--- Search Results ---");
        boolean found = false;
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).toLowerCase().contains(keyword)) {
                System.out.println((i + 1) + ". " + notes.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching notes found.");
        }
    }

    // Load all notes from file
    public List<String> loadNotes() {
        List<String> notes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                notes.add(line);
            }
        } catch (FileNotFoundException e) {
            // Ignore if file doesn't exist yet
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return notes;
    }

    // Save all notes back to file (overwrite)
    public void saveNotes(List<String> notes) {
        try (FileWriter fw = new FileWriter(FILE_NAME, false)) { // overwrite mode
            for (String note : notes) {
                fw.write(note + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}

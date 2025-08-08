package com.cb.daulat;

import java.util.List;

public interface INotesService {
		
	// Add new note
	public void addNote();
	
	// View all notes
	public List<String> viewNotes();
    
    // Edit a note
	public void editNote();
    
    // Delete a note
	public void deleteNote();
    
    // Search notes
	public void searchNotes();
    
    // Load all notes from file
	public List<String> loadNotes();
    
 // Save all notes back to file (overwrite)
	public void saveNotes(List<String> notes);

}

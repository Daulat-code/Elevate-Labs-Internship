package com.cb.daulat;

import javax.swing.SwingUtilities;

public class GUIToDoApp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
            new ToDoApp().setVisible(true);
        });

	}

}

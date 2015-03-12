package ch.grademasters.view;

import java.awt.BorderLayout;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class GradeMastersView extends JFrame {
	
	//Bilder & Button fuer Toolbar laden
	private static final Icon addNoteIconLarge = loadIcon("add.png");
	protected final JButton addButton = new JButton(addNoteIconLarge);
	
	//Toolbar
	protected final JToolBar maintoolBar = new JToolBar();
	

	//Buttons an Toolbar anhaengen
	addButton.setToolTipText("Ein neues Camper Arrangement erstellen...");

	// Add buttons to tool bar
	mainToolBar.add(addButton);
	
	
	
	
	
	
	
	
	/**
	 * Loads an icon from the resource folder images.
	 * 
	 * @param iconName
	 *            Name of the icon to load
	 * @return The icon.
	 */
	private static Icon loadIcon(String iconName) {
		final URL resource = GradeMastersView.class
				.getResource("/images/" + iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println("Error in " + GradeMastersView.class.getName()
					+ ": Icon /images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}
	
	public static void main (String[] args){
		GradeMastersView gui = new GradeMastersView();
		gui.setSize(500, 300);
		gui.setVisible(true);
	}

}
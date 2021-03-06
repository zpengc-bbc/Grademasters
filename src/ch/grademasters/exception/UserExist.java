package ch.grademasters.exception;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.grademasters.view.GradeMastersView;

/**
 * @description Exceptionklasse wenn User bereits existiert.
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * UserError.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class UserExist extends JDialog {

	private static final long serialVersionUID = 1L;
	
	//JPanel 
	protected JPanel error = new JPanel(new CardLayout());
	protected JPanel errorCard = new JPanel(new FlowLayout());

	
	//Buttons
	private final Icon errorImg = GradeMastersView.loadIcon("cancel.png");
	protected final JLabel errorImgButton = new JLabel(errorImg);
	protected final JButton ok = new JButton("Ok");

	//JLabels
	protected JLabel sqlErrorLabel = new JLabel(
			"Dieser Username ist bereits vorhanden");

	//User Exist Field
	public UserExist() {

		//Eigenschaften definieren
		setSize(250, 115);
		setVisible(true);
		setResizable(false);

		//hinzufuegen
		errorCard.add(errorImgButton, BorderLayout.NORTH);
		errorCard.add(sqlErrorLabel, BorderLayout.CENTER);
		errorCard.add(ok, BorderLayout.SOUTH);
		error.add(errorCard);

		this.add(error);

		//ActionListener hinzufuegen
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verstecken
				setVisible(false);
				//wegraumen
				dispose();
			}
		});

	}

}

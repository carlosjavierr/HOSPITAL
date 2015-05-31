package gui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.JEditorPane;
import java.awt.TextArea;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
/**
 * 
 * @author Carlos Javier Garcia Escribano
 *
 */
public class Acercade extends JDialog {

	private final JPanel contentPanel = new JPanel();


	public Acercade() {
		setTitle("Acerca de");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 435, 277);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(310, 215, 91, 23);
		
		getContentPane().setLayout(null);
		getContentPane().add(btnOk);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GNU General Public Licence", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(27, 48, 374, 156);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(6, 16, 362, 133);
		panel.add(textArea);
		textArea.setText("This program is free software; you can redistribute it and/or modify\r\n it under the terms of the GNU General "
				+ "Public License as published \r\nby the Free Software Foundation; either version 2 of the License, or\r\n (at your option) "
				+ "any later version.\r\n\r\nThis program is distributed in the hope that it will be useful, but \r\nWITHOUT ANY WARRANTY; "
				+ "without even the implied warranty\r\n of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.\r\n  See the GNU General "
				+ "Public License for more details. ");
		
		JLabel lblAuthor = new JLabel("Author: Carlos Javier Garcia Escribano");
		lblAuthor.setBounds(21, 16, 283, 14);
		getContentPane().add(lblAuthor);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}